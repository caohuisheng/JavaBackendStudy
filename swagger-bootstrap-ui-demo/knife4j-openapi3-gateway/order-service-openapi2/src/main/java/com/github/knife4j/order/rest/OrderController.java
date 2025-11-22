package com.github.knife4j.order.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
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
@Api(value = "订单中心-openapi2")
@RestController
@RequestMapping("/order2")
public class OrderController {


    @ApiOperation(value = "订单问号")
    @GetMapping("/hello2")
    public ResponseEntity<String> hello(@RequestParam("name") String name){
        return ResponseEntity.ok("reg,name:"+name);
    }
}
