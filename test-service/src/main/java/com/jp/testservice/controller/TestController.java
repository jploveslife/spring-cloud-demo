package com.jp.testservice.controller;

import com.jp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/24 8:04
 */
@RestController
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);


    @Autowired
    private Registration registration; //服务注册

    @RequestMapping("/test")
    public String hello() throws InterruptedException {
        /**
         * 让线程等待几秒，触发hystrix的超时
         * Hystrix 的默认超时时间为2000毫秒
         */
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime : " + sleepTime);
        Thread.sleep(sleepTime);


        logger.info("/hello ,host:{},service_id:{}",registration.getHost(),registration.getServiceId());
        return "this a test server";
    }


}
