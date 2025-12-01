package com.chs.knife4j.controller;

import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chs
 * @date: 2025-12-01 15:38
 * @description: todo
 */
@Tag(name = "测试新特性controller", description = "测试新特性相关接口")
@RestController
@RequestMapping("/test_new_feature")
public class TestNewFeatureController {

    @Operation(summary = "OPERATION_NAME", description = "OPERATION_DESC")
    @Parameters({
            @Parameter(name = "uid", description = "用户id", in = ParameterIn.QUERY, required = true)
    })
    @GetMapping("/test_i18n")
    public Result<User> queryUser(@RequestParam Integer uid){
        User user = new User(uid,"张三",22,(byte)1);
        return Result.success(user);
    }


}