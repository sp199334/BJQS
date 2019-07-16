package com.home.crm.model;

/**
  * 类名：ISysRolePermission.java
  * 类说明： 角色权限对照表，列出全部权限，没有权限的role和roleId为null
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface ISysRolePermission {
    Integer getRoleId();
    String getRole();
    Integer getPermissionId();
    String getPermission();
    String getPermissionName();
    Integer getParentId();

}
