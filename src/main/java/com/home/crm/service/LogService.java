package com.home.crm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.home.crm.entity.SysLog;


/**
  * 类名：LogService.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface LogService {
    void writeLog(String action,String event);
    void save(SysLog sysLog);
    Page<SysLog> findAll(Pageable pageable);
    Page<SysLog> findAllByUserNameContains(String userName, Pageable pageable);
    Page<SysLog> findAll(String searchText,Pageable pageable);
}
