package com.knife4j.demo.new3;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author <a href="xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2023/7/8 12:14
 * @since knife4j-spring-boot27-demo
 */
@Slf4j
@Api(tags = "文件下载")
@ApiSupport(author = "xiaoymin@foxmail.com",order = 278)
@RestController
@RequestMapping(value = "/download",produces = MediaType.APPLICATION_JSON_VALUE)
public class DownloadController {


    @ApiOperation(value = "导出")
    @GetMapping(value ="/export")
    public void export ( HttpServletResponse response) throws IOException {
        String excel="/Users/xiaoyumin/Downloads/日报详情_20230704140500.xlsx";
        response.setContentType ("application/vnd.gpenxmlfommats-officedocument•spreadsheetml.sheet;utf-8");
        response.setCharacterEncoding("UTF-8");
        response.addHeader("Content-Disposition","attachment;filename="+ RandomUtil.randomString(5)+".xlsx");
        InputStream inputStream= Files.newInputStream(new File(excel).toPath());
        ServletUtil.write(response,inputStream);

    }
}
