<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%String path =request.getContextPath();
         String basepath=request.getScheme()+"://"+request.getServerName()+":"
         +request.getServerPort()+path+"/admin/jsp/routedate";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>查询路线</title>
  <link href="<%=path %>/admin/css/main.css" rel="stylesheet" type="text/css">
  <link href="<%=path %>/admin/js/datepicker/default/datepicker.css" rel="stylesheet" type="text/css">
  <link href="<%=path %>/admin/js/datepicker/whyGreen/datepicker.css" rel="stylesheet" type="text/css" disabled>
    <script language="javascript" type="text/javascript" src="<%=path %>/admin/js/datepicker/WdatePicker.js"></script>
    
</head>
<script language="javascript" type="text/javascript">
  function del(){
  var box = document.getElementsByName("checkbox");
  var boxvalue = new Array();
  for(i=0; i<box.length; i++)
  {
  if(box[i].checked)
  boxvalue[i] = box[i].value;
  }
  if(boxvalue.length<=0)
  alert("请选择要删除的记录");
  else
   if(confirm("确认删除此记录吗？"))
   window.location.reload();
  }
</script>
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="<%=path %>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：查询线路 </td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">-
        <form action="<%=path %>/route/currentPage.do" method="post">
        <table align="center" class="table-form">
          <tr>
           
            <td width="10%" class="table-list_title">路线名称</td>
            <td><input name="routename" type="text" class="input" placeholder="路线名称"><span class="red">*</span></td>
            <td height="30" style="padding-right:300px;" class="table-button"> <input type="submit" value="查询" name="B333" class="input" ></td>
            <td height="30" style="padding-right:300px;" class="table-button"> <a href="<%=path %>/admin/jsp/routedate/route_add.jsp"><input type="button" value="添加" name="B333" class="input" ></a></td>
          </tr>

        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="60%" bgcolor="#FFFFFF">&nbsp;</td>
            <td width="40%" height="30" bgcolor="#FFFFFF" class="table-button">&nbsp;</td>
          </tr>
        </table>
        
        <table align="center" class="table-table">
          <tr>
            <td colspan="7" class="table-title">线路基本信息</td>
          <tr>
            <td width="10%" class="table-title1">&nbsp;</td>
            <td width="20%" class="table-title1">路线名称</td>
            <td width="20%" class="table-title1">发布日期</td>
            <td width="20%" class="table-title1">路线专员</td>
            <td width="15%" class="table-title1">路线状态</td>
            <td width="15%" class="table-title1">操作</td>
          </tr>
          <c:choose>
             <c:when test="${empty viewroutes}">
             <tr><td colspan="6">no data</td></tr>
             </c:when>
             <c:otherwise>
              <c:forEach    items="${viewroutes}"  var="v" >
              <tr>
                <td align="center"><input type="checkbox" name="checkbox" value="checkbox"></td>

                <td  title="单击查看详细信息" style="cursor:hand" onClick="location.href('#')">${v.routename}</td> 
                <td  title="单击查看详细信息" style="cursor:hand" onClick="location.href('#')">${v.publishdate}</td> 
                <td  title="单击查看详细信息" style="cursor:hand" onClick="location.href('#')">${v.routeuserid}</td> 
                <td  title="单击查看详细信息" style="cursor:hand" onClick="location.href('#')">${v.routestates}</td> 
                <td><a href="<%=path %>/route/queryviewroutebyid.do?viewrouteid=${v.routeid}">   修改   </a>  |  <a href="<%=path %>/route/removeviewroute.do?viewrouteid=${v.routeid}">   删除   </a></td>
               </tr>
              </c:forEach>
             </c:otherwise>
          </c:choose>
          
        </table>
      
        <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td align="right" bgcolor="#FFFFFF"> 共${totalpages}页 <a href="<%=path %>/route/currentPage.do?currenpage=1">首页</a> | 
            <a href="<%=path %>/route/currentPage.do?currenpage=${currenpage>1?currenpage-1:1}">上一页</a> | 
            <a href="<%=path %>/route/currentPage.do?currenpage=${currenpage<totalpages?currenpage+1:totalpages}">下一页</a> |
             <a href="<%=path %>/route/currentPage.do?currenpage=${totalpages}">尾页</a>
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}
</script>
