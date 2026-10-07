package com.chs.springdoc.controller;

import com.chs.springdoc.entity.Result;
import com.chs.springdoc.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@Tag(name = "测试controller", description = "测试相关接口")
@RestController
@RequestMapping("/test")
public class TestController {

    @Operation(summary = "map类型入参(使用schemaProperties)", description = "map类型入参接口")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schemaProperties = {
            @SchemaProperty(name = "name", schema = @Schema(implementation = String.class)),
            @SchemaProperty(name = "age", schema = @Schema(implementation = Integer.class)),
    }))
    @PostMapping("/test_map_params")
    public Result<Map<String,Object>> test_map_params(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @Operation(summary = "map类型入参(使用example)", description = "map类型入参接口<br>params:<br>"+
            "| 字段 | 类型 | 描述 |<br>" +
            "| ---- | ---- | ---- |<br>" +
            "| name | String | 姓名 |<br>" +
            "| age | Integer | 年龄 |")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
            schema = @Schema(type = "object", example = "{\"name\":\"bob\",\"age\":20}")
    ))
    @PostMapping("/test_map_params2")
    public Result<Map<String,Object>> test_map_params2(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @Operation(summary = "map类型入参(使用实体类)", description = "map类型入参接口")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
            schema = @Schema(implementation = User.class)
    ))
    @PostMapping("/test_map_params3")
    public Result<Map<String,Object>> test_map_params3(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @Operation(summary = "map类型返回值(使用example)", description = "map类型返回值接口")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功", content = @Content(schema = @Schema(type = "object", example = "{\"code\":200,\"data\":{\"name\":\"bob\",\"age\":20},\"msg\":\"success\"}")))
    })
    @PostMapping("/test_map_response")
    public Result<Map<String,Object>> test_map_response(){
        Map<String,Object> res = new HashMap<>();
        res.put("name","张三");
        res.put("age",22);
        return Result.success(res);
    }

    @Operation(summary = "map类型返回值(使用实体类)", description = "map类型返回值接口")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功", content = @Content(schema = @Schema(implementation = User.class)))
    })
    @PostMapping("/test_map_response2")
    public Result<Map<String,Object>> test_map_response2(){
        Map<String,Object> res = new HashMap<>();
        res.put("name","张三");
        res.put("age",22);
        return Result.success(res);
    }

}
