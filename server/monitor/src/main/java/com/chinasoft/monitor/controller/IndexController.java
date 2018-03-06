package com.chinasoft.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by VerRan.Liu on 2017/9/18.
 */
@Controller
public class IndexController {
    /**进入监控系统首页**/
    @RequestMapping("/")
    public String index(){
        return "index";
    }

//    /**登陆方法**/
//    @RequestMapping("/login")
//    public String login(){
//        return "login";
//    }

//    /**登出方法**/
//    @RequestMapping("/loginOut")
//    public String loginOut(){
//        return "login";
//    }
}
