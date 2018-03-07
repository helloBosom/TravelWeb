<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String path=request.getContextPath(); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/admin/css/main.css" rel="stylesheet" type="text/css">
<title>添加景区的景点</title>
	<script>
	   function mySubmit(){
	      with(document){
	         var pointName = getElementById("pointName");
	         if(pointName.value == null || pointName.value.length ==0){
	            alert("景点名称不能为空，请填上.");
	            pointName.focus();
	            return false;
	         }else if(pointName.value.length > 100){
	            alert("景点名称最大长度不能超过50个字符，请调整.");
	            pointName.focus();
	            return false;
	         }
	          
	         var ticketPrice = getElementById("ticketPrice");
	         if(ticketPrice.value != null && ticketPrice.value.length > 0){
	            if(!/^(-|\+|([0-9]))([0-9])*\.?([0-9])*$/.test(ticketPrice.value)){
				    alert("景点票价不是合法的数字，请调整.");
					ticketPrice.focus();
					return false;
				}
	         }
	           
	         return true;
	      }
	      
	   }
	</script>
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
		<tr>
			<td height=25 bgcolor="#FFFFFF"><img src="<%=path %>/dmin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：添加景点</td>
		</tr>
	</table>
	<%@ include file="includeTop.jsp"%>
<form action="<%=path%>/view/savepoint.do" method="post" onsubmit="return mySubmit()" enctype="multipart/form-data">

<table align="center" class="table-table">
          <tr>
            <td colspan="2" class="table-title"> 景点信息</td>
          </tr>
    <tr>
		<td  width="20%">景区名称：</td>
		<td  width="80%"><input type="text" name="spaceName" value="${viewSpace.spaceName}" style="width:100%"/></td>
	</tr>
	<tr>
		<td  width="20%">景点名称：</td>
		<td  width="80%"><input type="text" name="pointName" style="width:100%"/></td>
	</tr>
	<tr>
		<td  width="20%">景点票价：</td>
		<td  width="80%"><input type="text" name="ticketPrice" style="width:100%"/></td>
	</tr>
	<tr>
		<td width="20%">景点简介：</td>
		<td  width="80%"><input type="text" name="description" style="width:100%;height:100px"/></td>
	</tr>
	<tr>
		<td  width="20%">景点图片：</td>
		<td  width="80%"><input type="file" name="imgFile"></td>
	</tr>	
	<tr>  
		<td></td>
		
		 <td align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <span class="table-button"> <input type="submit" class="input"  name="B334" value="保存"></span>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <span class="table-button"> <input type="reset" class="input" name="B332" value="重置"></span>
		  <span class="table-button"> <input type="hidden" name="_method" value="PUT"> </span>
		 
		    <input type="hidden" name="spaceId" value="${viewSpace.spaceId }"/>
		</td>
	</tr>
</table>

</form>
</body>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>
</html>
