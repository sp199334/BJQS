package com.home.crm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.home.crm.entity.SysLog;


/**
  * 类名：SysLogRepository.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface SysLogRepository extends JpaRepository<SysLog,Long>,JpaSpecificationExecutor<SysLog> {
    Page<SysLog> findAllByUserNameContains(String userName, Pageable pageable);
}
