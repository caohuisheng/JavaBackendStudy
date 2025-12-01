package com.chs.knife4j.controller;

import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.User;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@Tag(name = "用户controller", description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Operation(summary = "查询用户(query参数)", description = "根据uid查询用户(query参数)")
    @Parameters({
            @Parameter(name = "uid", description = "用户id", in = ParameterIn.QUERY, required = true)
    })
    @GetMapping("/query_user1")
    public Result<User> queryUser(@RequestParam Integer uid){
        User user = new User(uid,"张三",22,(byte)1);
        return Result.success(user);
    }

    @Operation(summary = "查询用户(path参数)", description = "根据uid查询用户(path参数)")
    @Parameters({
            @Parameter(name = "uid", description = "用户id", in = ParameterIn.PATH, required = true)
    })
    @GetMapping("/query_user2/{uid}")
    public Result<User> queryUser2(@PathVariable Integer uid){
        User user = new User(uid,"张三",22,(byte)1);
        return Result.success(user);
    }

    @Operation(summary = "查询用户(header参数)", description = "根据uid查询用户(header参数)")
    @Parameters({
            @Parameter(name = "uid", description = "用户id", in = ParameterIn.HEADER, required = true)
    })
    @GetMapping("/query_user3")
    public Result<User> queryUser3(@RequestHeader Integer uid){
        User user = new User(uid,"张三",22,(byte)1);
        return Result.success(user);
    }

    @Operation(summary = "查询用户(自定义响应)", description = "根据uid查询用户(自定义响应)")
    @Parameters({
            @Parameter(name = "uid", description = "用户id", in = ParameterIn.QUERY, required = true)
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "服务器异常", content = @Content),
            @ApiResponse(responseCode = "503", description = "无访问权限", content = @Content),
    })
    @GetMapping("/query_user4")
    public Result<User> queryUser4(@RequestParam Integer uid){
        User user = new User(uid,"张三",22,(byte)1);
        return Result.success(user);
    }

    @Operation(summary = "查询用户(参数和响应在operation中)", description = "根据uid查询用户(参数和响应在operation中)", parameters = {
            @Parameter(name = "uid", description = "用户id", in = ParameterIn.QUERY, required = true)
    }, responses = {
            @ApiResponse(responseCode = "200", description = "成功"),
            @ApiResponse(responseCode = "500", description = "服务器异常", content = @Content),
            @ApiResponse(responseCode = "503", description = "无访问权限", content = @Content),
    })
    @GetMapping("/query_user5")
    public Result<User> queryUser5(@RequestParam Integer uid){
        User user = new User(uid,"张三",22,(byte)1);
        return Result.success(user);
    }

    @Operation(summary = "新增用户", description = "新增一个用户")
    @PostMapping("/add_user")
    public Result<User> addUser(@RequestBody User user){
        return Result.success(user);
    }

    @Hidden
    @GetMapping("/ignore_method")
    public Result<Void> hiddenMethod(){
        return Result.success();
    }

}
