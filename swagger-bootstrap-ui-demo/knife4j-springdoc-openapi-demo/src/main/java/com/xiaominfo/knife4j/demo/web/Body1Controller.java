/*
 * Copy right © 2022 浙江力石科技股份有限公司 All Rights Reserved.
 * Official Web Site: http://lishiots.com
 */
package com.xiaominfo.knife4j.demo.web;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.xiaominfo.knife4j.demo.model.FileResp;
import com.xiaominfo.knife4j.demo.model.MapEnumUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @since:knife4j-springdoc-openapi-demo
 * @auth <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2022/8/6 16:53
 */
@RestController
@RequestMapping("body1")
@Tag(name = "aaa1参数")
@ApiSupport(order = 12)
public class Body1Controller {
    @Operation(summary = "枚举可用值22")
    @PostMapping("/mo222")
    public ResponseEntity<MapEnumUser> mo333(@RequestBody MapEnumUser mapEnumUser){
        return ResponseEntity.ok(mapEnumUser);
    }
    @Operation(summary = "枚举可用值")
    @PostMapping("/mo")
    public ResponseEntity<MapEnumUser> mo(@RequestBody MapEnumUser mapEnumUser){
        return ResponseEntity.ok(mapEnumUser);
    }

    @Operation(summary = "枚举可用值1")
    @PostMapping("/mo1")
    public ResponseEntity<MapEnumUser> mo1( MapEnumUser mapEnumUser){
        return ResponseEntity.ok(mapEnumUser);
    }

    @Operation(summary = "普通body请求2")
    @PostMapping("/dd/body1")
    public ResponseEntity<FileResp> body23(@RequestBody FileResp fileResp){
        return ResponseEntity.ok(fileResp);
    }

    @Operation(summary = "普通body请求1")
    @PostMapping("/cc/body1")
    public ResponseEntity<FileResp> body2(@RequestBody FileResp fileResp){
        return ResponseEntity.ok(fileResp);
    }

    @Operation(summary = "普通body请求3")
    @PostMapping("/ee/body1")
    public ResponseEntity<FileResp> body(@RequestBody FileResp fileResp){
        return ResponseEntity.ok(fileResp);
    }

}
