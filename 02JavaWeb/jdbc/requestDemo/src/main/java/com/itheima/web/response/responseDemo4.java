package com.itheima.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/*
响应字节数据
 */
@WebServlet("/resp4")
public class responseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp3...");
        //1.读取文件
        FileInputStream fis = new FileInputStream("D:\\Users\\YeQiu\\DeskTop\\截图\\xss\\1.PNG");

        //2.获取response字节输出流
        ServletOutputStream os = resp.getOutputStream();

        //3.完成流的copy
//        byte[] buff = new byte[1024];
//        int len = 0;
//        while((len = fis.read(buff))!=-1){
//            os.write(buff,0,len);
//        }
        //简化
        IOUtils.copy(fis,os);
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
