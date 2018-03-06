package com.chinasoft.gateway.service;

import com.chinasoft.gateway.config.RobbinConfiguration;
import com.chinasoft.gateway.vo.RequestVO;
import com.chinasoft.gateway.vo.ResponseVO;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by VerRan.Liu on 2017/9/20.
 */
@Service
@RibbonClient(name ="user-service", configuration = RobbinConfiguration.class)
public class UserService {
    @Autowired
    RestTemplate restTemplate ;


    //用于处理json
    private Gson gson =new Gson();

    /***
     * @param url,data
     * @return ResponseVO
     * 网关调用 微服务的统一方法 url为调用地址，data 为请求所需的数据
     * */
    @HystrixCommand(fallbackMethod = "userServiceFallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    }
    )//使用断路器命令注解，配置当后端服务异常时 调用默认方法进行处理
    public ResponseVO invokeRestService(String url, Object data) {
        ResponseVO responseVO=new ResponseVO();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity httpEntity=new HttpEntity(gson.toJson(data),httpHeaders);
        ResponseEntity<String> resp =restTemplate.exchange(url, HttpMethod.POST,httpEntity,String.class);
        responseVO= gson.fromJson(resp.getBody(),ResponseVO.class);
        return responseVO;
    }

    public ResponseVO userServiceFallBack(String url, Object data){
        ResponseVO responseVO=new ResponseVO();
        responseVO.setMessage("服务调用异常，服务不可用 请求路径： "+url+"请求数据:"+gson.toJson(data));
        responseVO.setCode("9999");
        return responseVO;
    }

    private static final String SERVICE_NAME ="user-service" ;
    /**
     * 根据请求参数构造URL
     * **/
    public String getUrl(RequestVO request) {
        return "http://"+SERVICE_NAME+"/"+request.getPath();
    }
}
