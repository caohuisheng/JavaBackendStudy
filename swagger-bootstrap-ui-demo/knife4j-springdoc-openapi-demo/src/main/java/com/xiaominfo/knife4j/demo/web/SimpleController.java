package com.xiaominfo.knife4j.demo.web;

import com.xiaominfo.knife4j.demo.model.v2.ApiBaseDTO;
import com.xiaominfo.knife4j.demo.model.v2.Entity2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2024/3/15 14:06
 * @since knife4j-spring-boot27-demo v1
 */
@RestController
@RequestMapping("/simple")
@Tag(name = "simple1")
public class SimpleController {
    @Operation(summary = "获取详情")
    @GetMapping("/getOneDetailById")
    public ApiBaseDTO<Entity2> getOneDetailById(@RequestParam(required = false) Integer id) {
        return null;
    }
}
