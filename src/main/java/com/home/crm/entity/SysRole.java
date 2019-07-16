package com.home.crm.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.home.crm.model.ISysRolePermission;

/**
  * 类名：SysRole.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
@Entity
public class SysRole {
    @Id
    @GenericGenerator(name="generator",strategy = "native")
    @GeneratedValue(generator = "generator")
    private Integer roleId; // 编号

    @Column(nullable = false, unique = true)
    @NotBlank(message ="名称不能为空")
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; // 是否可用,如果不可用将不会添加给用户，

    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiredDate;//过期日期

    //角色 -- 权限关系：多对多关系;
//    @JsonIgnore
//    @ManyToMany(fetch= FetchType.EAGER)
//    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    @Transient
    private List<ISysRolePermission> permissions;

    // 用户 - 角色关系定义;
//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="userId")})
//    private List<User> users;// 一个角色对应多个用户


    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<ISysRolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<ISysRolePermission> permissions) {
        this.permissions = permissions;
    }

}
