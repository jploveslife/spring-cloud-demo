package com.jp.feignconsumer.controller;

import com.jp.feignconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/24 8:04
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public Object hello(){
        return helloService.hello();

    }

}
