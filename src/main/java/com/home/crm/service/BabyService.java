package com.home.crm.service;

import java.util.List;

import com.home.crm.entity.Baby;


/**
  * 类名：BabyService.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface BabyService {
    Baby findById(Long id);

    List<Baby> findAllByCustomerId(Long customerId);


    Baby save(Baby baby);

    boolean delete(Long id);

    int deleteByCustomerId(Long customerId);

    int deleteBabiesByCustomerId(Long customerId);
}
