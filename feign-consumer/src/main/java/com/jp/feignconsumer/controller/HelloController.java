package com.jp.feignconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    public Object hello(){
        return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();
    }

}
