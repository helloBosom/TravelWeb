<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品信息列表</title>
<link href="<%=path%>/admin/css/main.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/admin/js/datepicker/default/datepicker.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/admin/js/datepicker/whyGreen/datepicker.css"
	rel="stylesheet" type="text/css" disabled>
<script language="javascript" type="text/javascript"
	src="<%=path%>/admin/js/datepicker/WdatePicker.js"></script>

<script type="text/javascript">
	
	function deleteProductById(productid){
		if(window.confirm("确认删除产品编号为:" +productid+"的记录吗?" )){
			
			window.location.href=
				"<%=path%>/product/deleteproduct.do?productid="+productid;
				window.alert("操作成功！");
		}
	}
	
	function query(currentpage){
		window.alert(currentpage);
		window.location.href="<%=path%>/product/findbypage.do?currentpage=currentpage";
	}
</script>

</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		class="table-location">
		<tr>
			<td height=25 bgcolor="#FFFFFF"><img
				src="../../images/frame/web_icon01.gif" width="11" height="8"
				align="absmiddle"> 当前位置：查询产品信息</td>
		</tr>
	</table>
	<table width="100%" align="center" class="table-list">
		<tr>
			<td bgcolor="#FFFFFF">
			
			 <form action="<%=path%>/product/vaguequeryproduct.do"> 
				<table align="center" class="table-form">
					<tr>
						<td colspan="7" class="table-title">产品查询</td>
					<tr>
						<td class="productName">产品名称</td>
						<td><input name="productName" type="text" class="input"></td>
						<td class="table-list_title">产品编号</td>
						<td><input name="productid" type="text" class="input"></td>
						<td rowspan="3"><span class="table-button"><input
								type="submit" value="查询" name="submit" class="input"
								></span></td>
					</tr>
					<tr>
						<td class="table-list_title">线路类型</td>
						<td><select name='routename' class='common-select'>
								<option value="一日游">一日游</option>
								<option value="二日游">二日游</option>
						</select></td>
						<td class="table-list_title">行程天数</td>
						<td><input name="days" type="text" class="input">
						</td>

					</tr>
					<tr>
						<td class="table-list_title">产品状态</td>
						<td><select name='status' class='common-select'>
								<option value="0">销售中</option>
								<option value="1">已过期</option>
						</select></td>
						<td class="table-list_title" colspan="2"></td>
					</tr>
				</table>
			
			
			
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="60%" bgcolor="#FFFFFF">&nbsp;</td>
						<td width="40%" height="30" bgcolor="#FFFFFF" class="table-button">
						</td>
					</tr>
				</table>
				</form>
				
				
				
				
				<table align="center" class="table-table">
          <tr>
            <td colspan="9" class="table-title"> 产品基本信息</td>
          <tr>
            <td class="table-title1">&nbsp;</td>
            <td class="table-title1">产品编号</td>
            <td class="table-title1">产品名称</td>
             <td class="table-title1">产品价格</td>
            <td class="table-title1">行程天数</td>
			 <td class="table-title1">线路名称</td>
            <td class="table-title1">产品状态</td>
            <td class="table-title1">备注信息</td> 
            <td>操作</td>
          </tr>
          
         <c:choose>
          <c:when test="${empty details}">
          <tr colspan="7" class="table-title">查无数据</tr>
          
          </c:when>
          
          
          
          <c:otherwise>
          <c:forEach items="${details}" var="v">
          
          <tr>
            <td align="center"><input type="checkbox" name="checkbox" value="checkbox"></td>
           <td class="table-title1"> <a href="<%=path%>/product/querydetail.do?productid=${v[0]}" title="点击查看详情"> ${v[0]}</a></td>
            <td class="table-title1">${v[1]}</td>
            <td class="table-title1">${v[6]}</td>
            <td class="table-title1">${v[2]}</td>
            <td class="table-title1">${v[3]}</td>
           
          
           
             <c:if test="${v[4]==0}"><td class="table-title1">销售中...</td></c:if>
             <c:if test="${v[4]==1}"><td class="table-title1">已过期...</td></c:if>  
            
            <td class="table-title1">${v[5]}</td>
            <td>
            <a href="<%=path%>/product/updateinput.do?productid=${v[0]}">修改</a>|
            
            <a href="javaScript:deleteProductById(${v[0]})">删除</a ></td>
          
          </tr>
         </c:forEach>
         </c:otherwise>
         
         </c:choose>
         
          
        </table>
				<table width="96%" height="30" border="0" align="center"
					cellpadding="0" cellspacing="0">
					<tr>
						<td align="right" bgcolor="#FFFFFF">共${count}条记录 <a
							href="<%=path%>/product/findbypage.do?currentpage=1">首页</a> |<a
							href="<%=path%>/product/findbypage.do?currentpage=${ (currentpage-1 < 1)?1:currentpage-1}">上一页</a>|
							<a
							href="<%=path%>/product/findbypage.do?currentpage=${ (currentpage+1 > totalPages) ? totalPages:currentpage+1}">下一页</a>|

							<a
							href="<%=path%>/product/findbypage.do?currentpage=${totalPages} ">末页</a>
						</td>
						<td align="left">
						&nbsp;&nbsp;&nbsp;&nbsp;
						<select name="_page">

							<c:forEach begin="1" end="${totalPages}" varStatus="vs">
							<option value="1" selected="selected" onclick="query(${vs.index});">${vs.index }/${totalPages}</option>

							</c:forEach>
						</select>

						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	
</body>
</html>