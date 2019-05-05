package com.jp.hystrixconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/29 8:29
 */
@Service
public class HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     *  HystrixCommand 是熔断器注解 ，fallbackMethod 参数指定请求出错后调用的方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String hello(){
        long start = System.currentTimeMillis();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://hello-service/hello",String.class);

        logger.info("hello-service run time : {}", System.currentTimeMillis() - start);

        return responseEntity.getBody();
    }

    public String helloFallback(){
        return "error";
    }

}
