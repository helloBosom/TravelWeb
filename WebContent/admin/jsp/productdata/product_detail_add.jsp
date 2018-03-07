<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%
   String path = request.getContextPath();
   %> 
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品明细管理</title>
<link href="<%=path%>/admin/css/main.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/admin/js/datepicker/default/datepicker.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/admin/js/datepicker/whyGreen/datepicker.css"
	rel="stylesheet" type="text/css" disabled>
	
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="../../images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：产品管理》产品明细管理</td>
    </tr>
  </table>
<form action="<%=path%>/product/addproductdetail.do"  method="post">
<table align="center" class="table-table">
<!-- 产品编号，日期，行程线路，用餐情况，是否包含住宿,价格包括，价格不含内容，温馨提示，备注 -->
          <tr>
            <td colspan="2" class="table-title">产品明细管理</td>
          </tr>
          
	<tr>
		<td  >产品名称：</td>
		<td  >
			<select name="productname">
			<c:choose>
			<c:when test="${empty productnames}">请添加产品信息</c:when>
			<c:otherwise>
			<c:forEach items="${productnames}" var="v">
			<option value="${v}">${v}</option>
			</c:forEach>
			</c:otherwise>
			</c:choose>
				
			</select>
		</td>
	</tr>
	
	<tr>
		<td width="20%">行程线路：</td>
		<td width="80%"><input type="text" name="route" style="width:100%"/></td>
	</tr>
	<tr>
		<td width="20%">日期：</td>
		<td width="80%"><input type="text" name="date" style="width:100%"/></td>
	</tr>
	<tr>
		<td width="20%">目的地：</td>
		<td width="80%"><input type="text" name="destination" style="width:100%;height:50px"/></td>
	</tr>
	<tr>
		<td width="20%">详细介绍：</td>
		<td width="80%"><input type="text" name="detail" style="width:100%;height:50px"/></td>
	</tr>
		<td width="20%">备注：</td>
		<td class="table-title1" width="80%"><input type="text" name="remarks" style="width:100%;height:50px"/></td>
	</tr>
	<tr>  
		<td></td>
		 <td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <span class="table-button"> <input type="submit" class="input"  name="B334" value="添加"></span>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <span class="table-button"> <input type="reset" class="input" name="B332" value="重置"></span>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   <span class="table-button"> <input type="reset" class="input" name="B332" value="返回"></span>
		  <span class="table-button"> <input type="hidden" name="_method" value="PUT"> </span>
		  		 
		</td>
	</tr>
</table>
</form>
</body>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>
</html>
