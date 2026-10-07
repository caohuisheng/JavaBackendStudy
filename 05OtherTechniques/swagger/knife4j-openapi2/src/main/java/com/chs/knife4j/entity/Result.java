package com.chs.knife4j.entity;

import lombok.Data;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-11-30
 */
@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Result(){
    }

    public static Result<Void> success(){
        Result<Void> r = new Result<>();
        r.setCode(200);
        r.setMsg("success");
        return r;
    }

    public static <T> Result<T> success(T data){
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMsg("success");
        r.setData(data);
        return r;
    }

    public static Result<Void> fail(){
        Result<Void> r = new Result<>();
        r.setCode(500);
        r.setMsg("failed");
        return r;
    }

}
