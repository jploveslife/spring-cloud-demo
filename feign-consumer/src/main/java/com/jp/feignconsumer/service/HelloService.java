package com.jp.feignconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/29 8:29
 */

//这里 hello-service 是服务应用名
@FeignClient("hello-service")
public interface HelloService {

    /**
     * 通过 Feign 创建一个声明式服务调用
     * @return
     */
    @RequestMapping("/hello")
    String hello();
}
