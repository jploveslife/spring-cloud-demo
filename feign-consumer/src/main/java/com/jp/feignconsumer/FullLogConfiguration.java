package com.jp.feignconsumer;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/5/13 8:32
 */
@Configuration
public class FullLogConfiguration {


    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }


}
