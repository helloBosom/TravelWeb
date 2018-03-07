<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String path=request.getContextPath(); %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>旅游主题管理</title>
  <link href="<%=path %>/admin/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="<%=path %>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：旅游主题管理</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
        <table align="center" class="table-form">
          <tr>
            <td colspan="3" class="table-title"> 主题查询</td>
          </tr>
          <form action="<%=path %>/theme/search.do">
          <tr>
            <td class="table-list_title">主题名称</td>
            <td><input name="themename" type="text" class="input" value=""></td>
            <td><span class="table-button"><input type="submit" value="查询" name="B33" class="input"> </span></td>
          </tr>
          </form>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="60%" bgcolor="#FFFFFF">&nbsp;</td>
            <td width="40%" height="30" bgcolor="#FFFFFF" class="table-button">
			<input type="button" value="添加" name="B332" class="input" onClick="window.location='<%=path%>/theme/add.do';">																
			<input type="button" value="删除" name="B334" class="input" onClick="window.location='#';"></td>
          </tr>
        </table>
        <table align="center" class="table-table">
          <tr>
            <td colspan="7" class="table-title">主题信息</td>
          </tr>
          <tr>
            <td width="5%" class="table-title1">选择</td>
            <td class="table-title1">主题名称</td>
            <td class="table-title1">描述</td>
            <td width="5%" class="table-title1">序号</td>
            <td class="table-title1">操作</td>
          </tr>
          <c:choose>
          <c:when test="${empty themes}">
          <tr>
          <td colspan="5" align="center">没有数据</td>
          </tr>
          </c:when>
          <c:otherwise>
          <c:forEach var="v" items="${themes }">
          <tr>
            <td><input type="checkbox" name="themeId" value="checkbox"></td>
        <td>  <a href="<%=path%>/theme/${v.themeId}/search.do">${v.themeName }</a> </td>
           <td>${v. themeDescribe}</td>
           <td>${v.themeId }</td>
           <td><a href="<%=path%>/theme/${v.themeId}/edit.do">修改</a>&nbsp;
           <a href="<%=path%>/theme/${v.themeId}/delete.do">删除</a></td>
          </tr>
          </c:forEach>
          </c:otherwise>
          </c:choose>
          
          
        </table>
        <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td align="right" bgcolor="#FFFFFF"> 共${totalpages }页
            <a  href="<%=path%>/theme/search.do?currenpage=1&themename=${themename}">首页</a> | 
            <a href="<%=path%>/theme/search.do?currenpage=${currenpage<2?1:currenpage-1}&themename=${themename}">上一页</a> |
             <a href="<%=path%>/theme/search.do?currenpage=${currenpage<totalpages?currenpage+1:totalpages}&themename=${themename}">下一页</a> | 
             <a href="<%=path%>/theme/search.do?currenpage=${totalpages}&themename=${themename}">尾页</a>
             <form action="<%=path %>/theme/queryall.do?"></form>
              <select name="currenpage">
               <script type="java/script">	
				</script>
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
