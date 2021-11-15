package com.java.shop.service;

import com.java.shop.entity.Company;

public interface CompanyService {
    int insert(Company company);

    int update(Company company);

    int remove(Integer id);
}
