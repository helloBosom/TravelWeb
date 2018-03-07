<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/admin/";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=GBK">
  <title>日期财务统计</title>
  <base href="<%=basePath%>">
  <link href="css/main.css" rel="stylesheet" type="text/css">
  <script language="javascript" type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
  <link href="js/datepicker/default/datepicker.css" rel="stylesheet" type="text/css">
  <link href="js/datepicker/whyGreen/datepicker.css" rel="stylesheet" type="text/css" disabled="disabled">
</head>
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="../../images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：查询订单</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="60%" bgcolor="#FFFFFF">　</td>
            <td width="40%" height="30" bgcolor="#FFFFFF" class="table-button">
			
			</td>
          </tr>
        </table>
        <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
      <form name="query" action="<%=path%>/finanical/fufu.do" method="post">
        <table align="center" class="table-form">
          <tr>
            <td colspan="7" class="table-title"> 财务系统查询</td>
          <tr>
            <td class="table-list_title">日期</td>
            <td> <input name="daytime" type="text"></td>
            <td class="table-list_title">产品</td>
            <td> <input name="productname" type="text" class="input"> </td>
           
            <td rowspan="3"><span class="table-button"><input type="submit" value="查询" name="B33" class="input" ></span></td>
            
            
          </tr>
          </table>
          </form>
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="60%" bgcolor="#FFFFFF">　</td>
            <td width="40%" height="30" bgcolor="#FFFFFF" class="table-button">			
          </tr>
        </table>
        
        <table align="center" class="table-table">
          <tr>
            <td colspan="5" class="table-title"><imput type="submit" > 基本详情</td>
          <!-- <tr>
            <td class="table-title1">订单编号</td>
            <td><input name="text" type="text" class="Wdate" onFocus="new WdatePicker(this,'%Y-%M-%D',true)"></td>
          </tr> -->
         <tr>
         
         <td colspan="5" align="right">
         
         <a href="<%=path%>/finanical/fufu.do">查看统计图</td></tr>
        
          <tr>
          <td align="center"> <input type="checkbox" name="checkbox" value="checkbox"> </td>                     
            <td class="table-title1">日期</td>
            <td class="table-title1">产品名称</td>
            <td class="table-title1">人次</td>
            <td class="table-title1">总收入（人民币）</td>                     
         </tr>
          
         <c:choose>
            <c:when test="${empty lists}">
               <tr>
                			<td colspan="11">no data</td>
                		</tr>
                	</c:when>
                	<c:otherwise>
                		<c:forEach var="v"  items="${lists}">
                			<tr>
                			<td align="center"> <input type="checkbox" name="checkbox" value="checkbox"> </td>
                			   <td height="28">${v[0]}</td>
                			   <td height="28">${v[1]}</td>
                               <td height="28">${v[2]}</td>
                               <td height="28">${v[3]}</td>                                                             
                			</tr>
               		</c:forEach>
                	</c:otherwise>
                </c:choose>
           
        </table>
        
       
      </td>
    </tr>
    
  </table>
  
<img  src="<%=path%>/chartimages/${barchart}">

<img  src="<%=path%>/chartimages/${piechart}">
<img  src="<%=path%>/chartimages/${linechart}">
</body>
</html>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>
