/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */
package com.knife4j.demo.new1;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @since:knife4j-spring-boot-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 23:42
 */
@Slf4j
@Api(tags = "job-20210502")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping(value = "/job1",produces = MediaType.APPLICATION_JSON_VALUE)
public class Job2Controller {

    @ApiOperation(value = "动态参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "名称",example = "张飞",dataTypeClass = String.class),
            @ApiImplicitParam(name = "money",value = "金钱",example = "123",dataTypeClass = Long.class),
            @ApiImplicitParam(name = "age",value = "年龄",example = "22",dataTypeClass = Integer.class)

    })
    @PostMapping("/params")
    public ResponseEntity<Map<String,String>> params(@ApiIgnore @RequestParam Map<String,String> value){
        return ResponseEntity.ok(value);
    }

    @PostMapping("/orderList")
    public ResponseEntity<String> orderList(HttpServletRequest request){
        log.info("aaa");
        List<String> headerNames= CollectionUtil.newArrayList(request.getHeaderNames());
        for (String header:headerNames){
            log.info("header:{},value:{}",header, StrUtil.join(";",CollectionUtil.newArrayList(request.getHeaders(header))));
        }
        return ResponseEntity.ok(RandomUtil.randomNumbers(12));
    }


    @PostMapping("/orderList1")
    public ResponseEntity<String> orderList1(){
        return ResponseEntity.ok(RandomUtil.randomNumbers(12));
    }



    @ApiOperation(value = "邮箱")
    @ApiImplicitParam(name = "email",value = "邮箱地址",defaultValue = "xiaoymin@foxmail.com",paramType = "path")
    @GetMapping("/test/{email}")
    public ResponseEntity<String> email(@PathVariable("email") String email){
        return ResponseEntity.ok("email:"+email);
    }


    @ApiOperation(value = "Put请求")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "email",value = "邮箱地址",required = true),
            @ApiImplicitParam(name = "name",value = "昵称",required = true)
    })
    @PutMapping(value = "/putMethod",produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> putParam(@RequestParam("email") String email,@RequestParam("name") String name){
        return ResponseEntity.ok("email:"+email);
    }



    @ApiOperation(value = "测试功能-0", notes = "测试功能(domain=other)")
    @PostMapping("/rest")
    public Object rest(HttpServletRequest request, HttpServletResponse response) {
        System.err.println("/test/rest ......");
        return "default method";
    }

    @ApiOperation(value = "测试功能-a", notes = "测试功能A(domain=aaa)")
    @PostMapping(value = "/rest", params = {"domain=aaa"})
    public Object rest_aaa(Integer goodsId, Integer goodsCount) {
        System.err.println("/test/rest_aaa ......" + goodsId + ", " + goodsCount);
        return "AAA";
    }

    @ApiOperation(value = "测试功能-b", notes = "测试功能B(domain=bbb)")
    @PostMapping(value = "/rest", params = {"domain=bbb"})
    public Object restb_bbb(String username, @RequestParam("pwd") String password) {
        System.err.println("/test/rest_bbb ......" + username + ", " + password);
        return "BBB";
    }

    @PutMapping("projects/{name}")
    @ApiOperation(value = "修改一个项目的名称")
    public ResponseEntity<Map<String,Object>> modifyProject(@PathVariable String name,
                                               @RequestBody String newName) {
        log.info("name:"+name+",newName:"+newName);
        Map<String,Object> data=new HashMap<>();
        data.put("name",name);
        data.put("newName",newName);
        return ResponseEntity.ok(data);
    }


    @GetMapping("/parents/{parentId:.+}")
    @ApiOperation(value = "url特殊字符")
    public ResponseEntity<String> list(@PathVariable(name = "parentId") String parentId){
        return ResponseEntity.ok("pid:"+parentId);
    }
}
