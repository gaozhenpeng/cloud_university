package com.chinasoft.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * Created by VerRan.Liu on 2017/8/31.
 */
@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class ZipKinApplication {
    public static void main (String args[]){
        SpringApplication.run(ZipKinApplication.class,args);
    }
}
