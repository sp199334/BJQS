package com.home.crm.model;

/**
  * 类名：LoginResult.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public class LoginResult {
    private boolean isLogin = false;
    private String result;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
