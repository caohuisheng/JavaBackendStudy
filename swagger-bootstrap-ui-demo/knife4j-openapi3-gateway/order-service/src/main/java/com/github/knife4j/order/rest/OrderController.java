package com.github.knife4j.order.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/3/18 22:39
 * @since:knife4j-openapi3-gateway
 */
@Tag(name = "订单中心")
@RestController
@RequestMapping("/order")
public class OrderController {


    @Operation(summary = "订单问号")
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam("name") String name){
        return ResponseEntity.ok("reg,name:"+name);
    }
}
