package com.chinasoft.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * Created by VerRan.Liu on 2017/8/31.
 */
@SpringBootApplication
@EnableConfigServer //启动配置管理服务器功能
@EnableDiscoveryClient //启动发现服务客户端功能，以便Eureka 服务器自动发现并管理该服务
public class ConfigApplication {
    public static  void  main(String[] args){
        SpringApplication.run(ConfigApplication.class,args);
    }
}
