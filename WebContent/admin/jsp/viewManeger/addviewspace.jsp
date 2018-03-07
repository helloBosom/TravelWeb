<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <% String path = request.getContextPath();%>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/admin/css/main.css" rel="stylesheet" type="text/css">
<title>添加景区</title>	
	<script type="java/Script">
	   function mySubmit(){
	      with(document){
	         var spaceName = getElementById("spaceName");
	         if(spaceName.value == null || spaceName.value.length ==0){
	            alert("景区名称不能为空，请填上.");
	            spaceName.focus();
	            return false;
	         }else if(spaceName.value.length > 50){
	            alert("景区名称最大长度不能超过50个字符，请调整.");
	            spaceName.focus();
	            return false;
	         }
	          
	         var address = getElementById("address");
	         if(address.value == null || address.value.length==0){
	            alert("景区地址不能为空，请填上.");
	            address.focus();
	            return false;
	         }else if(address.value.length > 50){
	            alert("景区名称最大长度不能超过150个字符，请调整.");
	            address.focus();
	            return false;
	         }
	         
	         var website = getElementById("website");
	         if(website.value != null){
	            if(website.value.length > 100){
	               alert("网址的长度不能超过100个字符。");
	               website.focus();
	               return false;
	            }else if(website.value.toUpperCase().indexOf("HTTP://") != 0){
				   alert("网址必须以http://开头。");
				   website.focus();
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
      <td height=25 bgcolor="#FFFFFF"><img src="<%=path %>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：添加景区</td>
    </tr>
  </table>
  
<form  action="<%=path%>/view/addviewspace.do" onsubmit="return mySubmit()" method="post" enctype="multipart/form-data">
<table align="center" class="table-table">
          <tr>
            <td colspan="2" class="table-title"> 景区信息</td>
          </tr>
	<tr>
		<td width="20%">景区名称：</td>
		<td width="80%">
		<input type="text" name="spaceName" style="width:100%"/></td>
	</tr>
	<tr>
		<td width="20%">地址：</td>
		<td width="80%">
		<input type="text" name="address" style="width:100%" value="<%=path%>"/></td>
	</tr>
	<tr>
		<td width="20%">网址：</td>
		<td width="80%">
		<input type="text" name="website" style="width:100%"/></td>
	</tr>
	<tr>
		<td width="20%">票价：</td>
		<td width="80%">
		<input type="text" name="price" style="width:100%"/></td>
	</tr>
	<tr>
		<td width="20%">简介：</td>
		<td width="80%">
		<input type="text" name="description" style="width:100%;height:150px"/></td>
	</tr>
               <tr>
		<td  width="20%">旅游主题类型:</td>
                <c:choose>
                <c:when test="${empty themes}">
                </c:when>
                <c:otherwise>
                <td>
                <select   class='common-select' name="themeidvalue">
                <c:forEach var="v" items="${themes}">
		        <option value="${v.themeId }">${v.themeName}</option>
                </c:forEach>
                 </select>
                   </td>
                </c:otherwise>
                </c:choose>
       </tr>
        <tr>
		<td  width="20%">城市:</td>
                <c:choose>
                <c:when test="${empty citys}">
                </c:when>
                <c:otherwise>
                <td>
                <select   class='common-select' name="cityId">
                <c:forEach var="v" items="${citys}">
		        <option value="${v.id }">${v.cityname}</option>
                </c:forEach>
                 </select>
                   </td>
                </c:otherwise>
                </c:choose>
       </tr>
	<tr>
		<td width="20%">景区图片：</td>
		<td width="80%"><input  type="file"  name="imgFile"></td>
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
