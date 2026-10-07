<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.itheima.pojo.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="新增"><br>
<hr>
    <table border="1" cellspacing="0" width="800">
    <%
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));

        for(int i = 0;i<brands.size();i++){
            Brand brand = brands.get(i);
    %>
        <tr>
                <th>brands.getId()</th>
                <th>品牌名称</th>
                <th>企业名称</th>
                <th>排序</th>
                <th>品牌介绍</th>
                <th>状态</th>
                <th>操作</th>
        </tr>
    <%
        }
    %>

    </table>
</body>
</html>
