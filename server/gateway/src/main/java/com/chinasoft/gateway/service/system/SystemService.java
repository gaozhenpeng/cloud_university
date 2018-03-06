//package com.chinasoft.gateway.service.system;
//
//import com.chinasoft.gateway.config.RobbinConfiguration;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
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
//
///**
// * Created by VerRan.Liu on 2017/9/6.
// * 用于封装系统管理的微服务
// *
// */
//
//@RestController
///**客户端负载均衡配置*/
//@RibbonClient(name = "system-service", configuration = RobbinConfiguration.class)
//@RequestMapping("/system")
//public class SystemService {
//    Logger logger = LoggerFactory.getLogger(SystemService.class);
//    private static final  String SYSTEM_URL = "http://system-service/users/getUser";
//    @Autowired
//    RestTemplate restTemplate ;
//
//    @LoadBalanced
//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
//
//    @ApiOperation(value="查询用户信息", notes="提供Portal用于查询用户信息")
//    @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "string")
//    @RequestMapping("/getUser")
//    public String getUser(@RequestParam String reqJsonStr){
//        logger.info("getUser start");
//        String userJson = restTemplate.getForObject(SYSTEM_URL,String.class,reqJsonStr);
//        logger.info("getUser end "+userJson);
//        return userJson;
//    }
//
//}
