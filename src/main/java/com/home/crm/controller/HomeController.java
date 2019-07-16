package com.home.crm.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.home.crm.model.LoginResult;
import com.home.crm.service.LogService;
import com.home.crm.service.LoginService;


/**
  * 类名：HomeController.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
@Controller
public class HomeController {
    @Resource
    private LoginService loginService;

    @Resource
    DefaultKaptcha defaultKaptcha;

    @Resource
    LogService logService;

    private long verifyTTL = 60;//验证码过期时间60秒

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }


    /**
     * 2、生成验证码
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/getVerifyCode")
    public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        byte[] bytesCaptchaImg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("verifyCode", createText);
            request.getSession().setAttribute("verifyCodeTTL", System.currentTimeMillis());
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage bufferedImage = defaultKaptcha.createImage(createText);
            ImageIO.write(bufferedImage, "jpg", jpegOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        bytesCaptchaImg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(bytesCaptchaImg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }


    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "/user/403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(Map<String, Object> map, HttpServletRequest request) {
        loginService.logout();
        return "/user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Map<String, Object> map, HttpServletRequest request) throws Exception {
        System.out.println("login()");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        String verifyCode = request.getParameter("verifyCode");
        String rightCode = (String) request.getSession().getAttribute("verifyCode");
        Long verifyCodeTTL = (Long) request.getSession().getAttribute("verifyCodeTTL");
        Long currentMillis = System.currentTimeMillis();
        if (rightCode == null || verifyCodeTTL == null) {
            map.put("msg", "请刷新图片，输入验证码！");
            map.put("userName", userName);
            map.put("password", password);
            return "/user/login";
        }
        Long expiredTime = (currentMillis - verifyCodeTTL) / 1000;
        if (expiredTime > this.verifyTTL) {
            map.put("msg", "验证码过期，请刷新图片重新输入！");
            map.put("userName", userName);
            map.put("password", password);
            return "/user/login";
        }

        if (!verifyCode.equalsIgnoreCase(rightCode)) {
            map.put("msg", "验证码错误，请刷新图片重新输入！");
            map.put("userName", userName);
            map.put("password", password);
            return "/user/login";
        }

        LoginResult loginResult = loginService.login(userName, password);
        if (loginResult.isLogin()) {
            map.put("userName", userName);
            logService.writeLog("登录","登录成功");
            return "/index";
        } else {
            map.put("msg", loginResult.getResult());
            map.put("userName", userName);
            return "/user/login";
        }
    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session) {
        loginService.logout();
        logService.writeLog("logout","成功");
        return "/user/login";
    }


}
