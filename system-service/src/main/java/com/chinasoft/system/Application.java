package com.chinasoft.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by VerRan.Liu on 2017/9/18.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    public static void main(String args[]){
        SpringApplication.run(Application.class,args);
    }

}
