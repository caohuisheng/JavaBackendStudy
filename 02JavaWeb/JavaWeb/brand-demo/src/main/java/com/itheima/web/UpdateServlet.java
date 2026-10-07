package com.itheima.web;

import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理post请求乱码问题
        req.setCharacterEncoding("utf-8");

        //获取表单数据
        String id = req.getParameter("id");
        String companyName = req.getParameter("companyName");
        String brandName = req.getParameter("brandName");
        String ordered = req.getParameter("ordered");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        Brand brand = new Brand(Integer.parseInt(id),brandName,companyName,Integer.parseInt(ordered),description,
                Integer.parseInt(status));
        //调用brandService的update方法
        brandService.update(brand);
        //转发到selectAllServlet
        req.getRequestDispatcher("/selectAllServlet").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
