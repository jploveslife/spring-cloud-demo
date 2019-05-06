package com.jp.eurekaclient.controller;

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
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    private Registration registration; // 服务注册

    @RequestMapping("/hello")
    public Object hello() throws InterruptedException {

        /**
         * 让线程等待几秒，触发hystrix的超时
         * Hystrix 的默认超时时间为2000毫秒
         */
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime : " + sleepTime);
//        Thread.sleep(sleepTime);

        logger.info("/hello ,host:{},service_id:{}",registration.getHost(),registration.getServiceId());
        return "Hello World";
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name){
        return "hello" + name;
    }


    @RequestMapping("/hello2")
    public User hello2(@RequestHeader String name,@RequestHeader Integer age){
        return new User(name,age);
    }

    @RequestMapping("/hello3")
    public String hello3(@RequestBody User user){
        return "Hello "+ user.getName() + "," + user.getAge();
    }
}
