package com.home.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.home.crm.entity.SysRole;
import com.home.crm.model.ISysRolePermission;


/**
  * 类名：RoleService.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface RoleService {
    Page<SysRole> findAll(Pageable pageable);

    Page<SysRole> findAllByRoleContains(String role, Pageable pageable);

    Optional<SysRole> findById(Integer roleId);

    SysRole save(SysRole sysRole);

    boolean checkRoleExists(String role);

    boolean checkRoleExists(String oldRole,String newRole);

    boolean deleteAllByRoleIdIn(List<Integer> roleIdList);

    List<ISysRolePermission> findSysRolePermissionByRoleId(Integer roleId);

    void grantAuthorization(Integer roleId,List<Integer> permissionList);

    void clearAuthorization(Integer roleId);
}
