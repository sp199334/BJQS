package com.home.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.home.crm.entity.Baby;

/**
  * 类名：BabyRepository.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface BabyRepository extends JpaRepository<Baby,Long> {

     List<Baby> findByCustomerId(Long customerId);

     @Modifying
     @Query(value = "delete from baby where customerId=?1",nativeQuery = true)
     int deleteByCustomerId(Long customerId);

     int deleteBabiesByCustomerId(Long customerId);
}
