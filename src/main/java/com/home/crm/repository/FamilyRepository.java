package com.home.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.crm.entity.Family;


/**
  * 类名：FamilyRepository.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface FamilyRepository extends JpaRepository<Family,Long> {

    List<Family> findByCustomerId(Long customerId);

    int deleteFamiliesByCustomerId(Long customerId);
}
