/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.alibaba.excel.EasyExcel;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.swagger.bootstrap.ui.demo.common.PageVo;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp196.IgnoreP1;
import com.swagger.bootstrap.ui.demo.domain.resp208.RequestValidateModel;
import com.swagger.bootstrap.ui.demo.domain.resp209.IndexTree;
import com.swagger.bootstrap.ui.demo.domain.resp209.UserListModel;
import com.swagger.bootstrap.ui.demo.domain.resp209.UserListModelRegex;
import com.swagger.bootstrap.ui.demo.domain.resp210.SysUser;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2021/03/07 10:42
 * @since:knife4j-spring-boot-demo 1.0
 */
@Api(tags = "2.1.0版本-20210501")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping("/api/nxew210")
public class Api210Controller {
    Logger logger= LoggerFactory.getLogger(Api210Controller.class);

    @ApiOperation(value = "下载excel文件" )
    @GetMapping(value = "/xlsx" )
    public void pdf(HttpServletResponse response) throws IOException {
        //创建临时文件
        File tmpFile=new File("/Users/xiaoyumin/Downloads/test/abc.dmg");
        try{
            //响应流
            ServletUtil.write(response,tmpFile);
        }finally {
            //FileUtil.del(tmpFile);
        }
    }
    @ApiOperation(value = "多文件上传")
    @ApiImplicitParam(name = "files",value = "文件",dataType = "MultipartFile",allowMultiple = true)
    @PostMapping("/uploadBatch")
    public ResponseEntity<List<String>> uploadBatch(@RequestParam("files") List<MultipartFile> files){
        List<String> fileResps=new ArrayList<>();
        for (MultipartFile file:files){
            fileResps.add(file.getOriginalFilename());
        }
        return ResponseEntity.ok(fileResps);
    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "名称",defaultValue = "你好",required = true),
            @ApiImplicitParam(name = "title",value = "标题",defaultValue = "我是标题"),
            @ApiImplicitParam(name = "age",value = "年龄",defaultValue = "20")
    })
    @PostMapping("/reuqireParams")
    public Rest<String> requireParams(@RequestParam("name") String name,
                                      @RequestParam(value = "title",required = false) String title,
                                      @RequestParam(value = "age",required = false) Integer age){
        return Rest.data("name:"+name+",title:"+title+",age:"+age);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "名称",example = "你好",required = true),
            @ApiImplicitParam(name = "title",value = "标题",example = "我是标题"),
            @ApiImplicitParam(name = "age",value = "年龄",example = "20")
    })
    @PostMapping("/reuqireParams2")
    public Rest<String> requireParams2(@RequestParam("name") String name,
                                      @RequestParam(value = "title",required = false) String title,
                                      @RequestParam(value = "age",required = false) Integer age){
        return Rest.data("name:"+name+",title:"+title+",age:"+age);
    }
    @ApiOperation(value = "获取用户列表")
    @GetMapping("/getUsers")
    public Rest<List<SysUser>> get(){
        return Rest.data(CollectionUtil.newArrayList(new SysUser()));
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "名称",required = true),
            @ApiImplicitParam(name = "title",value = "标题"),
            @ApiImplicitParam(name = "age",value = "年龄")
    })
    @GetMapping("/reuqireParamsGet")
    public Rest<String> reuqireParamsGet(@RequestParam("name") String name,
                                      @RequestParam(value = "title",required = false) String title,
                                      @RequestParam(value = "age",required = false) Integer age){
        return Rest.data("name:"+name+",title:"+title+",age:"+age);
    }

    @ApiOperation("导出员工人才榜")
    @GetMapping(value = "/excellentUser/export",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void excellentUserExport(HttpServletResponse response) {

        List<SysUser> userRespList = new ArrayList<>();
        for (int i=0;i<10;i++){
            SysUser sysUser=new SysUser();
            sysUser.setUserId(RandomUtil.randomLong());
            sysUser.setDepId(RandomUtil.randomLong());
            userRespList.add(sysUser);
        }
        try {
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), SysUser.class).sheet("模板").doWrite(userRespList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
