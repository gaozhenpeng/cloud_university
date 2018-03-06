package com.chinasoft.gateway.controller;

import com.chinasoft.gateway.service.CourseService;
import com.chinasoft.gateway.service.GateWayService;
import com.chinasoft.gateway.service.SystemService;
import com.chinasoft.gateway.vo.RequestVO;
import com.chinasoft.gateway.vo.ResponseVO;
import com.chinasoft.gateway.vo.TokenReqVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by VerRan.Liu on 2017/11/16.
 * V2 版本变更记录
 * 1. 替换路由配置访问为 通过Eureka自动发现访问，访问侧 请求时需要替换serviceCode 为具体的访问路径
 * 2. 增加客户端侧负载均衡机制
 * 3. 增加熔断机制提高服务可用能力
 */
@RestController
@RequestMapping("gateway/v1/api")
//通过CrossOrigin支持跨域访问,如果不添加前端访问时提示类型格式不正确
@CrossOrigin
public class CourseController {

    @Autowired
    GateWayService gateWayService;

    @Autowired
    CourseService courseService;

    /**
     *
     * 课程中心微服务
     *
     * **/
    @ApiOperation(value="课程中心微服务", notes="课程中心微服务")
    @ApiImplicitParam(name = "request", value = "请求信息，具体参见微服务接口协议", required = true, dataType = "RequestVO")
    @RequestMapping(value="/course-service",method = RequestMethod.POST)
    public ResponseVO courseService(@RequestBody RequestVO request,HttpSession session){
        ResponseVO  responseVO=new ResponseVO();
        //1. 校验token
        responseVO = gateWayService.validToken(request.getToken());
        if(!StringUtils.isEmpty(responseVO.getCode())){
            return responseVO;
        }
        //2. 根据服务编码获取对应的url
        responseVO = gateWayService.checkData(request);
        if(!StringUtils.isEmpty(responseVO.getCode())){
            return responseVO;
        }

        //3. 使用restTemplate 调用实际服务并返回数据
        responseVO = courseService.invokeRestService(courseService.getUrl(request),request.getInput());

        return responseVO;
    }
}
