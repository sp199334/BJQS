package com.home.crm.service;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.home.crm.entity.User;
import com.home.crm.model.ISysPermission;
import com.home.crm.model.IUserRole;

/**
  * 类名：UserService.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface UserService {
    User findByUserName(String userName);

    Optional<User> findUserById(Integer userId);

    User save(User user);

    boolean checkUserExists(String userName);
    boolean checkUserExists2(String oldUserName,String newUserName);

    List<IUserRole> findUserRoleByUserName(String userName);

    List<IUserRole> findAllUserRoleByUserId(Integer userId);

    List<ISysPermission> findUserRolePermissionByUserName(String userName);

    Page<User> findAllByUserNameContains(String userName, Pageable pageable);

    void deleteAllUserByUserIdList(List<Integer> userIdList);

    void deleteAllUserRoleByUserIdList(List<Integer> userIdList);

    void deleteAllUserRoleByUserId(Integer userId);

    void grantUserRole(Integer userId,List<Integer> roleIdList);
    
}
