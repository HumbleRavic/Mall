package com.java.shop.service.impl;

import com.java.shop.entity.Company;
import com.java.shop.mapper.CompanyMapper;
import com.java.shop.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public int insert(Company company) {
        int insert = companyMapper.insert(company);
        return insert;
    }

    @Override
    public int update(Company company) {
        int update = companyMapper.updateByPrimaryKey(company);
        return update;
    }

    @Override
    public int remove(Integer id) {
        int remove = companyMapper.deleteByPrimaryKey(id);
        return remove;
    }
}
