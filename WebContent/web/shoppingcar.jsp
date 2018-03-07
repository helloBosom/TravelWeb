<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path=request.getContextPath(); 
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/web/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta name="Generator" content="易·网站管理系统 V6.2.3">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="陕西中国旅行社有限责任公司官方网站,陕西旅游,西安旅游,陕西旅行社,西安旅行社,西安周边游,西安一日游,出境旅游,国内旅游,西安旅游景点,西安旅游线路,西安旅游网,中国旅行社,西安旅游介绍,去西安旅游">
<meta name="description" content="陕西中国旅行社有限责任公司是中国旅行社协会常务理事单位和中国中旅集团常务理事单位，陕西旅游集团成员单位，是国家旅游局首批特许经营中国公民出国旅游的国际旅行社。">
<title>shopping</title>
<base href="<%=basePath%>">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/css.css" rel="stylesheet" type="text/css">
<script src="js/lxb.js" charset="utf-8"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script src="/CheckInvitejs.aspx" type="text/javascript"></script>
<script type="text/javascript">
function gotoback(){
	document.getElementById('shopform').action="<%=path %>/index/gotoback.do";
	document.getElementById('shopform').submit();
}
function gotobuy(){
	document.getElementById('shopform').action="<%=path %>/index/orderdetail.do";
	document.getElementById('shopform').submit();
}
//根据编号删除记录
function deleteOrder(ordernum){
	if(window.confirm("确认删除编号为:" +ordernum+"的记录吗?" )){
		//跳转到前端控制器实现删除操作
		document.getElementById('shopform').action="<%=path %>/index/delorderbyordernum.do?ordernum="+ordernum;
		document.getElementById('shopform').submit();
	}
}

	function selectCheckAll(selectComponent){
		var flag = selectComponent.checked;
		var selectedId =document.getElementsByName("checkboxa");
		for(var i=0;i<selectedId.length;i++){
			selectedId[i].checked =flag; 
		}
	}
	//批量删除操作
	function batchDeleteByQuestionId(){
		//拼写url
		var url="<%=path %>/index/batchdelorder.do?t="+Math.random();
		//遍历复选框获取批量删除的问题类别编号
		var selectedId =document.getElementsByName("checkboxa");
		for(var i=0;i<selectedId.length;i++){
			if(selectedId[i].checked == true){
				//获取复选框中所绑定的问题类别编号的值
				url= url + "&ordernums="+selectedId[i].value;
			} 
		}
		document.getElementById('shopform').action=url;
		document.getElementById('shopform').submit();
	} 
function add(numid,priceid,sumid){
	var goodnum=document.getElementById(numid);
	var goodprice=document.getElementById(priceid);
	var goodsum=document.getElementById(sumid);
	var price = parseFloat(goodprice.innerText);
	var num = parseInt(goodnum.value);
	if(num<50){
		num=num+1;
		goodnum.value = num;
	}
	var sum1 = price * num;
	var sum = sum1.toFixed(2);
	goodsum.innerHTML=sum;
}
	
function minus(numid,priceid,sumid){
	var goodnum=document.getElementById(numid);
	var goodprice=document.getElementById(priceid);
	var goodsum=document.getElementById(sumid);
	var price = parseFloat(goodprice.innerText);
	var num = parseInt(goodnum.value);
	
	if(num>1){
		num=num-1;
	}else{
		num=1;
	}
	goodnum.value = num;
	var sum1 = price * num;
	var sum = sum1.toFixed(2);
	goodsum.innerHTML=sum;
}

function getNum(){
	var goodnum=document.getElementById("num");
	var num = parseInt(goodnum.value);
	return num;
}

</script>
</head>


<body>

<%@ include file="head.jsp"%>

<%@ include file="ss.jsp"%>

<div class="banner">
<div id="ibanner">
<div id="ibanner_pic">
					
         
</div>
</div>
</div>

<div class="main">
  
  <%@ include file="main_left.jsp" %>
  
  <div class="ny_lylb">
    <div class="ny_lylb_top">
        <ul>
          <li><span>当前位置：<a href="#" target="_blank">首页</a> -&gt; <a href="#" target="_blank">订购</a></span>订购</li>
        </ul>
        </div>
        
 <form name="shopfrom"  id="shopform" method="post">       
    <div class="ny_lylb_nr">
       <div class="ny_lynr_nr_lb">
     
<table style="border-collapse:collapse;" cellpadding="0" cellspacing="0" border="1" bordercolor="#38a7fd" width="700" height="150">
  <tbody><tr>
	<td align="center" width="20"><input type="checkbox" name="checkbox" onclick="selectCheckAll(this)" ></td>
    <td align="center" width="30">编号</td>
	<td align="center" width="40">产品编号</td>
	<td align="center" width="110">产品名称</td>
	<td align="center" width="40">单价</td>
	<td align="center" width="70">人数</td>
	<td align="center" width="40">合计</td>
	<td align="center" width="50">操作/<a href="javascript:batchDeleteByQuestionId();">删除</a></td>
  </tr>
  <c:choose>
  <c:when test="${empty sessionScope.orders }">
  <tr>no data</tr>
  </c:when>
  <c:otherwise>
  <c:forEach var="v" items="${sessionScope.orders}">
   <tr>
    <td align="center"><input type="checkbox" name="checkboxa" value="${v.num }"></td>
	<td>${v.num }</td>
    <td>${v.productId }</td>
    
	<td>${v.productName }</td>
	<td id="${v.num }_price">${v.price } </td>
	<td><input type="button" name="minusbutton"  value="-" onclick="minus('${v.num }','${v.num }_price','${v.num }_sum')"/><input type="text" name="peoplenum" value="${v.pNum}" id="${v.num }" size="2" maxlength="10" /><input type="button" name="addbutton"  value="+" onclick="add('${v.num }','${v.num }_price','${v.num }_sum')"/></td>
	<td id="${v.num }_sum">${v.price*v.pNum }</td>
	<td><a href="javascript:deleteOrder(${v.num });">删除</a></td>
  </tr>
  </c:forEach>
  </c:otherwise>
  </c:choose>
  
</tbody></table>
        <input type="button" name="button1" value="继续浏览" onclick="gotoback();"/>
		<input type="button" name="button2" value="提交订单" onclick="gotobuy();" />
       <div style="clear:both;"></div>
       </div>
      
           
    </div>
  </form>   
  </div>
    
    <div style="clear:both;"></div>
</div>



<%@ include file="foot.jsp" %>

    </body>
</html>