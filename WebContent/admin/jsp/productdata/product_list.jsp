<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
  request.setCharacterEncoding("utf-8");
  response.setCharacterEncoding("utf-8");
%>    
<%
String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>productlist</title>
  <link href="../../css/main.css" rel="stylesheet" type="text/css">
    <link href="../../js/datepicker/default/datepicker.css" rel="stylesheet" type="text/css">
  <link href="../../js/datepicker/whyGreen/datepicker.css" rel="stylesheet" type="text/css" disabled>
    <script language="javascript" type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
</head>
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="../../images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：查询产品</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
        <table align="center" class="table-form">
          <tr>
            <td colspan="7" class="table-title"> 产品查询</td>
          <tr>
            <td class="table-list_title">产品名称</td>
            <td>
              <input name="textfield2" type="text" class="input"></td>
              <td class="table-list_title">产品编号</td>
            <td>
              <input name="textfield2" type="text" class="input"></td>
              <td rowspan="3"><span class="table-button"><input type="button" value="查询" name="B33" class="input" onClick="window.location='product_detail_list.html';"></span></td>
          </tr>
          <tr>
            <td  class="table-list_title">线路类型</td>
            <td>
              <select name='select' class='common-select'>
                <option>一日游</option>
                <option>二日游</option>
              </select>            </td>
            <td class="table-list_title">行程天数</td>
            <td>
              <input name="textfield2" type="text" class="input">            </td>
            
          </tr>
          <tr>
            <td class="table-list_title">产品状态</td>
            <td>
              <select name='ruirong'  class='common-select'>
                <option selected>全部</option>
                <option>销售中</option>
                <option>已过期</option>
              </select>            </td>
             <td class="table-list_title" colspan="2"></td>
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
            <td colspan="9" class="table-title"> 产品基本信息</td>
          <tr>
            <td class="table-title1">&nbsp;</td>
            <td class="table-title1">产品编号</td>
            <td class="table-title1">产品名称</td>
            <td class="table-title1">行程天数</td>
			 <td class="table-title1">线路名称</td>
            <td class="table-title1">产品状态</td>
            <td class="table-title1">备注信息</td> 
          </tr>
          
         <c:choose>
          <c:when test="${empty details}">
          <tr colspan="6" class="table-title">查无数据</tr>
          
          </c:when>
          
          
          
          <c:otherwise>
          <c:forEach items="${details}" var="v">
          
          <tr>
            <td align="center"><input type="checkbox" name="checkbox" value="checkbox"></td>
           <td class="table-title1"> <a href="<%=path%>/product/querydetail.do?productid=${v[0]}"> ${v[0]}</a></td>
            <td class="table-title1">${v[1]}</td>
            <td class="table-title1">${v[2]}</td>
            <td class="table-title1">${v[3]}</td>
            <td class="table-title1">
            <c:if test="${v[4]}==0}"><td>销售中...</td></c:if>
             <c:if test="${v[4]}==1}"><td>已过期</td></c:if>
             </td>
            <td class="table-title1">${v[5]}</td>
          
          </tr>
         </c:forEach>
         </c:otherwise>
         
         </c:choose>
         
          
        </table>
        
        <table  width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" >
          <tr align="center">
            <td align="center" bgcolor="#FFFFFF" > 共1条记录 <a href="#">首页</a> | <a href="#">上一页</a> | <a href="#">下一页</a> | <a href="#">尾页</a>
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
