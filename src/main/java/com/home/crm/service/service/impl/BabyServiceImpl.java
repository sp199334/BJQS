package com.home.crm.service.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.home.crm.entity.Baby;
import com.home.crm.repository.BabyRepository;
import com.home.crm.service.BabyService;

/**
  * 类名：BabyServiceImpl.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
@Service
public class BabyServiceImpl implements BabyService {

    @Resource
    private BabyRepository babyRepository;

    @Override
    public Baby findById(Long id) {
        return babyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Baby> findAllByCustomerId(Long customerId) {
        return babyRepository.findByCustomerId(customerId);
    }

    @Override
    public Baby save(Baby baby) {
        return babyRepository.save(baby);
    }

    @Override
    public boolean delete(Long id) {
        try {
            babyRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int deleteByCustomerId(Long customerId) {
        return babyRepository.deleteByCustomerId(customerId);
    }

    @Override
    public int deleteBabiesByCustomerId(Long customerId) {
        return babyRepository.deleteBabiesByCustomerId((customerId));
    }
}
