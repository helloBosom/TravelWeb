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
  <title>修改订单</title>
  <base href="<%=basePath%>">
  <link href="css/main.css" rel="stylesheet" type="text/css">
  <script language="javascript" type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
  <link href="js/datepicker/default/datepicker.css" rel="stylesheet" type="text/css">
  <link href="js/datepicker/whyGreen/datepicker.css" rel="stylesheet" type="text/css" disabled="disabled">
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
		   if(confirm("确认删除吗？"))
		   window.location.reload();
	  }
	</script>
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="../../images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：修改订单</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
        
        <form name="query" action="<%=path%>/order/updatequerybypage.do" method="post">
        <table align="center" class="table-form">
          <tr>
            <td colspan="7" class="table-title"> 业务系统申请表查询</td>
          <tr>
            <td class="table-list_title">产品名称</td>
            <td> <input name="productname" type="text" class="input"> </td>
            <td class="table-list_title">线路类型</td>
            <td> <input name="routename" type="text" class="input"> </td>
            <td class="table-list_title">门市</td>
            <td> <input name="textfield23" type="text" class="input"> </td>
            <td rowspan="3"><span class="table-button"><input type="submit" value="查询" name="B33" class="input" ></span></td>
          </tr>
          <tr>
            <td class="table-list_title">订单状态</td>
            <td>
              <select name="orderstatus" class="common-select"> 
                <option value="0">未审核</option>                
                <option value="1">通过审核</option>
                <option value="2">未通过审核</option>
                 
              </select>
            </td>
            <td class="table-list_title">出团日期起</td>
            <td> <input name="text" type="text" class="Wdate" onFocus="new WdatePicker(this,'%Y-%M-%D',true)"> </td>
            <td class="table-list_title">出团日期止</td>
            <td> <input name="text1" type="text" class="Wdate" onFocus="new WdatePicker(this,'%Y-%M-%D',true)"> </td>
          </tr>          
        </table></form>
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="60%" bgcolor="#FFFFFF">　</td>
            <td width="40%" height="30" bgcolor="#FFFFFF" class="table-button">
			
			</td>
          </tr>
        </table>
        <table align="center" class="table-table">
          <tr>
            <td colspan="13" class="table-title"> 基本信息</td>
          <!-- <tr>
            <td class="table-title1">订单编号</td>
            <td><input name="text" type="text" class="Wdate" onFocus="new WdatePicker(this,'%Y-%M-%D',true)"></td>
          </tr> -->
          <tr>
            <td class="table-title1">　</td>
            <td class="table-title1">订单编号</td>
            <td class="table-title1">订单人</td>
            <td class="table-title1">联系电话</td>
            <td class="table-title1">产品名称</td>
            <td class="table-title1">线路类型</td>
            <td class="table-title1">人数</td>
            <td class="table-title1">应付总额（元）</td>
            <td class="table-title1">负责人</td>
            <td class="table-title1">详细</td>
            <td class="table-title1">状态</td>
            <td class="table-title1">操作</td>            
         </tr>
          
          <c:choose>
            <c:when test="${empty orders}">
               <tr>
                			<td colspan="11">no data</td>
                		</tr>
                	</c:when>
                	<c:otherwise>
                		<c:forEach var="v"  items="${orders}">
                			<tr>
                			<td align="center"> <input type="checkbox" name="checkbox" value="checkbox"> </td>
                			   <td height="28">${v[0]}</td>
                			   <td height="28">${v[1] }</td>
                               <td height="28">${v[2] }</td>
                               <td height="28">${v[3] }</td>
                               <td height="28">${v[4] }</td>
                               <td height="28">${v[5] }</td>                        
                               <td height="28">${v[6] }</td>
                               <td height="28">${v[7] }</td>
                               <td height="28"><a href = "<%=path%>/order/${v[0]}/queryorderbyid2.do">查看详情</td>                        
                               <c:if test="${v[8]=='1'}">
                               <td height="28">已通过审核</td>
                               </c:if>
                               <c:if test="${v[8]=='0'}">
                               <td height="28">未审核</td>
                               </c:if>
                               <c:if test="${v[8]=='2'}">
                               <td height="28">未通过审核</td>
                               </c:if>
                               <td height="28"><a href = "<%=path%>/order/${v[0]}/queryorderbyid1.do">修改&nbsp;&nbsp;</a><a href="<%=path%>/order/${v[0]}/deleteorder.do">删除</a></td>
                               
                			</tr>
                		</c:forEach>
                	</c:otherwise>
                </c:choose>
          
        </table>
       
      </td>
    </tr>
    
  </table>
  

</body>
</html>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>
