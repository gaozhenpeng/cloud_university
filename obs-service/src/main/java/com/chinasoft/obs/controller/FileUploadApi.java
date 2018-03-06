package com.chinasoft.obs.controller;

import com.chinasoft.obs.service.StorageService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by VerRan.Liu on 2017/10/24.
 */
@RestController
public class FileUploadApi {


    private final StorageService storageService;

    @Autowired
    public FileUploadApi(StorageService storageService) {
        this.storageService = storageService;
    }

    @ApiOperation(value="文件上传接口", notes="文件上传接口")
    @ApiImplicitParam(name = "file", value = "file", required = true, dataType = "MultipartFile")
    @PostMapping("/file/upload")
    //返回文件名称， 如果要访问图片路径为 http://ip:port/files/img_name
    public String upload(@RequestParam("file") MultipartFile file){
        return   storageService.store(file);

    }
}
