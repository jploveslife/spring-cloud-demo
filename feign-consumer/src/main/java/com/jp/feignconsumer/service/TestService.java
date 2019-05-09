package com.jp.feignconsumer.service;

import com.jp.feignconsumer.DisableHystrixConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: jipeng
 * @Description:
 * @Date: Created in 2019/5/7 7:32
 *
 * 通过 configuration，来指定配置类
 *  这里的DisableHystrixConfiguration 是用来关闭 test-service 服务的熔断
 */
//@FeignClient(name="test-service",configuration = DisableHystrixConfiguration.class)
@FeignClient(name="test-service")
public interface TestService {

    @RequestMapping("/test")
    String test();


}
