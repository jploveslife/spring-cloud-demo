package com.jp;

import com.jp.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/4/26 7:48
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

    public static void main(String[] args){
//        new SpringApplicationBuilder(ApiGatewayApplication.class).web(WebApplicationType.SERVLET).run(args);

        SpringApplication.run(ApiGatewayApplication.class,args);
    }

    /**
     * 过滤器
     * @return
     */
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }


    /**
     * 自定义路由
     * 自定义了路由规则之后，只要符合第一个参数定义规则的服务名，会优先使用自定义的路径表达式
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper(){
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${version}/${name}");
    }


}
