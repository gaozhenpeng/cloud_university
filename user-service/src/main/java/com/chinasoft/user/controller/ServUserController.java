package com.chinasoft.user.controller;

import com.chinasoft.user.data.entity.CourseComment;
import com.chinasoft.user.data.entity.ServUser;
import com.chinasoft.user.data.entity.ServUserCourse;
import com.chinasoft.user.service.ServUserService;
import com.chinasoft.user.vo.DelVO;
import com.chinasoft.user.vo.ResponseVO;
import com.chinasoft.user.vo.ServUserCourseVO;
import com.chinasoft.user.vo.ServUserVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by VerRan.Liu on 2017/11/17.
 */
@RestController
@RequestMapping("/serv")
public class ServUserController {

    @Autowired
    private ServUserService service;

    /**
     * 服务路由信息查询，支持根据 对象名称，和对象归属者 模糊查询
     * @param  vo
     * @return ResponseVO
     * **/
    @ApiOperation(value="查询用户信息", notes="查询用户信息")
    @ApiImplicitParam(name = "vo", value = "用户信息", required = true, dataType = "ServUserVO")
    @RequestMapping(path="/query",method = RequestMethod.POST)
    public ResponseVO query(@RequestBody ServUserVO vo){
        ResponseVO responseVO = new ResponseVO();;
        try {
            responseVO = service.query(vo);
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }

    @ApiOperation(value="增加/更新用户信息", notes="增加/更新用户信息")
    @ApiImplicitParam(name = "po", value = "用户信息", required = true, dataType = "ServUser")
    @RequestMapping(path="/save",method = RequestMethod.POST)
    public  ResponseVO save(@RequestBody ServUser po ){
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO = service.save(po);
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }


    @ApiOperation(value="删除用户信息", notes="删除用户信息")
    @ApiImplicitParam(name = "delVO", value = "用户ID，当删除多个时已逗号分隔", required = true, dataType = "DelVO")
    @RequestMapping(path="/delete",method = RequestMethod.POST)
    public  ResponseVO delete(@RequestBody DelVO delVO ){
        ResponseVO  responseVO = new ResponseVO();
        try {
            responseVO = service.delete(delVO.getId());
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }


    @ApiOperation(value="用户选择/收藏课程", notes="用户选择/收藏课程")
    @ApiImplicitParam(name = "servUserCourse", value = "用户选课信息", required = true, dataType = "ServUserCourse")
    @RequestMapping(path="/selectCourse",method = RequestMethod.POST)
    public  ResponseVO selectCourse(@RequestBody ServUserCourse servUserCourse ){
        ResponseVO responseVO = new ResponseVO();
        try {
            /**预留选课校验**/
            responseVO = service.selectCourse(servUserCourse);
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }

    @ApiOperation(value="用户选择/收藏课程信息查询", notes="用户选择/收藏课程信息查询，支持根据用户ID查询，用户昵称模糊查询")
    @ApiImplicitParam(name = "servUserCourse", value = "用户选课信息", required = true, dataType = "ServUserCourse")
    @RequestMapping(path="/selectCourseQuery",method = RequestMethod.POST)
    public  ResponseVO selectCourseQuery(@RequestBody ServUserCourseVO servUserCourseVO ){
        ResponseVO responseVO = new ResponseVO();
        try {
            /**预留选课校验**/
            responseVO = service.selectCourseQuery(servUserCourseVO);
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }


    @ApiOperation(value="删除收藏或者选择的课程", notes="用户删除选择/收藏的课程")
    @ApiImplicitParam(name = "servUserCourse", value = "用户选课信息", required = true, dataType = "ServUserCourse")
    @RequestMapping(path="/deleteSelCourse",method = RequestMethod.POST)
    public  ResponseVO deleteSelCourse(@RequestBody DelVO delVO ){
        ResponseVO responseVO = new ResponseVO();
        try {
            /**预留删除已选课程校验**/
            responseVO = service.deleteSelCourse(delVO.getId());
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }


    @ApiOperation(value="用户发布/修改评论", notes="用户发布/修改评论")
    @ApiImplicitParam(name = "courseComment", value = "评论信息", required = true, dataType = "CourseComment")
    @RequestMapping(path="/publishComment",method = RequestMethod.POST)
    public  ResponseVO publishComment(@RequestBody CourseComment courseComment ){
        ResponseVO responseVO = new ResponseVO();
        try {
            /**预留评论发布校验**/
            responseVO = service.publishComment(courseComment);
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }

    @ApiOperation(value="删除评论", notes="删除评论")
    @ApiImplicitParam(name = "courseComment", value = "评论信息", required = true, dataType = "CourseComment")
    @RequestMapping(path="/deleteComment",method = RequestMethod.POST)
    public  ResponseVO deleteComment(@RequestBody DelVO delVO ){
        ResponseVO responseVO = new ResponseVO();
        try {
            /**预留评论删除校验**/
            responseVO = service.deleteComment(delVO.getId());
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }


}
