package com.chs.knife4j.controller;

import com.chs.knife4j.annotation.MapParameter;
import com.chs.knife4j.annotation.MapRequest;
import com.chs.knife4j.annotation.MapResponse;
import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.Student;
import com.chs.knife4j.entity.User;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Operation(summary = "map类型入参1(使用example)", description = "map类型入参接口<br>params:<br>"+
            "| 字段 | 类型 | 描述 |<br>" +
            "| ---- | ---- | ---- |<br>" +
            "| name | String | 姓名 |<br>" +
            "| age | Integer | 年龄 |")
    @PostMapping(value = "/test_map_params1",produces = "application/json")
    public Result<Map<String,Object>> test_map_params1(@io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
            schema = @Schema(type = "object", example = "{\"name\":\"bob\",\"age\":20}")
    )) @RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @Operation(summary = "map类型入参2(使用实体类)", description = "map类型入参接口")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
            schema = @Schema(implementation = User.class)
    ))
    @PostMapping("/test_map_params2")
    public Result<Map<String,Object>> test_map_params2(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @Operation(summary = "map类型入参3(使用实体类2)", description = "map类型入参接口")
    @PostMapping("/test_map_params3")
    public Result<Map<String,String>> test_map_params3(@RequestBody com.chs.knife4j.entity.temp.Student params){
        return Result.success(null);
    }

    // OpenAPI3版本不支持
    @Operation(summary = "map类型入参4(使用动态请求参数注解)", description = "map类型入参接口")
    @DynamicParameters(name = "params",properties = {
            @DynamicParameter(name = "name",value = "姓名",example = "bob",required = true),
            @DynamicParameter(name = "age",value = "年龄",dataTypeClass = String.class),
    })
    @PostMapping("/test_map_params4")
    public Result<Map<String,Object>> test_map_params4(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @Operation(summary = "map类型入参5(使用自定义注解)", description = "map类型入参接口")
    @PostMapping("/test_map_params5")
    @MapRequest({
            @MapParameter(name = "name", type = String.class, description = "姓名", example = "zhangsan"),
            @MapParameter(name = "age", type = Integer.class, description = "年龄", example = "22"),
    })
    public Result<Map<String,Object>> test_map_params5(@RequestBody Map<String,String> params){
        return Result.success(null);
    }

    @Operation(summary = "map类型入参6(使用自定义注解2)", description = "map类型入参接口")
    @PostMapping("/test_map_params6")
    @MapRequest({
            @MapParameter(name = "name", type = String.class, description = "姓名", example = "zhangsan"),
            @MapParameter(name = "age", type = Integer.class, description = "年龄", example = "22"),
            @MapParameter(name = "sex", type = Integer.class, description = "性别", example = "1"),
    })
    public Result<Map<String,Object>> test_map_params6(@RequestBody Map<String,String> params){
        return Result.success(null);
    }


    //------------------------------------------------------------------------------------------------------------------

    @Operation(summary = "map类型返回值1(使用example)", description = "map类型返回值接口")
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


    @Operation(summary = "map类型返回值2(使用实体类)", description = "map类型返回值接口")
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

    @Operation(summary = "map类型返回值3(使用动态参数)", description = "map类型返回值接口")
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

    @Operation(summary = "map类型返回值4(使用自定义注解)", description = "map类型返回值接口")
    @MapResponse(responseCode = "200", description = "成功", rawType = Result.class, genericType = Student.class)
    @PostMapping("/test_map_response4")
    public Result<Map<String,Object>> test_map_response4(){
        Map<String,Object> res = new HashMap<>();
        res.put("name","张三");
        res.put("age",22);
        return Result.success(res);
    }

    @Operation(summary = "map类型返回值5(使用自定义注解)", description = "map类型返回值接口")
    @MapResponse(responseCode = "200", description = "成功", rawType = Result.class, fields = {
            @MapParameter(name = "name", type = String.class, description = "姓名", example = "zhangsan"),
            @MapParameter(name = "age", type = Integer.class, description = "年龄", example = "22"),
    })
    @PostMapping("/test_map_response5")
    public Result<Map<String,Object>> test_map_response5(){
        Map<String,Object> res = new HashMap<>();
        res.put("name","张三");
        res.put("age",22);
        return Result.success(res);
    }

}
