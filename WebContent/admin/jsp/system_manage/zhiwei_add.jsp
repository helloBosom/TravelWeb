<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="<%=path%>/admin/css/main.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加角色</title>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="<%=path%>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：角色管理</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
      <form action="<%=path%>/role/add.do">
        <table align="center" class="table-form">
          <tr>
            <td colspan="5" class="table-title"> 角色添加</td>
          <tr>
            <td class="table-list_title">角色名称</td>
            <td><input name="rolename" type="text" class="input"><span class="red">*</span></td>
            <td class="table-list_title">角色描述</td>
            <td><input name="roledesc" type="text" class="input"><span class="red">*</span></td>
          </tr>
          
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="30%" class="pizhu" bgcolor="#FFFFFF">说明：其中带<span class="red">*</span>号为必填项</td>
            <td height="30" style="padding-right:300px;" class="table-button" bgcolor="#FFFFFF"><input type="submit" value="提交" > <input type="reset" value="重置"  > </td>
          </tr>
        </table>
        </form>
      </td>
    </tr>
  </table>
 
</body>
</html>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>