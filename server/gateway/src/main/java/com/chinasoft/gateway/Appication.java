package com.chinasoft.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * Created by VerRan.Liu on 2017/8/30.
 */
@EnableZuulProxy  //打开Zuul 用于实现反向代理，路由过滤，同时与eureka
// 和 robbin配合实现软负载,此方法属于客户端负载均衡方式，F5 nginx 采用的是服务端负载均衡方式1
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class Appication {
    public static void main(String args[]){
        SpringApplication.run(Appication.class,args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
