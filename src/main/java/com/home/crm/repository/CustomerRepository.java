package com.home.crm.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.home.crm.entity.Customer;
/**
  * 类名：CustomerRepository.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Page<Customer> findCustomersByCustomerNameContains(String customerName, Pageable pageable);

    List<Customer> findByCustomerNameContains(String customerName);

    List<Customer> findByIdCard(String idCard);

    Customer findByAgreementNum(String agreementNum);

}
