package com.home.crm.service.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.home.crm.entity.SysRole;
import com.home.crm.model.ISysRolePermission;
import com.home.crm.repository.RoleRepository;
import com.home.crm.service.RoleService;

/**
  * 类名：RoleServiceImpl.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleRepository roleRepository;

    @Override
    public Page<SysRole> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Optional<SysRole> findById(Integer roleId) {
        return roleRepository.findById(roleId);
    }

    @Override
    public Page<SysRole> findAllByRoleContains(String role, Pageable pageable) {
        return roleRepository.findAllByRoleContains(role,pageable);
    }

    @Override
    public SysRole save(SysRole sysRole) {
        return roleRepository.save(sysRole);
    }

    @Override
    public boolean checkRoleExists(String role) {
        SysRole sysRole = roleRepository.findSysRoleByRole(role);
        if(sysRole!=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean checkRoleExists(String oldRole, String newRole) {
        SysRole sysRole = roleRepository.findSysRoleExists2(oldRole,newRole);
        if(sysRole!=null)
            return true;
        else
            return false;
    }

    //删除角色权限和角色
    @Transactional
    @Override
    public boolean deleteAllByRoleIdIn(List<Integer> roleIdList) {
        try {
            for(Integer roleId:roleIdList)
            {
                roleRepository.deleteRolePermission(roleId);
            }
            roleRepository.deleteAllByRoleIdList(roleIdList);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ISysRolePermission> findSysRolePermissionByRoleId(Integer roleId) {
        return roleRepository.findSysRolePermissionByRoleId(roleId);
    }

    //授权前先清除原角色权限，然后重新新增授权
    @Transactional
    @Override
    public void grantAuthorization(Integer roleId, List<Integer> permissionList) {
        roleRepository.deleteRolePermission(roleId);
        for(Integer permissionId:permissionList)
        {
            roleRepository.insertRolePermission(roleId,permissionId);
        }
    }

    @Transactional
    @Override
    public void clearAuthorization(Integer roleId) {
        roleRepository.deleteRolePermission(roleId);
    }
}
