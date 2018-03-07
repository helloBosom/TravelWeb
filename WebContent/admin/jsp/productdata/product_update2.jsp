<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
    %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加线路的产品</title>
	
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
		<tr>
			<td height=25 bgcolor="#FFFFFF"><img src="../../images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：添加产品</td>
		</tr>
	</table>
	
<form action="<%=path%>/product/addproduct.do" method="get"   >

<table align="center" class="table-table">
          <tr>
            <td colspan="2" class="table-title"> 产品信息</td>
          </tr>
          
          <tr>
		<td  width="20%">产品编号：</td>
		<td  width="80%"><input type="text" name="productid" style="width:100%"/></td>
		</tr>
    <tr>
		<td  width="20%">产品名称：</td>
		<td  width="80%"><input type="text"  id="productName" name="productName" style="width:100%"/></td>
	</tr>
	 <tr>
		<td  width="20%">天数：</td>
		<td  width="80%"><input type="text" name="days" style="width:100%"/></td>
	</tr>
	<tr>
		<td  width="20%">线路名称：</td>
		<td  width="80%">
			<select name="routename">
			<c:choose>
			<c:when test="${empty names}"></c:when>
			<c:otherwise>
			<c:forEach items="${names}" var="v">
			<option value="${v}">${v}</option>
			</c:forEach>
			</c:otherwise>
			</c:choose>
				
			</select>
		</td>
	</tr>
		<tr>
		<td  width="20%">状态：</td>
		<td  width="80%">
		 	<select name="status">
		 	<option value="0">销售中</option>
		 	<option value="1">已过期</option>
		 	</select>
		
		
		</td>
	</tr>	
	
	
	<tr>
		<td  width="20%">备注：</td>
		<td  width="80%"><input type="text" name="remarks" style="width:100%"/></td>
	</tr>	
	<tr>  
		<td></td>
		 <td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <span class="table-button"> <input type="submit" class="input"  name="B334" value="保存"></span>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <span class="table-button"> <input type="reset" class="input" name="B332" value="重置"></span>
		  <span class="table-button"> <input type="hidden" name="_method" value="PUT"> </span>
		</td>
	</tr>
</table>

</form>
</body>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>
</html>
