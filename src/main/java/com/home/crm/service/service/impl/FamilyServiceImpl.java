package com.home.crm.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.crm.entity.Family;
import com.home.crm.repository.FamilyRepository;
import com.home.crm.service.FamilyService;

/**
  * 类名：FamilyServiceImpl.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Override
    public Family findById(Long id) {
        return familyRepository.findById(id).orElse(new Family());
    }

    @Override
    public List<Family> findByCustomerId(Long customerId) {
        return familyRepository.findByCustomerId(customerId);
    }

    @Override
    public Family save(Family family) {
        return familyRepository.save(family);
    }

    @Override
    public boolean delete(Long id) {
        try {
            familyRepository.deleteById(id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int deleteByCustomerId(Long id) {
        return familyRepository.deleteFamiliesByCustomerId(id);
    }
}
