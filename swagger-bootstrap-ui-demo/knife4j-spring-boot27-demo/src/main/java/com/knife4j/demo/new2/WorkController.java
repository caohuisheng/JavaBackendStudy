/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * Official Web Site: http://www.xiaominfo.com.
 */
package com.knife4j.demo.new2;

import cn.hutool.core.util.RandomUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.knife4j.demo.model.MapUser;
import com.knife4j.demo.model.SysUser;
import com.knife4j.demo.model.SysUserTime;
import com.knife4j.demo.model.UserMessageRecordVOList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @since:knife4j-spring-boot-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 23:42
 */
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping("/work")
public class WorkController {

    @PostMapping("/orderList")
    public ResponseEntity<String> orderList(){
        return ResponseEntity.ok(RandomUtil.randomNumbers(12));
    }


    @PostMapping("/orderList1")
    public ResponseEntity<SysUser> orderList1(SysUser sysUser){
        return ResponseEntity.ok(sysUser);
    }


    @PostMapping("/orderList2")
    @ApiOperation(value = "LocalDateTime测试")
    public ResponseEntity<SysUserTime> orderList21(SysUserTime sysUser){
        return ResponseEntity.ok(sysUser);
    }
    @PostMapping("/orderList2-body")
    @ApiOperation(value = "LocalDateTime测试1")
    public ResponseEntity<SysUserTime> orderList221(@RequestBody SysUserTime sysUser){
        return ResponseEntity.ok(sysUser);
    }

    @PostMapping("/orderList2-header")
    @ApiOperation(value = "LocalDateTime测试-header")
    public ResponseEntity<SysUserTime> orderList212(
            @RequestHeader("depId") Long depId,
            @RequestHeader("userId") Long userId,
            SysUserTime sysUser){
        return ResponseEntity.ok(sysUser);
    }

    @GetMapping("/html")
    @ApiOperation(value = "html响应")
    public void html(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://www.baidu.com");
    }

    @GetMapping("/html1")
    @ApiOperation(value = "html响应1")
    public void html1(HttpServletResponse response) throws IOException {
        response.sendRedirect("/job/i18n");
    }

    @GetMapping("/html2")
    @ApiOperation(value = "html响应2")
    public void html2(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8080/job/i18n");
    }



    @GetMapping("/definition")
    @ApiOperation(value = "definition")
    public ResponseEntity<UserMessageRecordVOList> definition(HttpServletResponse response) throws IOException {
        return ResponseEntity.ok(new UserMessageRecordVOList());
    }


    @GetMapping("/mpuser")
    @ApiOperation(value = "mpuser")
    public ResponseEntity<MapUser> MapUser(HttpServletResponse response) throws IOException {
        return ResponseEntity.ok(new MapUser());
    }
}
