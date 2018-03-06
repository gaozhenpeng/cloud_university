package com.chinasoft.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
