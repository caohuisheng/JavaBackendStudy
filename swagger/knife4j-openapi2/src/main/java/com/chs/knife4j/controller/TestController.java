package com.chs.knife4j.controller;

import com.chs.knife4j.custom.Apicp;
import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import com.sun.org.apache.bcel.internal.generic.NEW;
import io.swagger.annotations.*;
import javassist.expr.NewExpr;
import net.bytebuddy.asm.Advice;
import org.springframework.util.StringUtils;
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
@Api(tags = "测试controller", description = "测试相关接口")
@RestController
@RequestMapping(value = "/test", produces = "application/json")
public class TestController {

    private static String getFieldDesc(String[] fields, String[] types, String[] descs){
        StringBuilder sb = new StringBuilder();
        sb.append("|字段|类型|描述|").append("|----|----|----|");
        for (int i = 0; i < fields.length; i++) {
            sb.append(String.format("|%s|%s|%s|", fields[i], types[i], descs[i]));
        }
        return sb.toString();
    }

    @ApiOperation(value = "map类型入参(使用example)", notes = "map类型入参接口(使用example)<br>params:<br>"+"| 字段 | 类型 | 描述 |<br>" +
            "| ---- | ------ | ---- |<br>" +
            "| name | String | 姓名 |<br>" +
            "| age | Integer | 年龄 |")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params",type = "body", dataType = "object", example = "{\"name\":\"bob\",\"age\":22}")
    })
    @PostMapping("/test_map_params")
    public Result<Map<String,Object>> test_map_params(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @ApiOperation(value = "map类型入参(使用实体类)", notes = "map类型入参接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params",type = "body", dataType = "Student")
    })
    @PostMapping("/test_map_params2")
    public Result<Map<String,Object>> test_map_params2(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @ApiOperation(value = "map类型入参(使用动态参数)", notes = "map类型入参接口")
    @DynamicParameters(name = "params",properties = {
            @DynamicParameter(name = "name",value = "姓名",example = "bob",required = true),
            @DynamicParameter(name = "age",value = "年龄",dataTypeClass = String.class),
    })
    @PostMapping("/test_map_params3")
    public Result<Map<String,Object>> test_map_params3(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @ApiOperation(value = "map类型入参(使用自定义注解)", notes = "map类型入参接口")
    @PostMapping("/test_map_params4")
    public Result<Map<String,Object>> test_map_params4(@Apicp(values = {}, //Student类中已经存在的
            modelName = "User2", //自定义Model的名字，也是要生成的类名
            classPath = TestController.class, //原始的类
            noValues = {"param1","param2","param3"}, //原始的类中没有的参数
            noValueTypes = {"string","integer","double"},//原始的类中没有的参数的类型
            noVlaueExplains = {"啦啦","哈哈","嘻嘻"})//原始的类中没有的参数的描述
            @RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    //------------------------------------------------------------------------------------------------------------------

    @ApiOperation(value = "map类型返回值(使用example)", notes = "map类型返回值接口<br>response:<br>"+"| 字段 | 类型 | 描述 |<br>" +
            "| ---- | ------ | ---- |<br>" +
            "| name | String | 姓名 |<br>" +
            "| age | Integer | 年龄 |")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", examples = @Example({@ExampleProperty(mediaType = "application/json", value = "{\"code\":200,\"data\":{\"name\":\"bob\",\"age\":20},\"msg\":\"success\"}")}))
    })
    @PostMapping("/test_map_response")
    public Result<Map<String,Object>> test_map_response(){
        Map<String,Object> res = new HashMap<>();
        res.put("name","张三");
        res.put("age",22);
        return Result.success(res);
    }

    @ApiOperation(value = "map类型返回值(使用实体类)", notes = "map类型返回值接口")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = User.class)
    })
    @PostMapping("/test_map_response2")
    public Result<Map<String,Object>> test_map_response2(){
        Map<String,Object> res = new HashMap<>();
        res.put("name","张三");
        res.put("age",22);
        return Result.success(res);
    }

    @ApiOperation(value = "map类型返回值(使用动态参数)", notes = "map类型返回值接口")
    @DynamicResponseParameters(properties = {
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

    @ApiOperation(value = "map类型返回值(使用动态参数)", notes = "map类型返回值接口")
    @DynamicResponseParameters(properties = {
            @DynamicParameter(name = "name",value = "姓名",example = "bob",required = true),
            @DynamicParameter(name = "age",value = "年龄",dataTypeClass = String.class),
            @DynamicParameter(name = "address",value = "地址",dataTypeClass = String.class),
            @DynamicParameter(name = "user",value = "用户",dataTypeClass = User.class),
    })
    @PostMapping("/test_map_response4")
    public Result<Map<String,Object>> test_map_response4(){
        Map<String,Object> res = new HashMap<>();
        res.put("name","张三");
        res.put("age",22);
        return Result.success(res);
    }

}
