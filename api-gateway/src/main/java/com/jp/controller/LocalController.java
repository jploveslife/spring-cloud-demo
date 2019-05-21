package com.jp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/5/21 8:00
 */
@RestController
public class LocalController {


    @RequestMapping("/local/hello")
    public String hello(){
        return "hello";
    }



}
