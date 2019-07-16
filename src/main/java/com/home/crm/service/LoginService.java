package com.home.crm.service;

import com.home.crm.model.LoginResult;


/**
  * 类名：LoginService.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface LoginService {
    LoginResult login(String userName,String password);
    String getCurrentUserName();
    void logout();
}
