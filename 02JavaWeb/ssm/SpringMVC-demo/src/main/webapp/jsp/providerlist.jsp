<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面</span>
        </div>
        <div class="search">
           <input type="hidden" value="${pageContext.request.contextPath}" id="path">
        	<form method="get" action="${pageContext.request.contextPath }/provider/providerlist.do">
				<input name="pageNow" value="1" class="input-text" type="hidden" id="pageNow">
				<span>供应商编码：</span>
				<input name="queryProCode" type="text" value="${queryProCode}">
				
				<span>供应商名称：</span>
				<input name="queryProName" type="text" value="${queryProName}">
				
				<input value="查 询" type="submit" id="searchbutton">
				<a href="javascript:void(0)" id="providerAdd">添加供应商</a>
			</form>
        </div>
        <c:choose>
        	<c:when test="${page.data==null||page.data.size()==0}">
        		<h3>查无信息</h3>
        	</c:when>
        	<c:otherwise>
        	 <!--供应商操作表格-->
        	 
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach var="provider" items="${page.data }" varStatus="status">
				<tr>
					<td>
					<span>${provider.proCode }</span>
					</td>
					<td>
					<span>${provider.proName }</span>
					</td>
					<td>
					<span>${provider.proContact}</span>
					</td>
					<td>
					<span>${provider.proPhone}</span>
					</td>
					<td>
					<span>${provider.proFax}</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${provider.creationDate}" pattern="yyyy-MM-dd"/>
					</span>
					</td>
					<td>
					<span><a class="viewProvider" href="${pageContext.request.contextPath}/provider/viewProvider?id=${provider.id}"><img src="${pageContext.request.contextPath }/static/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="modifyProvider" href="javascript:void(0)" data-id="${provider.id}"><img src="${pageContext.request.contextPath }/static/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteProvider" href="javascript:void(0)" data-id="${provider.id}"><img src="${pageContext.request.contextPath }/static/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
			</c:forEach>
        </table>
        	<%@include file="rollpage.jsp" %>
        	</c:otherwise>
        </c:choose>
       

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="javascript:void(0)" id="yes">确定</a>
           <a href="javascript:void(0)" id="no">取消</a>
       </div>
   </div>
</div>

<%@include file="./common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/providerlist.js"></script>
