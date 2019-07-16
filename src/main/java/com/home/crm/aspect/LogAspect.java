package com.home.crm.aspect;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
  * 类名：LogAspect.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
@Component
@Aspect
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.home.crm.controller.*.*(..))")
    public void log()
    {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint)
    {
        logger.info(LocalDateTime.now().toString()+" 方法执行前");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  sra.getRequest();
        logger.info("url:{}",request.getRequestURI());
        logger.info("ip:{}",request.getRemoteAddr());
        logger.info("method:{}",request.getMethod());
        logger.info("class_method:{}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args:{}", joinPoint.getArgs());
//        logger.info("args:{}", Arrays.toString(joinPoint.getArgs()));
    }

    @After("log()")
    public void doAfter(JoinPoint joinPoint)
    {
        String msg = "class："+joinPoint.getTarget().getClass().getName()
                +" method: "+joinPoint.getSignature().getName()+" args: "+Arrays.toString(joinPoint.getArgs());

        logger.info(LocalDateTime.now().toString()+" 方法执行完成");
        logger.info(msg);
    }

    @AfterReturning(pointcut = "log()",returning = "result")
    public void doAfterReturning(Object result)
    {
        logger.info("方法返回：{}",result);
    }

}
