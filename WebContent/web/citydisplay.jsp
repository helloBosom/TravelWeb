<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path=request.getContextPath(); 
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/web/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="Generator" content="易·网站管理系统 V6.2.3">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="陕西中国旅行社有限责任公司官方网站,陕西旅游,西安旅游,陕西旅行社,西安旅行社,西安周边游,西安一日游,出境旅游,国内旅游,西安旅游景点,西安旅游线路,西安旅游网,中国旅行社,西安旅游介绍,去西安旅游">
<meta name="description" content="陕西中国旅行社有限责任公司是中国旅行社协会常务理事单位和中国中旅集团常务理事单位，陕西旅游集团成员单位，是国家旅游局首批特许经营中国公民出国旅游的国际旅行社。">
<title>首页</title>
<base href="<%=basePath%>">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/css.css" rel="stylesheet" type="text/css">
<script src="js/lxb.js" charset="utf-8"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script src="/JS_Float.aspx" type="text/javascript"></script>
<script type="text/javascript">
//判断数组中是否已添加该元素
	var elements = new Array();
    //添加选择的元素
	function appendElement(para){
    	
    	//遍历数组,判断该元素是否已存在
    	for(var i=0;i<elements.length;i++){
    		if(elements[i] == para){
    			return;
    		}
    	}
    	elements.push(para);    	
		var obj = document.createElement('button');
		
		obj.innerHTML = para;
		var bodyObj = document.getElementById('insertbefore');
		
		bodyObj.appendChild(obj);
	}
    
    //删除所有添加的按钮
    function clearButton(){
    	var bodyObj = document.getElementById('insertbefore');
    	bodyObj.innerHTML="";
    }
    function message(){
    	var city='';
    	for(var i=0;i<elements.length;i++){
    		city=city+elements[i]+',';
    	}
    	alert(city);
    	document.getElementById('wroute').action="<%=path%>/web/writeroute.jsp?citys="+city+"&"+"t="+Math.random();
    	document.getElementById('wroute').submit();
    }
</script>
<style type="text/css">
#pictable{
width:960px;
}
#pictable span{
display:block;
height:67px;
}
</style>
</head>
<body>
<%@ include file="head.jsp"%>

<%@ include file="ss.jsp"%>

<div class="main">
  
  
  <%@ include file="main_left.jsp" %>
  
  <div class="ny_lylb">
    <div class="ny_lylb_top">
        <ul>
          <li><span>当前位置：<a href="#" >第一步</a> -&gt; <a href="#" >目的地</a></span><h3>目的地</h3></li>
        </ul>
        </div>
        <br>
        <br>
    <div class="ny_lylb_nr">
    	
<form id="wroute" method="post">
<div>
<c:choose>
 <c:when test="${empty citys}">
 no data
 </c:when>
 <c:otherwise>
  <c:forEach var="v" items="${citys}">
    <a href="javaScript:appendElement('${v.cityname}')">${v.cityname}</a> &nbsp;&nbsp;
  </c:forEach>
 </c:otherwise>
</c:choose>
</div>
<br><br><br>
  <hr color='red'>
  <br><br><br>
 <div id="insertbefore">
  
 </div>
 <br><br><br><br>
  <div align="center">
  <input type="button" name="button" value="删除所选项" onclick="javaScript:clearButton();">&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" name="button" value="下一步" onclick="javaScript:message()">
  </div>
</form>        
       <div style="clear:both;"></div>
       
       </div>

    
  </div>
    
    <div style="clear:both;"></div>
</div>

<%@ include file="foot.jsp" %>


    </body>
</html>