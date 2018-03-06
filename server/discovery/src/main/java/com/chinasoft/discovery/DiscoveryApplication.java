package com.chinasoft.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by VerRan.Liu on 2017/6/26.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {
    public static void main(String args[]){
        SpringApplication.run(DiscoveryApplication.class,args);
    }
}
