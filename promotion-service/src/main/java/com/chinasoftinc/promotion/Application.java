package com.chinasoftinc.promotion;

import io.servicecomb.foundation.common.utils.BeanUtils;
import io.servicecomb.foundation.common.utils.Log4jUtils;
import io.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by VerRan.Liu on 2017/9/18.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableServiceComb //新增注解
public class Application {
    public static void main(String args[]){
        try {
            Log4jUtils.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanUtils.init();
        SpringApplication.run(Application.class,args);
    }

}
