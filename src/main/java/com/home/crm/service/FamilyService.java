package com.home.crm.service;

import java.util.List;

import com.home.crm.entity.Family;


/**
  * 类名：FamilyService.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface FamilyService {
    Family findById(Long id);

    List<Family> findByCustomerId(Long customerId);

    Family save(Family family);

    boolean delete(Long id);

    int deleteByCustomerId(Long id);

}
