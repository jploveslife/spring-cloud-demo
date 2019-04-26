package com.jp.eurekaclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/24 8:04
 */
@RestController
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    private Registration registration; // 服务注册

    @RequestMapping("/hello")
    public Object hello(){
        logger.info("/hello ,host:{},service_id:{}",registration.getHost(),registration.getServiceId());
        return "Hello World";
    }

}
