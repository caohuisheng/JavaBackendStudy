<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="./common/head.jsp"%>
	
    <div class="right" id="frame">
        <img class="wColck" src="${pageContext.request.contextPath }/static/images/clock.jpg" alt=""/>
        <div class="wFont">
        	
        	
            	<h2><span style="color:red">用户名称：</span>${userSession.userName}</h2>
             <h2><span style="color:red">用户类型：</span>${userSession.userRoleName}</h2>
              <p style="font-size: 25px;margin-top: 20px;color:red" >开发技术：JSP+SSM+JQ+MySql 5.0</p>
            <p style="font-size: 25px;margin-top: 20px" >欢迎来到好便宜订单管理系统!</p>
        </div>
    </div>
</section>
<%@include file="./common/foot.jsp" %>
