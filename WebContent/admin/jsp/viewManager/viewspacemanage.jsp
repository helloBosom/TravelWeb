<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>景区管理</title>
  <link href="<%=path%>/admin/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="<%=path%>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：景区管理</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
       <form  action="<%=path %>/view/search.do" >  
      <table align="center" class="table-form">
          <tr>
            <td colspan="3" class="table-title"> 景区查询</td>
          </tr>
          <tr>
            <td class="table-list_title">景区名称</td>
            <td><input name="spaceName" type="text" class="input" style="width:400px"></td>
            <td><span class="table-button"><input type="submit" value="查询" name="B33" class="input" > </span></td>
          </tr>
      </form>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="60%" bgcolor="#FFFFFF">&nbsp;</td>
            <td width="40%" height="30" bgcolor="#FFFFFF" class="table-button">
			<input type="button" value="添加" name="B332" class="input" onClick="window.location='<%=path%>/view/add.do';">
			
			<input type="button" value="删除" name="B334" class="input" onClick="window.location='#';"></td>
          </tr>
        </table>
<table align="center" class="table-table">
          <tr>
            <td colspan="6" class="table-title"> 景区信息</td>
          </tr>
          <tr>
            <td width="5%" align="center" class="table-title1">选择</td>
            <td width="10%" align="center" class="table-title1">景区名称</td>
            <td width="10%" align="center" class="table-title1">地址</td>
            <td width="%" align="center" class="table-title1">描述</td>
            <td width="5%" align="center" class="table-title1">序号</td>
            <td width="10%" align="center" class="table-title1">操作</td>
          </tr>
				<c:choose>
				<c:when test="${empty viewSpaces }">
			 <tr><td clospan="6">no data</td></tr>
				</c:when>
				<c:otherwise>
            <c:forEach var="viewSpace" items="${viewSpaces}"  varStatus="status">
                <tr>
            	<td><input type="checkbox" name="checkbox" value="checkbox"></td>
				<td><a href="<c:url value="/view/showview/${viewSpace.spaceId}.do"/>">
						   ${viewSpace.spaceName}
					</a>
					</td>
					<td>${viewSpace.address}</td>
					<td>${viewSpace.description}</td>
					<td>${status.count }</td>
					<td><a href="<%=path%>/view/edit/${viewSpace.spaceId }.do">修改</a>&nbsp;
					<a href="<%=path %>/view/delete/${viewSpace.spaceId }.do">删除</a></td>
					</tr>
			</c:forEach>
			</c:otherwise>
          </c:choose>
        </table>
        <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td align="right" bgcolor="#FFFFFF"> 共${totalpages}页 
            <a href="<%=path%>/view/search.do?currenpage=1&spaceName=${spaceName}">首页</a>| 
            <a href="<%=path%>/view/search.do?currenpage=${currenpage<2?1:currenpage-1}&spaceName=${spaceName}">上一页</a> | 
            <a href="<%=path%>/view/search.do?currenpage=${currenpage<totalpages?currenpage+1:totalpages}&spaceName=${spaceName}">下一页</a> | 
            <a href="<%=path%>/view/search.do?currenpage=${totalpages}&spaceName=${spaceName}">尾页</a>
              <select name="_page">
                <option value="1" selected="selected">1/2</option>
                <option value="2">2/2</option>
              </select>
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</body>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>
</html>
