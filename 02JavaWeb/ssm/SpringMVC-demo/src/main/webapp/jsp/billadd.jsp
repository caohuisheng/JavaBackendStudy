<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./common/head.jsp"%>

<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>订单管理页面 >> 订单添加页面</span>
     </div>
     <div class="providerAdd">
     	<input type="hidden"  value="${pageContext.request.contextPath}" id="path">
     				<p>${message}</p>
         <form id="billForm" name="billForm" method="post" action="${pageContext.request.contextPath}/jsp/bill.do">
           
             <div class="">
                 <label for="billCode">订单编码：</label>
                 <input type="text" name="billCode" class="text" id="billCode" value="" maxlength="100"> 
				 <!-- 放置提示信息 -->
				 <font color="red"></font>
             </div>
             <div>
                 <label for="productName">商品名称：</label>
                 <input type="text" name="productName" id="productName" value="" maxlength="100"> 
				 <font color="red"></font>
             </div>
             <div>
                 <label for="productUnit">商品单位：</label>
                 <input type="text" name="productUnit" id="productUnit" value="" maxlength="50"> 
				 <font color="red"></font>
             </div>
             <div>
                 <label for="productCount">商品数量：</label>
                 <input type="text" name="productCount" id="productCount" value="" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" maxlength="1000000"> 
				 <font color="red"></font>
             </div>
             <div>
                 <label for="totalPrice">总金额：</label>
                 <input type="text" name="totalPrice" id="totalPrice" value="" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" maxlength="100000000"> 
				 <font color="red"></font>
             </div>
               <div>
                 <label for="totalPrice">商品描述：</label>
                 <input type="text" name="productDesc" id="productDesc" value=""  > 
				 <font color="red"></font>
             </div>
             <div>
                 <label >供应商：</label>
                 <select name="providerId" id="providerId" style="text-align: center;">
                 	<c:forEach items="${proList}" var="provider">
                 		<option value="${provider.id}">${provider.proName}</option>
                 	</c:forEach>
		         </select>
				 <font color="red"></font>
             </div>
             <div>
                 <label >是否付款：</label>
                 <input type="radio" name="isPayment" value="1" checked="checked">未付款
				 <input type="radio" name="isPayment" value="2" >已付款
             </div>
             <div class="providerAddBtn">
                  <input type="button" name="add" id="add" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
             </div>
         </form>
     </div>
 </div>
</section>
<%@include file="./common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/billadd.js"></script>