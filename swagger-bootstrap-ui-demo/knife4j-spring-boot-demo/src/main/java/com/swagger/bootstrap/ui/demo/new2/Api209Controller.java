/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.swagger.bootstrap.ui.demo.new2;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.swagger.bootstrap.ui.demo.common.PageVo;
import com.swagger.bootstrap.ui.demo.common.Rest;
import com.swagger.bootstrap.ui.demo.domain.resp196.IgnoreP1;
import com.swagger.bootstrap.ui.demo.domain.resp208.RequestValidateModel;
import com.swagger.bootstrap.ui.demo.domain.resp209.IndexTree;
import com.swagger.bootstrap.ui.demo.domain.resp209.UserListModel;
import com.swagger.bootstrap.ui.demo.domain.resp209.UserListModelRegex;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
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
@Api(tags = "2.0.9版本-20210307")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 279)
@RestController
@RequestMapping("/api/nxew209")
public class Api209Controller {
    Logger logger= LoggerFactory.getLogger(Api209Controller.class);

    @ApiOperationSupport(order = 32,ignoreParameters = {"long.*"})
    @ApiOperation(value = "正则忽略1")
    @PostMapping("/ex1")
    public Rest<IgnoreP1> findAll12(IgnoreP1 ignoreP1) {
        Rest<IgnoreP1> r=new Rest<>();
        r.setData(ignoreP1);
        return r;
    }

    @ApiOperation(value = "正则忽略2",notes = "详见https://gitee.com/xiaoym/knife4j/issues/I21ZKC")
    @ApiOperationSupport(order = 32,ignoreParameters = {"create.*","userListModel.createTime"})
    @PostMapping("/ignoreRegex")
    public Rest<UserListModelRegex> pageVoRest(@RequestBody UserListModelRegex userListModel){
        return Rest.data(userListModel);
    }


    @ApiOperation(value = "正则忽略3",notes = "详见https://gitee.com/xiaoym/knife4j/issues/I21ZKC")
    @ApiOperationSupport(order = 32,ignoreParameters = {"create.*"})
    @PostMapping("/ignoreRegex1")
    public Rest<UserListModelRegex> ignoreRegex1(UserListModelRegex userListModel){
        return Rest.data(userListModel);
    }
    @ApiOperation(value = "泛型-3层",notes = "详见https://gitee.com/xiaoym/knife4j/issues/I2VRD5")
    @PostMapping("/pageVoRest")
    public Rest<PageVo<UserListModel>> pageVoRest(@RequestBody UserListModel userListModel){
        PageVo<UserListModel> pageVo=new PageVo<UserListModel>();
        for (int i=0;i<10;i++){
            pageVo.add(userListModel);
        }
        return Rest.data(pageVo);
    }

    @ApiOperation(value = "注解List示例值时",notes = "详见https://gitee.com/xiaoym/knife4j/issues/I2D6D4")
    @PostMapping("/userList")
    public Rest<UserListModel> userListModelRest(@RequestBody UserListModel userListModel){
        return Rest.data(userListModel);
    }


    @ApiOperation(value = "文件上传参数Null值",notes = "https://gitee.com/xiaoym/knife4j/issues/I3AHDQ")
    @PostMapping("/upload")
    public Rest<String> upload(@RequestParam("uploadFile")MultipartFile multipartFile, @RequestParam(value = "name",required = false)String name){
        logger.info("文件：{}，name:{}",multipartFile.getOriginalFilename(),name);
        return Rest.data(RandomUtil.randomString(5)+",name:"+name);
    }


    @ApiOperation(value = "查找指标树", notes = "查找指标树")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "code", value = "代码", required = false, paramType = "query", dataType = "String", defaultValue = "123")
            ,@ApiImplicitParam(name = "type", value = "类型", required = false, paramType = "query", dataType = "String", defaultValue = "123")
    })
    @PostMapping("findIndexTree")
    public Rest<List<IndexTree>> findIndexTree(String code, String type) {
       return Rest.data(new ArrayList<>());
    }

    @ApiOperation(value = "form文件表单提交响应文件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title",value = "标题",required = true),
            @ApiImplicitParam(name = "file",value = "文件",dataType = "__File",required = true)
    })
    @PostMapping(value = "/multipart",produces = "application/octet-stream")
    public void multipart(@RequestParam(value = "title") String title, @RequestParam(value = "file")MultipartFile file, HttpServletResponse response){
        logger.info("title:"+title+",fileName:"+file.getOriginalFilename());
        String fileName="中文需求.xlsx";
        try {
            //此文件为本机测试
            File excelFile=new File("C:\\Users\\xiaoymin\\Desktop\\高德地图城市编码.xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8;");
            response.addHeader("Content-Disposition", "attachment;FileName=" + URLEncoder.encode(fileName,"utf-8"));
            FileInputStream fis=new FileInputStream(excelFile);
            byte[] b=new byte[1024*1024];
            int r=-1;
            while ((r=fis.read(b))!=-1){
                response.getOutputStream().write(b,0,r);
            }
            response.getOutputStream().flush();
        } catch (IOException e) {
        }
    }

    /**
     * https://gitee.com/xiaoym/knife4j/issues/I2CBZQ
     * @return
     */
    @RequestMapping("/hi")
    @ApiOperation(value = "你好",notes = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    public Rest<String> hi(){
        return Rest.data(RandomUtil.randomString(13));
    }


    /**
     * https://gitee.com/xiaoym/knife4j/issues/I28RJ5
     * @return
     */
    @RequestMapping(value = "/hi1",method = {RequestMethod.POST,RequestMethod.GET})
    @ApiImplicitParam(name = "name",value = "昵称",required = true,defaultValue = "张飞")
    @ApiOperation(value = "method限制")
    public Rest<String> hi1(@RequestParam(value = "name")String name){
        return Rest.data("name:"+name+",random:"+RandomUtil.randomString(13));
    }

    @GetMapping("/html")
    @ApiOperation(value = "响应HTML")
    public void html(HttpServletResponse response){
        ServletUtil.write(response,new File("C:\\Users\\xiaoymin\\Desktop\\test.html"));
    }

    @ApiOperation(value = "表单请求")
    @PostMapping(value = "/req")
    public Rest<RequestValidateModel> req(@RequestBody RequestValidateModel requestValidateModel){
        return Rest.data(requestValidateModel);
    }

    @ApiOperation(value = "测试apiparam")
    @PostMapping(value = "/initw")
    public Rest<String> intw(Integer type){
        return Rest.data(RandomUtil.randomString(5)+type);
    }

    @ApiOperation(value = "测试apiparam1")
    @PostMapping(value = "/initw1")
    public Rest<String> intw1(@ApiParam(value = "类型") Integer type){
        return Rest.data(RandomUtil.randomString(5)+type);
    }

    @ApiOperation(value = "测试loading效果")
    @ApiImplicitParam(name = "second",value = "秒",required = true,defaultValue = "3")
    @GetMapping("/loading")
    public Rest<String> loading(@RequestParam(value = "second") Long second) throws InterruptedException {
        TimeUnit.SECONDS.sleep(second);
        return Rest.data(RandomUtil.randomString(32));
    }
}
