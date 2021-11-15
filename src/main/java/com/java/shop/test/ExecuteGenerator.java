package com.java.shop.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExecuteGenerator  {
    public static void main(String[] args) throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        File file = new File("D:\\idea_workplace\\mall\\src\\main\\resources\\generator.xml");//配置文件
        List<String> warnings = new ArrayList<>();
        Configuration config = new ConfigurationParser(warnings).parseConfiguration(file);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        //逆向工程的核心类
        MyBatisGenerator generator = new MyBatisGenerator(config,callback,warnings);
        generator.generate(null);
    }
}
