/*
 * Copyright (C) 2022 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */
package com.knife4j.demo.new1;

import cn.hutool.core.util.RandomUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.knife4j.demo.model.SysUserAllow;
import com.knife4j.demo.model.SysUserAllow1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @since:knife4j-spring-boot27-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/9/4 19:41
 */
@Slf4j
@Api(tags = "file-20210502")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping(value = "/file",produces = MediaType.APPLICATION_JSON_VALUE)
public class FileUploadController {

    @ApiOperation(value = "批量上传文件")
    @PostMapping("/batchUpload")
    @ApiImplicitParam(name = "files",value = "文件",required = true,paramType = "form",allowMultiple = true,dataType = "MultipartFile")
    public ResponseEntity<String> uploadBatch(@RequestPart("files")List<MultipartFile> files){

        return ResponseEntity.ok(files.stream().map(MultipartFile::getOriginalFilename).collect(Collectors.joining()));
    }

    @ApiOperation(value = "文件上传-带参数Header")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token",value = "请求token",required = true,paramType = "header"),
            @ApiImplicitParam(name = "file",value = "文件",required = true,paramType = "form",allowMultiple = true,dataType = "__File"),
            @ApiImplicitParam(name = "name",value = "文件名称",required = true),
    })
    @PostMapping("/uploadParamHeader")
    public ResponseEntity<String> uploadParamHeader(@RequestHeader("token") String token, @RequestParam("file") MultipartFile[] files, @RequestParam("name") String name){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("token:").append(token);
        for (MultipartFile file:files){
            stringBuilder.append("file:"+file.getOriginalFilename());
        }
        stringBuilder.append("name:").append(name);
        return ResponseEntity.ok(stringBuilder.toString());
    }

    @ApiOperation(value = "文件上传-带参数Header")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file",value = "文件",required = true,paramType = "form",dataType = "__File"),
            @ApiImplicitParam(name = "name",value = "文件名称",required = true),
    })
    @PostMapping("/uploadParamHeader1")
    public ResponseEntity<String> uploadParamHeader1(@RequestParam("file") MultipartFile file, @RequestParam("name") String name){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("token:").append("");
            stringBuilder.append("file:"+file.getOriginalFilename());
        stringBuilder.append("name:").append(name);
        return ResponseEntity.ok(stringBuilder.toString());
    }

    @ApiOperation(value = "allow-示例")
    @PostMapping("/allow")
    public ResponseEntity<SysUserAllow> allowResponseEntity(SysUserAllow sysUserAllow){
        return ResponseEntity.ok(sysUserAllow);
    }

    @ApiOperation(value = "allow-示例2")
    @PostMapping("/allow2")
    public ResponseEntity<SysUserAllow1> allowResponseEntity2(SysUserAllow1 sysUserAllow){
        return ResponseEntity.ok(sysUserAllow);
    }


    @ApiOperation(value = "allow-示例23")
    @PostMapping("/allow32")
    public ResponseEntity<SysUserAllow1> allowResponseEntity23(@RequestBody SysUserAllow1 sysUserAllow){
        return ResponseEntity.ok(sysUserAllow);
    }
}
