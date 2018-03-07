<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path%>/admin/css/main.css" rel="stylesheet" type="text/css">
<title>用户管理</title>
<script type="text/javascript">
	
	function deleteById(){
		//拼写url
		var url="<%=path%>/administrator/delete.do?t="+Math.random();
		var id = ":"
		var deleteobj = document.getElementsByName("checkbox")
		for(var i=0;i<deleteobj.length;i++){
			if(deleteobj[i].checked == true){	
			//获取复选框中所绑定的问题类别编号的值
			 url= url + "&id="+deleteobj[i].value
			 id = id +deleteobj[i].value+","
			}
		}
		id = id.substring(0, id.length-1)
		if(id.length<=1)
			  alert("请选择要删除的记录");
		else if(window.confirm("确认删除编号为"+id+"的角色信息吗？")){
			//跳转到前端控制器实现删除操作
			window.location.href= url		
		}	
	}
</script>

</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="<%=path%>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：用户管理</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
        <table align="center" class="table-form">
          <tr>
            <td colspan="7" class="table-title"> 用户查询</td>
            </tr>
          <tr>
            <td width="10%" class="table-list_title">编号</td>
            <td width="10%" class="table-list_title"><input type="text" name="id" value=""></td>
            <td width="10%" class="table-list_title">姓名</td>
            <td width="10%" class="table-list_title"><input type="text" name="name" value=""></td>
            <td width="10%" class="table-list_title">登录名</td>
            <td width="10%" class="table-list_title"><input type="text" name="loginName" value=""></td>
            <td class="table-title1">&nbsp;</td>
            </tr>
            <tr>
            <td width="10%" class="table-list_title">电话号码</td>
            <td width="10%" class="table-list_title"><input type="text" name="phone" value=""></td>
            
            
            <td width="10%" class="table-list_title">角色</td>
            <td width="10%" class="table-list_title">
            <select  name="role" multiple="multiple" size="1">
               <option value=""></option>
               <option value=""></option>
            </select>
            </td >
            <td width="10%" class="table-list_title">性别</td>
            <td  class="table-list_title">
              <select  size="1"  name="select">
                <option >男</option>
                <option>女</option>
              </select>
            </td>
            <td rowspan="2"><span class="table-button"> <input type="button" value="查询" name="B33" class="input" onClick="location.href('#')"></span></td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="60%" bgcolor="#FFFFFF">&nbsp;</td>
            <td width="40%" height="30" bgcolor="#FFFFFF" class="table-button"> <input type="button" value="添加"  class="input" onClick="location.href='<%=path%>/administrator/role.do'"> 
            <input type="button" value="删除" name="B334" class="input" onClick="deleteById()"> </td>
          </tr>
        </table>
        <table align="center" class="table-table">
          <tr>
            <td colspan="8" class="table-title"> 基本信息</td>
          <tr>
            <td class="table-title1">&nbsp;</td>
            <td class="table-title1">编号</td>
            <td class="table-title1">姓名</td>
            <td class="table-title1">登录名</td>
            <td class="table-title1">电话号码</td>
            <td class="table-title1">性别</td>
            <td class="table-title1">角色</td>
            <td class="table-title1">修改操作</td>
          </tr>
          <c:choose>
          <c:when test="${empty administrators}">
          <tr>
          <td colspan="8">no data</td>
          </tr>
          </c:when>
          <c:otherwise>
          <c:forEach items="${administrators}" var="v">
          <tr>
            <td align="center"><input type="checkbox" name="checkbox" value="${v.key.administratorid}"></td>
            <td>${v.key.administratorid}</td>
            <td>${v.key.administratorname}</td>
            <td>${v.key.loginname}</td>
            <td>${v.key.phoneNumber}</td>
            <td>${v.key.sex}</td>
            <td><c:forEach items="${administrators[v.key]}" var="m">
            ${m}&nbsp;
            </c:forEach>
            </td>
            <td class="table-title1"><input type="button" value="修改用户" name="update"  onClick="location.href='<%=path%>/administrator/update.do?id=${v.key.administratorid}'">  </td>
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
      </td>
    </tr>
  </table>
</body>
</html>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>