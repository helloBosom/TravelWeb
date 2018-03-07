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

<%-- <link href="<%=path%>/admin/css/tree.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="<%=path%>/admin/js/frame/xtree.js"></script>
    <script type="text/javascript" src="<%=path%>/admin/js/frame/frame.js"></script> --%>

<link rel="stylesheet" type="text/css"
	href="<%=path%>/jqueryui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/jqueryui/themes/icon.css">
<script type="text/javascript" src="<%=path%>/jqueryui/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/jqueryui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/jqueryui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
$(function(){  
    $('#tt').tree({  
    	checkbox:true,
        lines:true, 
        animate : true, 
        url: '<%=path%>/menu/doLogin.do?roleid=${param.id}',  
        onClick: function(node){  
            $(this).tree('toggle', node.target);  
            //alert('you dbclick '+node.text);  
        }
    });  
});  
function getChecked(){  
    var nodes = $('#tt').tree('getChecked',['checked']);  
    var url = '<%=path%>/menu/savemenu.do?t='+Math.random();  
    for (var i = 0; i < nodes.length; i++) { 
        
        url = url + "&id="+ nodes[i].id;  
    }  
    url = url + "&roleid="+ ${param.id};
    window.location.href= url
}
</script>

<% 
String name1 = request.getParameter("name");
String name = new String(name1.getBytes("iso8859-1"),"utf-8");  %>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="<%=path%>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：角色-->权限分配 </td>
    </tr>
  </table>
  <table align="center" class="table-list">
    <tr>
      <td>
        <table class="table-table">
          <tr>
            <td class="table-title">权限分配</td>
          </tr>
          <tr>
          </table>
         
          <table class="table-table">
          <tr>
            <td width="10%" class="table-list_title">角色编号</td>
            <td>
              <input type="text" name="roleid" value="${param.id}" readonly="readonly">
            </td>
            <td width="10%" class="table-list_title">角色名称</td>
          	<td>
              <input type="text" name="roledname" value="<%=name%>" readonly="readonly">
            </td>
            </tr>
            </table>
        </table>
         <form name="form1" method="post" action="order_list.html">
          <table border="0" align="center" cellspacing="0" class="table-button">
            <tr>
              <td>
                <!-- <iframe name="left" width="250" height="300" src="main.jsp"></iframe> -->
                
              </td> 
            </tr>
          </table>
          <div align="left"><ul id="tt" class="easyui-tree"></ul></div>
          <table align="center" cellpadding="0" cellspacing="6" class="table-button">
            <tr>
              <td><input name="save" type="button" class="cancle" value="保存" onclick="getChecked()">&nbsp;&nbsp;&nbsp;&nbsp; 
              <input name="reset" type="button"  class="cancle" value="返回" onclick="location.href='<%=path%>/menu/return.do'" > </td>
            </tr>
          </table>
        </form>
      </td>
    </tr>
  </table>
</body>
</html>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>