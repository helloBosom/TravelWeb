<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    String path = request.getContextPath();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=GBK">
  <title>业务系统申请表</title>
  <link href="../../css/main.css" rel="stylesheet" type="text/css">
  <script language="javascript" type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
  <link href="../../js/datepicker/default/datepicker.css" rel="stylesheet" type="text/css">
  <link href="../../js/datepicker/whyGreen/datepicker.css" rel="stylesheet" type="text/css" disabled="disabled">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>订单号</td>
		<td>订单人</td>
		<td>联系电话1</td>
		<td>产品名称</td>
		<td>路线类型</td>
		<td>应付金额</td>
		<td>负责人</td>	
	</tr>
	<c:choose>
            <c:when test="${empty orders}">
               <tr>
                			<td colspan="5">no data</td>
                		</tr>
                	</c:when>
                	<c:otherwise>
                		<c:forEach var="v"  items="${orders}">
                			<tr>
                			   <td height="28">${v.orderNum}</td>
                               <td height="28">${v.customer }</td>
                               <td height="28">${v.c_phone1 }</td>
                               <td height="28">${v.product }</td>
                               <td height="28">${v.viewroute }</td>                        
                               <td height="28">${v.payable }</td>
                               <td height="28">${v.manageName }</td>
                			</tr>
                		</c:forEach>
                	</c:otherwise>
                </c:choose>
</table>

</body>
</html>