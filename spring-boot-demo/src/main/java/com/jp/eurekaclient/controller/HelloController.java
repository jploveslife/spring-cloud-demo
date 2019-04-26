package com.jp.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/24 8:04
 */
@RestController
public class HelloController {

    @Value("${book.name}")
    private String name;

    @Value("${book.author}")
    private String author;

    @Value("${book.desc}")
    private String desc;

    @RequestMapping("/hello")
    public Object hello(){
        return "Hello World ; desc: " + this.desc ;
    }

}
