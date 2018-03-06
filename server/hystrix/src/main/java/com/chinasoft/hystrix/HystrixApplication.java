package com.chinasoft.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by VerRan.Liu on 2017/8/31.
 */
@SpringBootApplication
@EnableHystrixDashboard //启动Hystrix 监控程序，用于分布式 微服务监控
@Controller
@EnableDiscoveryClient
public class HystrixApplication {
    @RequestMapping("/")
    public String home(){
        return "/hystrix";
    }

    public  static  void main(String [] args){
        SpringApplication.run(HystrixApplication.class,args);
    }
}