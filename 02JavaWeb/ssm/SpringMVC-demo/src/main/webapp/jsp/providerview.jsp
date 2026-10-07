<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./common/head.jsp"%>
 <div class="right">
   <input type="hidden" id="path" value="${pageContext.request.contextPath}">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>供应商编码：</strong><span>${provider.proCode }</span></p>
            <p><strong>供应商名称：</strong><span>${provider.proName }</span></p>
            <p><strong>联系人：</strong><span>${provider.proContact }</span></p>
            <p><strong>联系电话：</strong><span>${provider.proPhone }</span></p>
            <p><strong>传真：</strong><span>${provider.proFax }</span></p>
            <p><strong>描述：</strong><span>${provider.proDesc}</span></p>
			 <p style="margin-top: 10px;"><strong>营业执照：</strong><span><a  style="margin-left: 0px;top: 0px;  background-color:#BD644E" href="${pageContext.request.contextPath}/static/images/${provider.licensePhone}">预览营业执照</a></span></p>
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<script>
	$(function(){
		$('#back').click(function(){//返回
			window.location.href=$('#path').val()+"/provider/providerlist.do"
		})
	})
</script>
<%@include file="./common/foot.jsp" %>
