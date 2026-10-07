package com.chs.knife4j.controller;

import com.chs.knife4j.config.ParameterException;
import com.chs.knife4j.entity.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "用户管理", description = "用于管理用户信息的接口")
public class UserController {

    @PostMapping
    @Operation(summary = "创建新用户", description = "根据提供的用户信息创建一个新用户")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "用户创建成功")
    })
    public Result<Void> createUser(@RequestBody @Valid CreateUserRequest request) throws Exception {
        // ... 业务逻辑 ...
        if(!request.getEmail().contains("@")){
            throw new ParameterException("邮箱格式不正确");
        }
        if(request.getUsername().length() <= 2){
            throw new RuntimeException("创建用户异常");
        }

        return Result.success();
    }

    @GetMapping
    @Operation(summary = "获取用户信息", description = "根据ID获取用户信息")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功获取用户"),
    })
    public Result<UserVO> getUserById(
            @Parameter(description = "用户ID", required = true)
            @RequestParam Integer userId) {
        // ... 业务逻辑 ...
        UserVO vo = new UserVO();
        return Result.success(vo);
    }

    @PutMapping
    @Operation(summary = "修改用户信息", description = "根据ID修改用户信息")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功修改用户")
    })
    public Result<Void> getUserById(@RequestBody @Valid CreateUserRequest request) {
        // ... 业务逻辑 ...
        return Result.success();
    }

    @DeleteMapping
    @Operation(summary = "删除用户信息", description = "根据ID删除用户信息")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功删除用户")
    })
    public Result<Void> deleteUserById(
            @Parameter(description = "用户ID", required = true)
            @RequestParam Integer userId) {
        // ... 业务逻辑 ...
        return Result.success();
    }

}
