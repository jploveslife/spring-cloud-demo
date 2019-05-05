package com.jp.hystrixconsumer.controller;

import com.jp.hystrixconsumer.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/24 8:04
 */
@RestController
public class HystrixConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public Object hello(){
        return helloService.hello();
    }

}
