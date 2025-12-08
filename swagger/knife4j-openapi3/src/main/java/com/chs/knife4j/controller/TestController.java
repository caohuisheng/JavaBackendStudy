package com.chs.knife4j.controller;

import com.chs.knife4j.custom.CustomOperation;
import com.chs.knife4j.custom.MapDescription;
import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.User;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.ResolvableType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
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

    /*@Operation(summary = "map类型入参(使用schemaProperties)", description = "map类型入参接口")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schemaProperties = {
            @SchemaProperty(name = "name", schema = @Schema(implementation = String.class)),
            @SchemaProperty(name = "age", schema = @Schema(implementation = Integer.class)),
    }))
    @PostMapping("/test_map_params")
    public Result<Map<String,Object>> test_map_params(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }*/

    @Operation(summary = "map类型入参(使用example)", description = "map类型入参接口<br>params:<br>"+
            "| 字段 | 类型 | 描述 |<br>" +
            "| ---- | ---- | ---- |<br>" +
            "| name | String | 姓名 |<br>" +
            "| age | Integer | 年龄 |")
    @PostMapping(value = "/test_map_params2",produces = "application/json")
    public Result<Map<String,Object>> test_map_params2(@io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
            schema = @Schema(type = "object", example = "{\"name\":\"bob\",\"age\":20}")
    )) @RequestBody Map<String,Object> params){
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

    @Operation(summary = "map类型入参(使用动态请求参数注解)", description = "map类型入参接口")
    @DynamicParameters(name = "params",properties = {
            @DynamicParameter(name = "name",value = "姓名",example = "bob",required = true),
            @DynamicParameter(name = "age",value = "年龄",dataTypeClass = String.class),
    })
    @PostMapping("/test_map_params4")
    public Result<Map<String,Object>> test_map_params4(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @CustomOperation(
            requestBodyDescription = "这是一个全局自定义的请求体描述",
            requestBodySchema = User.class // 可选：指定 Schema
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = User.class)))
    })
    @Operation(summary = "map类型入参()", description = "map类型入参接口")
    @PostMapping("/test_map_params5")
    public Result<Map<String,Object>> test_map_params5(@RequestBody Map<String,Object> params){
        new Result<User>(){}.getClass();

        return Result.success(params);
    }

    //------------------------------------------------------------------------------------------------------------------

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

    @Operation(summary = "map类型返回值(使用动态参数)", description = "map类型返回值接口")
    @DynamicResponseParameters(name = "response",properties = {
            @DynamicParameter(name = "name",value = "姓名",example = "bob",required = true),
            @DynamicParameter(name = "age",value = "年龄",dataTypeClass = String.class),
    })
    @PostMapping("/test_map_response3")
    public Result<Map<String,Object>> test_map_response3(){
        Map<String,Object> res = new HashMap<>();
        res.put("name","张三");
        res.put("age",22);
        return Result.success(res);
    }

}
