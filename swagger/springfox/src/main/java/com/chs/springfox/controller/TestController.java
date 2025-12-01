package com.chs.springfox.controller;

import com.chs.springfox.entity.Result;
import com.chs.springfox.entity.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@Api(tags = "测试controller", description = "测试相关接口")
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "map类型入参", notes = "map类型入参接口")
    @PostMapping("/test_map_params")
    public Result<Map<String,Object>> test_map_params(@RequestBody Map<String,Object> params){
        return Result.success(params);
    }

    @ApiOperation(value = "map类型返回值", notes = "map类型返回值接口")
    @PostMapping("/test_map_response")
    public Result<Map<String,Object>> test_map_response(){
        Map<String,Object> res = new HashMap<>();
        res.put("name","张三");
        res.put("age",22);
        return Result.success(res);
    }

}
