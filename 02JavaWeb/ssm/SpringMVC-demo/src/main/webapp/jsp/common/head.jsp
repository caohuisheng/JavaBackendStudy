<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>好便宜订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/public.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.6.0.min.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/head.js"></script>
	<style type="text/css">
		.publicHeader img{
				width: 35px;
				height: 35px;
				border-radius: 50%;
				margin: 8px;
				margin-left: 20px;
			}
	</style>
</head>
<body>
<!--头部-->
    <header class="publicHeader">
    	<input type="hidden" value="${userSession.userRole}" id="userRoles"/>
        <h1>好便宜订单管理系统</h1>
        	<c:choose>
        		<c:when test="${userSession==null || userSession.badgePhone==null}">      			
        		<img src="${pageContext.request.contextPath}/static/images/tx.jpg" alt="个人证件照" id="badgePhone">
        		</c:when>
        		<c:otherwise>
        			<img src="${pageContext.request.contextPath}/static/images/${userSession.badgePhone}" alt="个人证件照" id="badgePhone">
        		</c:otherwise>
        	</c:choose>
        <div class="publicHeaderR">
            <p><span id="sj"></span><span style="color: #fff21b"> ${userSession.userName }</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath }/loginout.do">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time"></span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
              <li ><a href="${pageContext.request.contextPath }/auto?page=frame">首页</a></li>
                 <li ><a href="${pageContext.request.contextPath }/bill/billist.do">订单管理</a></li>
              <li><a href="${pageContext.request.contextPath }/provider/providerlist.do">供应商管理</a></li>
              <li><a href="${pageContext.request.contextPath }/user/userlist.do">用户管理</a></li>
              <li><a href="${pageContext.request.contextPath }/auto?page=pwdmodify">密码修改</a></li>
              <li><a href="${pageContext.request.contextPath }/loginout.do">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>