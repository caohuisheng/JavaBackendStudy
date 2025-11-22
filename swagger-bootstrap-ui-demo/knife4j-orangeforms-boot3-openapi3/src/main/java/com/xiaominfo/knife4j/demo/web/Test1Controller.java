package com.xiaominfo.knife4j.demo.web;

import cn.hutool.core.util.RandomUtil;
import com.xiaominfo.knife4j.demo.model.FileRequestVo;
import com.xiaominfo.knife4j.demo.model.FileResp;
import com.xiaominfo.knife4j.demo.model.MyBodyTest;
import com.xiaominfo.knife4j.demo.model.v41.ConfigPageParam;
import com.xiaominfo.knife4j.demo.plugin.MyRequestBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/3/14 15:21
 * @since:knife4j-springdoc-openapi-demo
 */
@Tag(name = "测试模块")
@RestController
@RequestMapping("/test")
public class Test1Controller {


    @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
    @Operation(summary = "描述1")
    @PostMapping("/description")
    public ResponseEntity<ConfigPageParam> description(@ParameterObject ConfigPageParam configPageParam){
        return ResponseEntity.ok(configPageParam);
    }
    @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
    @Operation(summary = "描述12")
    @PostMapping("/description2")
    public ResponseEntity<ConfigPageParam> description2(ConfigPageParam configPageParam){
        return ResponseEntity.ok(configPageParam);
    }
    @Operation(summary = "测试一下3")
    @PostMapping(value = "/module/upload3",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> fileModule3(MyBodyTest fileResp, HttpServletResponse response){
        return ResponseEntity.ok(RandomUtil.randomString(23));
    }


    @Operation(summary = "测试一下2")
    @PostMapping(value = "/module/upload2",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> fileModule2(@RequestBody MyBodyTest fileResp, HttpServletResponse response){
        return ResponseEntity.ok(RandomUtil.randomString(23));
    }

    @Operation(summary = "测试一下RequestBody")
    @PostMapping(value = "/module/upload1",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> fileModule1(@RequestBody FileResp fileResp, HttpServletResponse response){
        return ResponseEntity.ok(RandomUtil.randomString(23));
    }

    @Operation(summary = "测试一下-MyRequestBody")
    @PostMapping(value = "/module/upload",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MyBodyTest> fileModule(@MyRequestBody FileRequestVo fileRequestVo, @MyRequestBody FileResp fileResp, HttpServletResponse response){
        MyBodyTest myBodyTest=new MyBodyTest();
        myBodyTest.setFileResp(fileResp);
        myBodyTest.setRequestVo(fileRequestVo);
        return ResponseEntity.ok(myBodyTest);
    }

}
