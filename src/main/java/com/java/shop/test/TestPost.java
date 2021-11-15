package com.java.shop.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test")
public class TestPost {

    //post请求数据非json
    @RequestMapping(method = RequestMethod.POST, value = "nojson")
    public void noJson(TestEntity entity) {
        System.out.println(entity.toString());
    }

    @RequestMapping(method = RequestMethod.POST, value = "json")
    public void json(@RequestBody TestEntity entity) {
        System.out.println(entity.toString());
    }
}
