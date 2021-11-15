package com.java.shop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.shop.entity.Company;
import com.java.shop.entity.CompanyExample;
import com.java.shop.mapper.CompanyMapper;
import com.java.shop.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 新增公司信息
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Boolean addCompanyDatails(@RequestBody Company company) {
        try{
            int insert = companyService.insert(company);
            return insert == 1;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 修改公司信息
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Boolean updateCompanyDetails(@RequestBody Company company) {
        try{
            int update = companyService.update(company);
            return update == 1;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 根据条件来获取对应的公司信息，条件我认为有公司名称，公司地点
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public List<Company> searchCompanyDetails(String name, String address, Integer pageNum, Integer pageSize) {
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        if(name != null) {
            criteria.andNameEqualTo(name);
        }
        if(address != null) {
            criteria.andAddressEqualTo(address);
        }
        example.setOrderByClause("create_time desc");
        PageHelper.startPage(pageNum,pageSize);
        List<Company> companyList = companyMapper.selectByExample(example);
        //可能将来会分页所以保存一份分页数据
        PageInfo<Company> pageInfo = new PageInfo<>(companyList);
        return companyList;
    }

    /**
     * 删除公司信息，根据id删除
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public Boolean removeCompanyDetails(Integer id) {
        try{
            return companyService.remove(id) == 1;
        } catch (Exception e) {
            return false;
        }
    }
}
