package com.chs.knife4j.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@Data
@Schema(description = "API响应结构")
public class Result<T> {

    @Schema(description = "状态码", example = "200")
    private int code;

    @Schema(description = "响应消息", example = "操作成功")
    private String message;

    @Schema(description = "响应数据")
    private T data;

    public Result(){
    }

    public static <T> Class<T> getGenericClass() {
        return (Class<T>) new Object() {}.getClass();
    }

    public static Result<Void> success(){
        Result<Void> r = new Result<>();
        r.setCode(200);
        r.setMessage("成功");
        return r;
    }

    public static <T> Result<T> success(T data){
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage("成功");
        r.setData(data);
        return r;
    }

    public static Result<Void> fail(int code, String message){
        Result<Void> r = new Result<>();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

}
