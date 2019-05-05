package com.jp.ribbonconsumer.controller;

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
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hello")
    public Object hello(){
        /**
         * 这里的请求地址是：
         * 服务实例名/路由地址
         * 可以以 GET,POST,PUT,DELETE的方式请求，对应着获取，提交，修改，删除操作
         */
        return restTemplate.getForEntity("http://hello-service/hello",String.class).getBody();

        /**
         * GET 请求
         * 带参数的GET请求，可以传多个参数，下标从1开始
         * 第一个参数是请求地址，第二个是返回类型，第三个是地址里面的参数
         * restTemplate.getForEntity("http://hello-service/user?name={1}",User.class,"jp").getBody();
         * 有三种方式的重载，详见代码
         *
         * 当返回是个对象时，可以这么做
         * User user = restTemplate.getForObject("http://hello-service/user?name={1}",User.class,"jp")
         *
         * POST 请求
         * post请求和get请求大致相同
         *  第一个参数是请求地址，第二个参数是要提交的数据，第三个参数是返回类型
         *  User user = New User("jp",18);
         *  ResponseEntity<String> response = restTemplate.postForEntity("http://hello-service/adduser",user,String.class);
         * String body = response.getBody();
         *
         *  PUT 跟POST 请求一致
         *
         *  DELETE 请求
         *  由于我们通常都是通过唯一标识符去删除数据，基本斗都把参数拼接在url中，所以不需要request数据
         *  delete 请求不需要返回
         *  restTemplate.delete("http://hello-service/user?name={1}","d");
         *
         */




    }

}
