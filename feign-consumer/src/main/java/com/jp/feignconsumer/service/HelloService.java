package com.jp.feignconsumer.service;

import com.jp.feignconsumer.fallback.HelloServiceFallback;
import com.jp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/29 8:29
 */

//这里 hello-service 是服务应用名
@FeignClient(name = "hello-service", fallback = HelloServiceFallback.class)
public interface HelloService {

    /**
     * 通过 Feign 创建一个声明式服务调用
     * 通过上面的 执行feignClient和RequestMapping 对应，就是调用hello-service服务中的 /hello 地址
     *
     * 无参数调用
     * @return
     */
    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello1(@RequestParam("name")String name);


    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello2(@RequestHeader("name")String name,@RequestHeader("age")Integer age);


    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello3(@RequestBody User user);

}
