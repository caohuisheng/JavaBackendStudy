package com.xiaominfo.knife4j.demo.web;

import com.xiaominfo.knife4j.demo.model.v41.ConfigPageParam;
import com.xiaominfo.knife4j.demo.model.v45.UserListBo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2024/1/7 21:38
 * @since knife4j-springdoc-openapi-demo
 */
@Tag(name = "测试模块2")
@RestController
@RequestMapping("/test2")
public class Test2Controller {


    @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
    @Operation(summary = "描述2")
    @PostMapping("/description")
    public ResponseEntity<UserListBo> description(@RequestBody UserListBo listBo){
        return ResponseEntity.ok(listBo);
    }

}
