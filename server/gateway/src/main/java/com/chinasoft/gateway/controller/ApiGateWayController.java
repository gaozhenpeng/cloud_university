package com.chinasoft.gateway.controller;

import com.chinasoft.gateway.service.GateWayService;
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
@CrossOrigin
public class ApiGateWayController {

    @Autowired
    GateWayService gateWayService;

    /**
     *
     * token获取
     *
     * **/
    @ApiOperation(value="fetch_token", notes="获取token")
    @ApiImplicitParam(name = "request", value = "使用用户名密码进行token获取", required = true, dataType = "TokenReqVO")
    @RequestMapping(value="/fetch_token",method = RequestMethod.POST)
    public ResponseVO fetch_token(@RequestBody TokenReqVO request,HttpSession session){
        ResponseVO  responseVO=new ResponseVO();
            String sessionId=  session.getId();//简化期间使用sessionId作为token
            if(request.getUserName().equals("user")
                    &&request.getPassword().equals("user")
                    ){
                responseVO.setCode("1");
                responseVO.setMessage("成功");
                responseVO.setToken(sessionId);
                return responseVO;
            }
            else{
                responseVO.setCode("3005");
                responseVO.setMessage("Token认证失败");
            }
        return responseVO;
    }

    /**
     *
     * token释放 退出
     *
     * **/
    @ApiOperation(value="release_token", notes="释放token")
    @RequestMapping(value="/release_token",method = RequestMethod.POST)
    public ResponseVO release_token(HttpSession session){
        ResponseVO tokenRepVO =new ResponseVO();
        String sessionId=  session.getId();
        if(!StringUtils.isEmpty(sessionId)){
            gateWayService.release_token(sessionId);
            tokenRepVO.setCode("1");
            tokenRepVO.setMessage("成功");
            return tokenRepVO;
        }
        else{
            tokenRepVO.setCode("3006");
            tokenRepVO.setMessage("Token释放失败");
        }
        return tokenRepVO;
    }


    /**
     *
     * 通过session获取用户信息
     *
     * **/
    @ApiOperation(value="fetchUserFromSession", notes="通过session获取用户信息")
    @RequestMapping(value="/fetchUserFromSession",method = RequestMethod.POST)
    public ResponseVO fetchUserFromSession(HttpSession session){
       ResponseVO responseVO =new ResponseVO();
        responseVO =  (ResponseVO)session.getAttribute(session.getId());
        if(responseVO==null){
            responseVO=new ResponseVO();
            responseVO.setCode("3005");
            responseVO.setMessage("session已失效");
            return responseVO;
        }
        return responseVO;
    }

}
