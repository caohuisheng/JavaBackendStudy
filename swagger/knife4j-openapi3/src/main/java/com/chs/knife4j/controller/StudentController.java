package com.chs.knife4j.controller;

import com.chs.knife4j.entity.AjaxResult;
import com.chs.knife4j.entity.Result;
import com.chs.knife4j.entity.StudentDTO;
import com.chs.knife4j.entity.StudentVO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author: chs
 * @date: 2025-12-05 14:55
 * @description: todo
 */
@RestController
@RequestMapping("/student")
@Tag(
        name = "StudentControllerAPI",
        description = "学生控制器接口",
        externalDocs = @ExternalDocumentation(
                description = "这是一个接口文档介绍",
                url = "https://www.cnblogs.com/antLaddie/"))
public class StudentController {

    /***
     * 根据ID查询学生信息（单条）
     * @param id 学生id
     * @return 返回一条数据
     */
    @Operation(
            summary = "根据Id查询学生信息",
            description = "根据ID查询学生信息，并返回响应结果信息",
            parameters = {
                    @Parameter(name = "id",
                            description = "学生ID",
                            required = true,
                            example = "1")},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "响应成功",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            title = "AjaxResul和StudentVO组合模型",
                                            description = "返回实体，AjaxResult内data为StudentVO模型",
                                            implementation = Result.class))),
                    @ApiResponse(
                            responseCode = "500",
                            description = "响应失败",
                            content = @Content())
            })
    @GetMapping("/findOne/{id}")
    public Result<StudentVO> findOneStudent(@PathVariable(value = "id") Long id) {
        //模拟学生数据
        List<String> likes = Arrays.asList("抓鱼", "爬山", "写字");
        StudentVO studentVO = new StudentVO(id, "张三", 22, "安徽六安", 93.5, likes);
        return Result.success(studentVO);
    }

    /***
     * 查询全部学生数据
     * @return 返回d条数据
     */
    @Operation(
            summary = "查询全部学生数据",
            description = "查询学生信息，并返回响应结果信息",
            parameters = {},
            deprecated = true,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "响应成功",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            title = "AjaxResul和StudentVO组合模型",
                                            description = "返回实体，AjaxResult内data为" +
                                                    "StudentVO模型(并且StudentVO为集合)",
                                            implementation = Result.class)
                            )
                    )
            }
    )
    @GetMapping("/findAll")
    public Result<List<StudentVO>> findAllStudent() {
        //模拟学生数据
        List<String> likes = Arrays.asList("抓鱼", "爬山", "写字");
        StudentVO student1 = new StudentVO(1L, "张三", 22, "安徽六安", 93.5, likes);
        StudentVO student2 = new StudentVO(2L, "李四", 24, "安徽合肥", 99.5, likes);
        return Result.success(Arrays.asList(student1, student2));
    }

    /***
     * 学生添加接口
     * @param studentDTO 学生DTO信息
     * @return 成功信息
     */
    @Operation(
            summary = "学生添加接口",
            description = "学生添加接口",
            parameters = {},
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "学生信息DTO",
                    required = true,
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = StudentDTO.class))
                    }
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "响应成功",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            title = "AjaxResul模型",
                                            description = "返回实体AjaxResult，并且Data为null",
                                            implementation = Result.class)
                            )
                    )
            }
    )
    @PostMapping("/saveStudent")
    public Result<Void> saveStudent(@RequestBody StudentDTO studentDTO) {
        System.out.println("成功添加数据：" + studentDTO);
        return Result.success(null);
    }

}
