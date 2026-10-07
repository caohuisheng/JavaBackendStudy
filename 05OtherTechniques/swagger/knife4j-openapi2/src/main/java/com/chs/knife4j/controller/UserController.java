package com.chs.knife4j.controller;

import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.User;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@ApiSupport(author = "test@example.com",order = 1)
@Api(tags = "用户controller", description = "用户相关接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "查询用户(query参数)", notes = "根据uid查询用户(query参数)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", type = "query", required = true)
    })
    @GetMapping("/query_user1")
    public Result<User> queryUser(@RequestParam Integer uid){
        User user = new User(uid,"张三",22,(byte)1);
        return Result.success(user);
    }

    @ApiOperation(value = "查询用户(path参数)", notes = "根据uid查询用户(path参数)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", type = "path", required = true)
    })
    @GetMapping("/query_user2/{uid}")
    public Result<User> queryUser2(@PathVariable Integer uid){
        User user = new User(uid,"张三",22,(byte)1);
        return Result.success(user);
    }

    @ApiOperation(value = "查询用户(header参数)", notes = "根据uid查询用户(header参数)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", type = "header", required = true)
    })
    @GetMapping("/query_user3")
    public Result<User> queryUser3(@RequestHeader Integer uid){
        User user = new User(uid,"张三",22,(byte)1);
        return Result.success(user);
    }

    @ApiOperation(value = "查询用户(自定义响应)", notes = "根据uid查询用户(自定义响应)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", type = "query", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "服务器异常"),
            @ApiResponse(code = 503, message = "无访问权限"),
    })
    @GetMapping("/query_user4")
    public Result<User> queryUser4(@RequestParam Integer uid){
        User user = new User(uid,"张三",22,(byte)1);
        return Result.success(user);
    }

    @ApiOperation(value = "新增用户", notes = "新增一个用户")
    @PostMapping("/add_user")
    public Result<User> addUser(@RequestBody User user){
        return Result.success(user);
    }

    @ApiIgnore
    @GetMapping("/ignore_method")
    public Result<Void> hiddenMethod(){
        return Result.success();
    }

}
