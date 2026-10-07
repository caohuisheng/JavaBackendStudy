<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/22
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${user.username},欢迎您!</h1>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>"启用"</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>"禁用"</td>
            </c:if>

            <td>
                <a href="/brand-demo/selectByIdServlet?id=${brand.id}">修改</a>
                <a href="/brand-demo/deleteByIdServlet?id=${brand.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<input type="button" value="添加" id="add"><br>
<script>
    var btn = document.getElementById("add");
    btn.onclick = function(){
        location.href = "/brand-demo/addBrand.jsp"
    }
</script>
</body>
</html>
