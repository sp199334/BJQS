package com.home.crm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;



/**
  * 类名：SysUserRole.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
@Entity
public class SysUserRole {
    @Id
    @GenericGenerator(name="generator",strategy = "native")
    @GeneratedValue(generator = "generator")
    private Integer id; // 编号
    private Integer userId;
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
