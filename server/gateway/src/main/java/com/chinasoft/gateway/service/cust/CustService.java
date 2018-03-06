//package com.chinasoft.gateway.service.cust;
//
//import com.chinasoft.gateway.config.RobbinConfiguration;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
///**
// * Created by VerRan.Liu on 2017/8/30.
// *
// * 使用Robbin实现软负载
// */
//
//@RestController
//@RibbonClient(name = "buinsess", configuration = RobbinConfiguration.class)
//public class CustService {
//    Logger logger = LoggerFactory.getLogger(CustService.class);
//
//    @Autowired
//    RestTemplate restTemplate ;
//
//    @LoadBalanced
//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
//
//    @HystrixCommand(fallbackMethod = "custQueryFallBack", commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
//            }
//    )//使用断路器命令注解，配置当后端服务异常时 调用默认方法进行处理
//    @RequestMapping("api/custQuery")//针对需要进行加工的内部服务，通过restTemplate调用，然后进行业务逻辑处理，并返回
//    public String custQuery(@RequestParam(value="name", defaultValue="Artaban")String name){
//        logger.info("API - custQuery start");
//        String custList = restTemplate.getForObject("http://business/cust/query",String.class);
//        logger.info("custList is "+custList);
//        return String.format("%s, %s!", name, custList);
//    }
//
//    public String custQueryFallBack(String name){
//        return name+"Not Found ，Server Error! ";
//    }
//}
