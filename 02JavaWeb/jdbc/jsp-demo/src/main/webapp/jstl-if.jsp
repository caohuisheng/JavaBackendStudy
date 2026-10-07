<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.itheima.pojo.Brand" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${status}
    <c:if test="${status == 1}">
        open
    </c:if>
   <c:if test="${status != 1}">
        close
   </c:if>

   <%
        int[] items = new int[3];
        //items =
   %>
    <%
     List<Brand> brands = new ArrayList<>();
    %>
   <c:forEach items="brands" var="brand" varStatus="status">
        <tr align="center">
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
        </tr>
   </c:forEach>


</body>
</html>
