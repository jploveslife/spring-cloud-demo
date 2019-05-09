package com.jp.feignconsumer;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/5/7 8:38
 */
//@Configuration
public class DisableHystrixConfiguration {

    @Bean
    //@Scope("prototype") 设置作用域
    //表示每次获取bean都会生成一个新的对象
    @Scope("prototype")
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }


}
