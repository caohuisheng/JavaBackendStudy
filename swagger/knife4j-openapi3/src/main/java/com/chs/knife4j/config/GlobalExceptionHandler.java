package com.chs.knife4j.config;

import com.chs.knife4j.entity.Result;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Author: chs
 * Description:
 * CreateTime: 2025-12-07
 */
// @ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ApiResponses({ // 在这里也可以使用 @ApiResponses 来文档化全局异常
            @ApiResponse(responseCode = "500", description = "系统运行异常")
    })
    public ResponseEntity<Result<Void>> handleInternalException(RuntimeException e) {
        Result<Void> r = Result.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(r);
    }

    @ExceptionHandler(ParameterException.class)
    @ApiResponses({ // 在这里也可以使用 @ApiResponses 来文档化全局异常
            @ApiResponse(responseCode = "400", description = "参数异常")
    })
    public ResponseEntity<Result<Void>> handleParameterException(ParameterException e) {
        Result<Void> r = Result.fail(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(r);
    }
}
