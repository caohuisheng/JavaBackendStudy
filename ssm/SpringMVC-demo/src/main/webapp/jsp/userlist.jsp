<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./common/head.jsp"%>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
            <input type="hidden" value="${pageContext.request.contextPath}" id="path">
           		<form method="get" action="${pageContext.request.contextPath}/user/userlist.do">
					<input name="pageNow" value="1" class="input-text" type="hidden" id="pageNow">
					 <span>用户名：</span>
					 <input name="queryUserName" class="input-text"	type="text" value="${queryUserName}">
					 
					 <span>用户角色：</span>
					 <select name="queryUserRole" id="queryUserRole">
						<c:if test="${roleList != null and roleList.size()!=0 }">
						   <option value="-1">--请选择--</option>
						   <c:forEach var="role" items="${roleList}">
						   		<option <c:if test="${role.id == queryUserRole}">selected="selected"</c:if>
						   		value="${role.id}">${role.roleName}</option>
						   </c:forEach>
						</c:if>
	        		</select>
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="javascript:void(0)" id="userAdd" >添加用户</a>
				</form>
            </div>
            <!--用户-->
            <c:choose>
            	<c:when test="${page.data==null||page.data.size()==0}">
            			<h3>查无信息</h3>
            	</c:when>
            	<c:otherwise>
            	 <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户角色</th>
                    <th width="30%">操作</th>
                </tr>
                   <c:forEach var="user" items="${page.data}" varStatus="status">
					<tr>
						<td>
						<span>${user.userCode }</span>
						</td>
						<td>
						<span>${user.userName }</span>
						</td>
						<td>
							<span>
								<c:if test="${user.gender==1}">男</c:if>
								<c:if test="${user.gender==2}">女</c:if>
							</span>
						</td>
						<td>
						<span>${user.age}</span>
						</td>
						<td>
						<span>${user.phone}</span>
						</td>
						<td>
							<span>${user.userRoleName}</span>
						</td>
						<td>
						<span><a class="viewUser" href="${pageContext.request.contextPath}/user/viewUser?id=${user.id}&method=userview"><img src="${pageContext.request.contextPath }/static/images/read.png" alt="查看" title="查看"/></a></span>
						<span><a class="modifyUser" href="javascript:void(0)" data-id="${user.id}" data-userrole="${user.userRole}"><img src="${pageContext.request.contextPath }/static/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="deleteUser"href="javascript:void(0)" data-id="${user.id}" data-userrole="${user.userRole}"><img src="${pageContext.request.contextPath }/static/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<%@include file="rollpage.jsp" %>
		  	<%-- <c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPageNo}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import> --%>
            	
            	</c:otherwise>
            </c:choose>
           
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="javascript:void(0)" id="yes">确定</a>
            <a href="javascript:void(0)" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="./common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/userlist.js"></script>
