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
<title>首页</title>
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
</style>
<body>
<%@ include file="head.jsp"%>

<%@ include file="ss.jsp"%>
<div class="banner">
  <div id="ibanner">
    <div id="ibanner_pic">
	  
       <table id="pictable">
		 <tr>
		 <c:choose>
		 <c:when test="${empty viewspaces}">
		 <tr>no data</tr>
		 </c:when>
		 <c:otherwise>
		 <c:forEach var="v" items="${viewspaces}">
		 <td><a href="<%=path %>/index/queryviewspacedetail.do?viewspaceid=${v.spaceId}"><img src="<%=path %>/uploads/${v.picture}" width="310px"></a><br>
		        
				<span><center><a href="<%=path %>/index/queryviewspacedetail.do?viewspaceid=${v.spaceId}"><font style="color:red;font-size:150%" >${v.spaceName}</font></a></center><br>
				${v.description }</span></td>
		</c:forEach>
		</c:otherwise>
		</c:choose>
		</tr>
				
		  <tr>
		  <c:choose>
		 <c:when test="${empty viewspacess}">
		 <tr>no data</tr>
		 </c:when>
		 <c:otherwise>
		 <c:forEach var="v" items="${viewspacess}">
		 <td><a href="<%=path %>/index/queryviewspacedetail.do?viewspaceid=${v.spaceId}"><img src="<%=path %>/uploads/${v.picture}" width="310px"></a><br>
		        
				<span><center><a href="<%=path %>/index/queryviewspacedetail.do?viewspaceid=${v.spaceId}"><font style="color:red;font-size:150%" >${v.spaceName}</font></a></center><br>
				${v.description }</span></td>
		</c:forEach>
		</c:otherwise>
		</c:choose>	
		</tr>
		  <tr>
		  <td colspan="3"><center><font style="color:red;font-size:200%" >
		  <a href="<%=path %>/index/queryviewspace.do">MORE...</a></font></center></td>
		  </tr>
        </table>
</div>
</div>
</div>

<div class="main">
  
  
  <%@ include file="main_left.jsp" %>
  
  <div class="ny_lylb">
    <div class="ny_lylb_top">
        <ul>
          <li><span>当前位置：<a href="#" >第${currentpage}页</a> -&gt; <a href="#" >旅游线路</a></span>旅游线路</li>
        </ul>
        </div>
    <div class="ny_lylb_nr">
    	<c:choose>
    	<c:when test="${empty viewroutess}">
    	<div>no data</div>
    	</c:when>
    	<c:otherwise>
    	<c:forEach var="v" items="${viewroutess}">
    	<div class="ny_lylb_nr_lb">
           <div class="ny_lylb_nr_lb_img"><img src="images/2016022911253956d3ba333567f.jpg"></div>
           <div class="ny_lylb_nr_lb_wz">
               <ul>
                  <li class="ny_lylb_nr_lb_wz_bt"><a href="<%=path%>/index/queryproductlist.do?routeid=${v.routeid}" >${v.routename}</a></li>
                  <li>${v.routedescribe}</li>
                  <li class="ny_lylb_nr_lb_wz_yd"><a href="<%=path%>/index/queryproductlist.do?routeid=${v.routeid}" >去看看</a></li>
                </ul>
                </div>
       <div style="clear:both;"></div>
       </div>
    	</c:forEach>
    	</c:otherwise>
    	</c:choose>
   
		         
       <div style="clear:both;"></div>
       
       </div>
     
		         
     
		         
     
		       
     
		     
  
    
    <div class="page">
 			<a class="info">共${totalPage}页</a> <a href="<%=path%>/index/queryviewspace.do?currentpage=1" class="current">首页</a> 
 			<a href="<%=path%>/index/querybasedata.do?currentPage=${(currentpage-1)<1?1:(currentpage-1)}">上一页</a> 
 			<a href="<%=path%>/index/querybasedata.do?currentPage=${(currentpage+1)>totalPage?totalPage:(currentpage+1)}">下一页</a>
 			<a href="<%=path%>/index/querybasedata.do?currentPage=${totalPage}">尾页</a>            </div>
    
  </div>
    
    <div style="clear:both;"></div>
</div>

<%@ include file="foot.jsp" %>


    </body>
</html>