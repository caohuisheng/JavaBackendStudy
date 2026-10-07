<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
        	<p>${message}</p>
        	<input type="hidden"  value="${pageContext.request.contextPath}" id="path">
            <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/user/usersaves.do" enctype="multipart/form-data">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userCode">用户编码：</label>
                    <input type="text" name="userCode" id="userCode" value=""> 
					<!-- 放置提示信息 -->
					<font color="red"></font>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="password" name="userPassword" id="userPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" name="ruserPassword" id="ruserPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label >用户性别：</label>
					<select name="gender" id="gender" style="text-align: center;">
					    <option value="1" selected="selected">男</option>
					    <option value="2">女</option>
					 </select>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="date" Class="Wdate" id="birthday" name="birthday" 
					>
					<font color="red"></font>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                   <input name="address" id="address"  value="">
                </div>
                <div>
                    <label >用户类型：</label>
                    <!-- 列出所有的角色分类 -->
                   
					<select name="userRole" id="userRole" style="text-align: center;">
						<c:forEach items="${roleList}" var="role">
							<c:if test="${userSession.userRole<role.id}">
								<option value="${role.id}">${role.roleName}</option>	
							</c:if>
											
						</c:forEach>
					</select>
	        		<font color="red"></font>
                </div>
                <div>
                    <label >证件照片：</label>
                    <!-- 列出所有的角色分类 -->
					<input type="button" class="phone" value="点我上传">
					<input type="file" class="file" name="files" style="display: none" id="idphones">
	        		<font color="red">${phone0}</font>
                </div>
                <div>
                    <label >工作证照片：</label>
                    <!-- 列出所有的角色分类 -->
						<input type="button" class="phone" value="点我上传">
						<input type="file" class="file" name="files" style="display: none" id="lphmulti">
	        		<font color="red">${phone1}</font>
                </div>
                <div class="providerAddBtn">
                    <input type="button" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="./common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/useradd.js"></script>
