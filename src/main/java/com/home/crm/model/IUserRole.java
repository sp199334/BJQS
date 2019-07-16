package com.home.crm.model;

/**
  * 类名：IUserRole.java
  * 类说明： 用于UserRepository自定义返回实体用户与角色对应表
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface IUserRole {
    Integer getUserId();
    String getUserName();
    Integer getRoleId();
    String getRole();
    String getDescription();
}
