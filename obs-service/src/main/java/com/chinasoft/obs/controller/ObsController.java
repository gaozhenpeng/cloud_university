package com.chinasoft.obs.controller;

import com.chinasoft.obs.data.entity.DocumentInfo;
import com.chinasoft.obs.data.entity.ObjectBulk;
import com.chinasoft.obs.service.ObjectBulkService;
import com.chinasoft.obs.vo.DelVO;
import com.chinasoft.obs.vo.DocumentVO;
import com.chinasoft.obs.vo.ObjectBulkVO;
import com.chinasoft.obs.vo.ResponseVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by VerRan.Liu on 2017/11/16.
 */
@RestController
@RequestMapping("/obs")
public class ObsController {
    @Autowired
    private ObjectBulkService service;


    /**
     * 服务路由信息查询，支持根据 对象名称，和对象归属者 模糊查询
     * @param  objectBulkVO
     * @return ResponseVO
     * **/
    @ApiOperation(value="query", notes="查询对象信息")
    @ApiImplicitParam(name = "objectBulkVO", value = "对象信息（为课件时，代表课件信息）", required = true, dataType = "ObjectBulkVO")
    @RequestMapping(path="/query",method = RequestMethod.POST)
    public ResponseVO query(@RequestBody ObjectBulkVO objectBulkVO){
        ResponseVO    responseVO = new ResponseVO();;
        try {
            responseVO = service.query(objectBulkVO);
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }

    @ApiOperation(value="save", notes="增加/更新路由信息")
    @ApiImplicitParam(name = "objectBulk", value = "服务路由信息", required = true, dataType = "ObjectBulk")
    @RequestMapping(path="/save",method = RequestMethod.POST)
    public  ResponseVO save(@RequestBody ObjectBulk objectBulk ){
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO = service.save(objectBulk);
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }


    @ApiOperation(value="delete", notes="删除路由信息")
    @ApiImplicitParam(name = "id", value = "路由ID，当删除多个时已逗号分隔", required = true, dataType = "delVO")
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


    /**
     * 文档信息查询
     * @param  documentVO
     * @return ResponseVO
     * **/
    @ApiOperation(value="query", notes="查询对象信息")
    @ApiImplicitParam(name = "documentVO", value = "文档信息", required = true, dataType = "DocumentVO")
    @RequestMapping(path="/docQuery",method = RequestMethod.POST)
    public ResponseVO docQuery(@RequestBody DocumentVO documentVO){
        ResponseVO    responseVO = new ResponseVO();;
        try {
            responseVO = service.docQuery(documentVO);
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }

    @ApiOperation(value="save", notes="增加/更新文档信息")
    @ApiImplicitParam(name = "documentInfo", value = "文档信息", required = true, dataType = "DocumentInfo")
    @RequestMapping(path="/docSave",method = RequestMethod.POST)
    public  ResponseVO docSave(@RequestBody DocumentInfo documentInfo ){
        ResponseVO responseVO = new ResponseVO();
        try {
            responseVO = service.docSave(documentInfo);
        } catch (Exception e) {
            responseVO.setCode("9000");
            responseVO.setMessage(e.getMessage());
        }
        return responseVO;
    }



}
