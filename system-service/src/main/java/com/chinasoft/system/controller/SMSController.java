package com.chinasoft.system.controller;


import com.chinasoft.system.data.entity.VerCode;
import com.chinasoft.system.service.SMSService;
import com.chinasoft.system.vo.ServerResponse;
import com.chinasoft.system.vo.SmsVO;
import com.chinasoft.system.vo.TokenRepVO;
import com.chinasoft.system.vo.TokenReqVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by VerRan.Liu on 2017/9/30.
 */
@RestController
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    private SMSService SMSService;

    @ApiOperation(value = "fetchToken", notes = "获取华为APItoken")
    @ApiImplicitParam(name = "tokenVO", value = "获取" ,required = true,dataType = "TokenReqVO")
    @PostMapping("/fetchToken")
    public TokenRepVO fetchToken(@RequestBody TokenReqVO tokenVO) {
        TokenRepVO tokenRepVO=null;
        try {
            tokenRepVO = SMSService.fetchToken(tokenVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tokenRepVO;
    }

    /**
     * send sms
     * **/
    @ApiOperation(value = "sendSMS", notes = "发送短信")
    @ApiImplicitParam(name = "smsvo", value = "短信内容" ,required = true,dataType = "SmsVO")
    @PostMapping("/sendSMS")
    public ServerResponse sendSMS(@RequestBody SmsVO smsvo) {
        ServerResponse ret= SMSService.sendSMS(smsvo);
        return ret;
    }

    /**
     * send sms
     * **/
    @ApiOperation(value = "verificationCode", notes = "发送短信验证码")
    @ApiImplicitParam(name = "verCode", value = "短信号码和内容" ,required = true,dataType = "VerCode")
    @PostMapping("/verificationCode")
    public ServerResponse verificationCode(@RequestBody VerCode verCode) {
        ServerResponse ret= SMSService.verificationCode(verCode);
        return ret;
    }

}
