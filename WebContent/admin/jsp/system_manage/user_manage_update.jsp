<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path%>/admin/css/main.css" rel="stylesheet" type="text/css">
<title>用户管理--修改用户</title>

</head>
<body>
 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25><img src="<%=path%>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：用户管理</td>
    </tr>
  </table>
  <form action="<%=path%>/administrator/updatebyid.do" name="updateAdmin" method="post">
  <table width="100%" align="center" class="table-list">
    <tr>
      <td>
        <table align="center" class="table-form">
          <tr>
            <td colspan="5" class="table-title"> 修改用户</td>
          <tr>
            <td width="10%" class="table-list_title">编号</td>
            <td width="40%" class="table-list_title"><input name="id" type="text" class="input" value="${admin.administratorid}" readonly="readonly"> <span class="red">*</span></td>
            <td width="10%" class="table-list_title">姓名</td>
            <td width="40%" class="table-list_title"><input name="name" type="text" class="input" value="${admin.administratorname}"> <span class="red">*</span></td>
          </tr>
          <tr>
          <td width="10%" class="table-list_title">登录名</td>
            <td width="40%" class="table-list_title"><input name="loginname" type="text" class="input" value="${admin.loginname}"><span class="red">*</span></td>
          <td width="10%" class="table-list_title">密码</td>
            <td width="40%" class="table-list_title"><input name="password" type="text" class="input" value="${admin.password}"><span class="red">*</span></td>
          </tr>
          <tr>
            <td class="table-list_title">性别</td>
            <td class="table-list_title">
              <select name="sex" class="table-list_title">
                <option value="男" <c:if test="${admin.sex eq '男'}">selected="selected"</c:if>>男</option>
                <option value="女" <c:if test="${admin.sex eq '女'}">selected="selected"</c:if>>女</option>
              </select>
              <span class="red">*</span></td>
            <td width="10%" class="table-list_title">角色</td>
            <td width="10%" class="table-list_title">
            <select  name="role" multiple="multiple" size="3">
              <c:choose>
              <c:when test="${empty roles}">
               <option value="-1">no data</option>
              </c:when>
               <c:otherwise>
               <c:forEach items="${roles}" var="v">
              	<option value="${v.roleid}" 
              	<c:forEach items="${admin.userRoles}" var="m" >
              	<c:if test="${v.roleid eq m.role.roleid}">selected="selected"</c:if>
              	</c:forEach> >
              	${v.rolename}
              	</option> 
               </c:forEach>
               </c:otherwise>
               </c:choose>
            </select>
            <span class="red">*</span></td>
          </tr>
          <tr>
            <td class="table-list_title">电话号码</td>
            <td class="table-list_title"><input name="phonenumber" type="text" class="input" value="${admin.phoneNumber}"> </td>
            <td class="table-list_title">&nbsp;</td>
            <td class="table-list_title">&nbsp;</td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="30%" class="pizhu">说明：其中带<span class="red">*</span>号为必填项</td>
            <td height="30" style="padding-right:300px;" class="table-button"> <input type="submit" value="提交" name="submit" class="input" 
> 
            <input type="reset" value="重置" name="reset" class="input" 
> </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  </form>
</body>
</html>