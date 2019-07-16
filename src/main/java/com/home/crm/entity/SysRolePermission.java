package com.home.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
  * 类名：SysRolePermission.java
  * 类说明： 角色权限对照表
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
@Entity
public class SysRolePermission {
    @Id
    @GenericGenerator(name="generator",strategy = "native")
    @GeneratedValue(generator = "generator")
    private Integer id; // 编号
    private Integer roleId; //
    private Integer permissionId;//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
