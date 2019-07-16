package com.home.crm.model;

/**
  * 类名：ISysPermission.java
  * 类说明： 用于UserRepository自定义返回实体 用户与权限对应表
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface ISysPermission {
    Integer getUserId();
    String getUserName();
    Integer getPermissionId();
    String getPermission();
    String getPermissionName();
}
