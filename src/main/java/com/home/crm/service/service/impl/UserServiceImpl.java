package com.home.crm.service.service.impl;


import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.home.crm.entity.User;
import com.home.crm.model.ISysPermission;
import com.home.crm.model.IUserRole;
import com.home.crm.repository.UserRepository;
import com.home.crm.service.UserService;


/**
  * 类名：UserServiceImpl.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;
    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<IUserRole> findUserRoleByUserName(String userName) {
        return userRepository.findUserRoleByUserName(userName);

    }

    @Override
    public List<IUserRole> findAllUserRoleByUserId(Integer userId) {
        return userRepository.findAllUserRoleByUserId(userId);
    }

    @Override
    public List<ISysPermission> findUserRolePermissionByUserName(String userName) {
        return userRepository.findUserRolePermissionByUserName(userName);
    }

    @Override
    public Optional<User> findUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean checkUserExists(String userName) {
        User user =  userRepository.findByUserName(userName);
        if(user!=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean checkUserExists2(String oldUserName, String newUserName) {
        User user = userRepository.findUserExist2(oldUserName,newUserName);

        if(user!=null)
            return true;
        else
            return false;
    }

    @Override
    public Page<User> findAllByUserNameContains(String userName, Pageable pageable) {
        return userRepository.findAllByUserNameContains(userName,pageable);
    }

    @Transactional
    @Override
    public void deleteAllUserByUserIdList(List<Integer> userIdList) {
        userRepository.deleteAllUserRoleByUserIdList(userIdList);
        userRepository.deleteAllUserByUserIdList(userIdList);
    }

    @Transactional
    @Override
    public void deleteAllUserRoleByUserIdList(List<Integer> userIdList) {
        userRepository.deleteAllUserRoleByUserIdList(userIdList);
    }

    @Transactional
    @Override
    public void deleteAllUserRoleByUserId(Integer userId) {
        userRepository.deleteAllUserRoleByUserId(userId);
    }

    @Transactional
    @Override
    public void grantUserRole(Integer userId, List<Integer> roleIdList) {
        userRepository.deleteAllUserRoleByUserId(userId);
        for(Integer roleId:roleIdList)
        {
            userRepository.insertUserRole(userId,roleId);
        }
    }

}
