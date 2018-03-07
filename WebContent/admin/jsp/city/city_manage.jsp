<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 	String path = request.getContextPath(); 
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/admin/";  
 %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>城市管理</title>
  <base href="<%=basePath%>">
  <link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>

<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="images/frame/web_icon01.gif" width="11" height="8" > 当前位置：城市管理</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
<form action="<%=path %>/city/querybycondition.do" method="post">
        <table align="center" class="table-form">
          <tr>
            <td colspan="5" class="table-title"> 城市查询</td>
          <tr>
            <td width="10%" class="table-list_title">城市</td>
            <td><input name="cityName" type="text" id="cityName"/></td>
            <td width="10%" class="table-list_title">城市编号</td>
            <td><input name="cityId" type="text" id="cityId"/></td>
             <td><span class="table-button"> 
            <!-- <input type="submit" value="查询" name="submit" class="input"> -->
             <input type="button" value="查询" name="query" class="input" 
              onClick="window.location='<%=path%>/city/querybycondition.do?a=1&cityname='+document.getElementById('cityName').value+'&id= '+document.getElementById('cityId').value">
             
             </span></td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="60%" bgcolor="#FFFFFF">&nbsp;</td>
            <td width="40%" height="30" bgcolor="#FFFFFF" class="table-button"> 
            <input type="button" value="添加" name="button1" class="input"   onClick="window.location='<%=path%>/city/to_add.do'">
           </td>
          </tr>
        </table>
        </form>
         <form action="<%=path %>/system/addrole.do" method="post">
         <table class="table-table">
            <tr>
              <td  class="table-title">城市查询</td>
               </tr>
          </table>

          <table width="100%" align="center" class="table-table">
            <tr>
              <td width="8%" class="table-title1">城市编号</td>
              <td width="22%" class="table-title1">城市</td>
              <td width="27%" class="table-title1">备注</td>              
              <td width="19%" class="table-title1">操作</td>
            </tr>
            <c:choose>
  	    <c:when test="${empty cities }">
  		  <tr><td colspan="6">查无数据</td></tr>
  	    </c:when>
  	    <c:otherwise>
  		  <c:forEach items="${cities }" var="v">
  			<tr>
              <td>${v.id }</td>
              <td>${v.cityname }</td>
              <td>${v.remarks}</td>            
   			  <td><a href="<%=path%>/city/to_update.do?id=${v.id}">修改</a>|<a href="<%=path%>/city/delete.do?id=${v.id}">删除</a></td>
   			 </tr>
  		   </c:forEach>
  		  </c:otherwise>
 		</c:choose>
 
          </table>
        <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td align="right" bgcolor="#FFFFFF"> 共1条记录 <a href="#">首页</a> | <a href="#">上一页</a> | <a href="#">下一页</a> | <a href="#">尾页</a>
              <select name="_page">
                <option value="1" selected="selected">1/2</option>
                <option value="2">2/2</option>
              </select>
            </td>
          </tr>
        </table>
  </form>
      </td>
    </tr>
  </table>

</body>
</html>
