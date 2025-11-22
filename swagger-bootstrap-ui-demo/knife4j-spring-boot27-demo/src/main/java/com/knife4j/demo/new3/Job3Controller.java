/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */
package com.knife4j.demo.new3;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.knife4j.demo.model.MapEnumUser;
import com.knife4j.demo.model.ModelUser;
import com.knife4j.demo.model.RangeSysUser;
import com.knife4j.demo.model.SysUser;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @since:knife4j-spring-boot-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 23:42
 */
@Slf4j
@Api(tags = "job3-20210501")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping(value = "/job3",produces = MediaType.APPLICATION_JSON_VALUE)
public class Job3Controller {

    @ApiOperation(value = "range展示")
    @PostMapping("/rangeUser")
    public ResponseEntity<RangeSysUser> range(RangeSysUser rangeSysUser){

        return ResponseEntity.ok(rangeSysUser);
    }


    @GetMapping("/download")
    public void download(HttpServletResponse response){
        String path="/Users/xiaoyumin/Desktop/mac-app/robot_chat_info.xlsx";
        log.info("download-path:{}",path);
        response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
        ServletUtil.write(response,new File(path));
    }

    @ApiOperation(value = "API_JOB_I18n",notes = "API_JOB_I18n_DESC")
    @PostMapping("/hidden3")
    public ResponseEntity<ModelUser> i18n3(@RequestBody ModelUser sysUser){
        return ResponseEntity.ok(sysUser);
    }


    @GetMapping("/multi")
    @ApiOperation("批量获取字典数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", allowMultiple = true, name = "codes", value = "字典编码")
    })
    public ResponseEntity<String[]> multiDict(@RequestParam String[] codes) {
        return ResponseEntity.ok(codes);
    }

    @PostMapping("/oauth")
    public ResponseEntity<Map<String,Object>> oauth(){
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("token_type","Benear");
        map.put("access_token", RandomUtil.randomString(64));
        return ResponseEntity.ok(map);
    }


    @ApiOperation(value = "枚举可用值")
    @PostMapping("/mo")
    public ResponseEntity<MapEnumUser> mo(@RequestBody MapEnumUser mapEnumUser){
        return ResponseEntity.ok(mapEnumUser);
    }

    @ApiOperation(value = "枚举可用值1")
    @PostMapping("/mo1")
    public ResponseEntity<MapEnumUser> mo1( MapEnumUser mapEnumUser){
        return ResponseEntity.ok(mapEnumUser);
    }
    @ApiOperation(value = "枚举可用值2")
    @PutMapping("/mo2")
    public ResponseEntity<MapEnumUser> mo12( MapEnumUser mapEnumUser){
        return ResponseEntity.ok(mapEnumUser);
    }
}
