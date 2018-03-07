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
<title>更多景区</title>
<base href="<%=basePath%>">

<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/css.css" rel="stylesheet" type="text/css">
<script src="js/lxb.js" charset="utf-8"></script><script type="text/javascript" src="js/banner.js"></script>
<script src="/JS_Float.aspx" type="text/javascript"></script></head>
<style type="text/css">
#pictable{
width:960px;
}
#pictable span{
display:block;
height:67px;
}
.ny_lylb_nr_lb_wz{
	width:701px;
}
</style>
<body>

<%@ include file="head.jsp"%>

<%@ include file="ss.jsp"%>
<%@ include file="banner.jsp"%>

<div class="main">
  
  <%@ include file="main_left.jsp" %>
  <div class="ny_lylb">
    <div class="ny_lylb_top">
        <ul>
          <li><span>当前位置：<a href="#" >第${currentpage}页</a> -&gt; <a href="#" >更多产品</a></span>更多产品列表</li>
        </ul>
        </div>
    <div class="ny_lylb_nr">
    <c:choose>
    <c:when test="${empty products}">
    <div>no data</div>
    </c:when>
    <c:otherwise>
    <c:forEach var="v" items="${products}">
    
    		<div class="ny_lylb_nr_lb">
          
           <div class="ny_lylb_nr_lb_wz">
               <ul>
                  <li class="ny_lylb_nr_lb_wz_bt"><span>价格:${v.price}元/人</span><a href="<%=path %>/index/queryproductdetail.do?productid=${v.productid}" >产品名：${v.productName}</a></li>
                   <li>${v.remarks}</li>
                  <li class="ny_lylb_nr_lb_wz_yd"><a href="<%=path %>/index/queryproductdetail.do?productid=${v.productid}" >去看看</a></li>
                </ul>
                </div>
       <div style="clear:both;"></div>
       </div>
    
       </c:forEach>
    </c:otherwise>
    </c:choose>
    
  
    </div>
    <div class="page">
 			<a class="info">共${totalpages}页</a> 
 			<a href="<%=path %>/index/queryproductlist.do?routeid=${routeid}&currentPage=1" class="current">首页</a> 
 			<a href="<%=path %>/index/queryproductlist.do?routeid=${routeid}&currentPage=${((currentpage-1) < 1)?1:(currentpage-1)}">上一页</a>  
 			<a href="<%=path %>/index/queryproductlist.do?routeid=${routeid}&currentPage=${((currentpage+1) > totalpages) ? totalpages:(currentpage+1)}">下一页</a>
 			<a href="<%=path %>/index/queryproductlist.do?routeid=${routeid}&currentPage=${totalpages}">尾页</a>
 	</div>
    
  </div>
    
    <div style="clear:both;"></div>
</div>


<%@ include file="foot.jsp" %>

    </body>
</html>