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
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>订单详细信息</title>  
  <link href="<%=path%>/admin/css/main.css" rel="stylesheet" type="text/css">
  <link href="<%=path%>/admin/css/grid.css" rel="stylesheet" type="text/css">
  <script src="<%=path%>/admin/js/web.js"></script>
  <script language="javascript" type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
  <link href="<%=path%>/admin/js/datepicker/default/datepicker.css" rel="stylesheet" type="text/css">
  <link href="<%=path%>/admin/js/datepicker/whyGreen/datepicker.css" rel="stylesheet" type="text/css" disabled>
</head>
<script language="JavaScript">
function initEnddate(obj)
	{
		var a = new Date();
		var n_month,n_date;
		if( a.getMonth() + 1<10 )
		  {	n_month = "0"+(a.getMonth() + 1);
		  		//alert (n_month);
		  }
		 else{
		 	n_month = a.getMonth() + 1;
		 }
		 if ( a.getDate()<10  )
		  {
			   n_date = "0"+ a.getDate();
			   //alert (n_date);
		  }
		  else{
		  	 n_date = a.getDate();
		  } 
		
		var b=a.getFullYear() + "-" + n_month + "-" + n_date;
		//var b=a.getFullYear() + "-" + (a.getMonth() + 1) + "-" + a.getDate();
		//document.write(a.getFullYear() + "-" + (a.getMonth() + 1) + "-" + a.getDate());
		document.all(obj).value=b;
	}

	</script>
<body>
 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：订单详细信息表</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
        <table width="100%" class="title_table1">
          <tr >
            <td colspan="4" align="left" class="title_table1"> 订单详细 </td>
          </tr>
        </table>
        <table  id="table0" align="center" class="table-form">
        <c:choose>
            <c:when test="${empty orders}">
               <tr>
                	<td colspan="11">no data</td>
                	</tr>
                	</c:when>
                	<c:otherwise>
                		<c:forEach var="v"  items="${orders}">
                			<tr>                			
                			   <td class="table-list_title">订单编号：</td>
            				   <td>${v[0]}</td>
            				   <td class="table-list_title">订单号：</td>
            				   <td>${v[1]}</td>                               
                			</tr>                			
                			<tr>
            					<td class="table-list_title">订单人：</td>
            					<td>${v[2]}</td>            
           						<td class="table-list_title">联系电话：</td>
            					<td>${v[3]}</td>           
           					</tr>
           					<tr>           
           						<td  class="table-list_title">备用联系方式：</td>
            					<td>${v[4]}</td>
            					<td class="table-list_title">产品名称：</td>
            					<td>${v[5]}</td>
          					</tr>
           					<tr>
		   						<td  class="table-list_title">线路类型：</td>
		   						<td>${v[6]}</td>
		     					<td  class="table-list_title">下单日期：</td>
		   						<td>${v[7]}</td>
	    					</tr>
	    					<tr>
           						 <td class="table-list_title">出团日期起：</td>
           						 <td>${v[8]}</td>
            					<td class="table-list_title">出团日期止：</td>
            					<td>${v[9]}</td>
          					</tr>
          					<tr>
            					<td class="table-list_title">人数：</td>
            					<td>${v[10]}</td>
            					<td class="table-list_title">订单状态：</td>
		   						<td>${v[13]=='1'?'已审核':'未审核'}</td>
            					
          					</tr>
          					<tr>
		   						<td class="table-list_title">应付总金额：</td>
		   						<td>${v[11]}</td>
		   						<td class="table-list_title">未付总金额：</td>
            					<td>${v[12]}</td>
	   						 </tr>
	   						 <tr>
		   						<td class="table-list_title">负责人：</td>
		   						<td>${v[14]}</td>
		   						<td class="table-list_title">负责人联系方式：</td>
		   						<td>${v[15]}</td>
	   						 </tr>	
	    					
                		</c:forEach>
                	</c:otherwise>
                </c:choose>
        
       
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
         <tr>
            <td width="70%" bgcolor="#FFFFFF">&nbsp;</td>
            <td width="30%" height="30" bgcolor="#FFFFFF" class="table-button">
			<input type="button" value="返回" name="B332"  onClick="window.location='<%=path%>/order/queryallorder.do';"> 
			</td>
          </tr></table>
		
        </td>
        </tr>
        </table>
        
</body>

</html>
