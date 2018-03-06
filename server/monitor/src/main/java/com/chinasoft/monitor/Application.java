package com.chinasoft.monitor;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by VerRan.Liu on 2017/8/31.
 *  使用springbootAdmin 进行微服务的监控
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class Application {

    public  static  void main(String [] args){
        SpringApplication.run(Application.class,args);
    }
}