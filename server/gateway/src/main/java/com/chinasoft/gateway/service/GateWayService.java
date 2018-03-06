package com.chinasoft.gateway.service;

import com.chinasoft.gateway.vo.RequestVO;
import com.chinasoft.gateway.vo.ResponseVO;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.jdbc.JdbcOperationsSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by VerRan.Liu on 2017/9/20.
 *
 * （1）gateWayService 负责token，session的管理
 * （2）用于 控制不同服务的service调用
 * （3）同时预留对V1版本通过serviceCode方式访问服务的支撑（预留）
 *
 */
@Service
public class GateWayService {
    @Autowired
    JdbcOperationsSessionRepository sessionRepository;

    /**用于处理json**/
    Gson gson =new Gson();

    /***
     * @param token
     * @return ResponseVo
     * 用于校验token的合法性
     * **/
    public ResponseVO validToken(String token) {
        ResponseVO responseVO=new ResponseVO();
        //2. 校验token
        if(StringUtils.isEmpty(token)){
            responseVO.setCode("3001");
            responseVO.setMessage("Token不能为空");
            return responseVO;
        }else{
             Session session = sessionRepository.getSession(token);
           if(session==null){
               responseVO.setCode("3002");
               responseVO.setMessage("Token已失效，请重新获取");
               return responseVO;
           }
        }
        return responseVO;
    }

    /***
     * @param requestVO
     * @Return ResponseVO
     * 通过serviceCode 查询路由配置表获取配置的url
     * */
    public ResponseVO checkData(RequestVO requestVO) {
        ResponseVO responseVO=new ResponseVO();
        if(StringUtils.isEmpty(requestVO.getPath())){
            responseVO.setCode("4003");
            responseVO.setMessage("服务路径不能为空");
            return responseVO;
        }
        return responseVO;
    }


    /**
     * 释放token，相当于退出
     * @param  sessionId
     * @return  TokenRepVO
     * */
    public void release_token(String sessionId) {
        sessionRepository.delete(sessionId);
    }
}
