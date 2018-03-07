<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="<%=path%>/admin/css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="<%=path%>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle">当前位置：角色列表 </td>
    </tr>
  </table>
  <table align="center" class="table-list">
    <form name="form1" method="post" action="">
      <tr>
        <td>
          <table class="table-table">
            <tr>
              <td class="table-title">角色列表</td>
            </tr>
          </table>
          <table width="100%" align="center" class="table-table">
            <tr>
              <td width="8%" class="table-title1">角色编号</td>
              <td width="22%" class="table-title1">角色名称</td>
              <td width="27%" class="table-title1">角色描述</td>
              <td width="19%" class="table-title1">权限分配</td>
            </tr>
			<c:choose>
			<c:when test="${empty roles}">
			<tr><td colspan="4"></td></tr>
			</c:when>
			<c:otherwise>
			<c:forEach items="${roles}" var="v">
			<tr>
              <td  align="center">${v.roleid}</td>
              <td align="center">${v.rolename}</td>
              <td align="center">${v.roledesc}</td>
              <td align="center"><span class="table-list_title"><a href="<%=path%>/admin/jsp/system_manage/menu_list.jsp?id=${v.roleid}&name=${v.rolename}">权限分配</a></span></td>
            </tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
          </table>
        </td>
      </tr>
    </form>
  </table>
</body>
</html>
