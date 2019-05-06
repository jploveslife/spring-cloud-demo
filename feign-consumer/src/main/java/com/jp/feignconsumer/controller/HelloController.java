package com.jp.feignconsumer.controller;

import com.jp.feignconsumer.service.HelloService;
import com.jp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/24 8:04
 */
@RestController
@RequestMapping(value = "/feign")
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public Object hello(){
        return helloService.hello();

    }


    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public Object hello1(@RequestParam String name){
        StringBuilder sb = new StringBuilder("");
        sb.append(helloService.hello()).append("\n")
                .append(helloService.hello1(name)).append("\n")
                .append(helloService.hello2("jp",30)).append("\n")
                .append(helloService.hello3(new User("jp",30))).append("\n");

        return sb.toString();
    }


}
