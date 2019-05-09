package com.jp.feignconsumer.fallback;

import com.jp.feignconsumer.service.HelloService;
import com.jp.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/5/9 7:46
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello1(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public User hello2(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User("未知",0);
    }

    @Override
    public String hello3(@RequestBody User user) {
        return "error";
    }
}
