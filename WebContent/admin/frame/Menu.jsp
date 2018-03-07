<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>环球风情分销平台</title>
 
  <link href="<%=path%>/admin/css/tree.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="<%=path%>/admin/js/frame/xtree.js"></script>
    <script type="text/javascript" src="<%=path%>/admin/js/frame/frame.js"></script>

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
    	lines: true, 
    	animate : true,
        url: '<%=path%>/menu.do',  
        onClick: function(node){  
            $(this).tree('toggle', node.target);  
            if(node.href !== undefined && node.href !=""){
              var address = '<%=path%>' + (node.href);
              $(window.parent.document).find("#BoardRight").attr("src",address)
              
            }
        }
    });  
});  

</script>
</head>

<body>

	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<div><ul id="tt" class="easyui-tree"></ul></div>

</body>
</html>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>