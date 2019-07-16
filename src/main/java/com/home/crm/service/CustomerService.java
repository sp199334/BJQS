package com.home.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.home.crm.entity.Customer;

/**
  * 类名：CustomerService.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAllByPage(Pageable pageable);

    List<Customer> findAll(Sort sort);

    Optional<Customer> findById(Long id);

    List<Customer> findByCustomerNameContains(String customerName);

    Page<Customer> findByCustomerNameContains(String customerName,Pageable pageable);

    List<Customer> findByIdCard(String idCard);

    Customer findByAgreementNum(String agreementNum);

    Customer save(Customer customer);

    Customer saveAndFlush(Customer customer);

    boolean delete(Long id);
}
