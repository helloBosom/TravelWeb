<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
    + path + "/admin/jsp/";

    %>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=path%>/admin/css/main.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/admin/js/datepicker/default/datepicker.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/admin/js/datepicker/whyGreen/datepicker.css"
	rel="stylesheet" type="text/css" disabled>
<script type="text/javascript">
function deleteProductDetailById(id){
		if(window.confirm("确认删除产品详情编号为:" +id+"的记录吗?" )){
			
			window.location.href=
				"<%=path%>/product/deletedetail.do?id="+id;
				window.alert("操作成功！");
		}
	}
</script>
</head>
<body>

<table align="center" class="table-table" border="1">
          <tr>
            <td colspan="10" class="table-title" align="center">产品详情信息</td>
          <tr>
            <td class="table-title1">&nbsp;</td>
            <td class="table-title1">详细信息编号</td>
            <td class="table-title1">日期</td>
			 <td class="table-title1">线路</td>
            <td class="table-title1">目的地</td>
            <td class="table-title1">描述信息</td>
            <td class="table-title1">备注</td> 
            <td class="table-title1">操作</td> 
             
          </tr>
          
          <c:choose>
          <c:when test="${empty details}">
          <tr colspan=6>查无数据</tr>
          
          </c:when>
          <c:otherwise>
          <c:forEach items="${details}" var="v">
             <tr>
            <td align="center"><input type="checkbox" name="checkbox" value="checkbox"></td>
           <td> ${v.id}</td>
            <td>${v.date}</td>
            <td>${v.route}</td>
            <td>${v.destination}</td>
            
            <td>${v.detail}</td>
              <td>${v.remarks}</td>
          <td>
          
          <a href="<%=path%>/product/updatedetailinpute.do?id=${v.id}">修改</a>|
          <a href="javaScript:deleteProductDetailById(${v.id})">删除</a>
          </td>
          </tr>
            </c:forEach>
          </c:otherwise>
          
          </c:choose>
         
        </table>
        <br>
        <div align="right">
        <a href="<%=path%>/product/queryproductname.do" >添加详细信息</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
        </div>
 
</body>
</html>