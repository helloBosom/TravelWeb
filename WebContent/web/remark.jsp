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
<title>西安旅游-陕西中国旅行社有限公司</title>
<base href="<%=basePath%>">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/css.css" rel="stylesheet" type="text/css">
<script src="js/lxb.js" charset="utf-8"></script>
<script type="text/javascript" src="js/banner.js"></script>
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
          <li><span>当前位置：<a href="#" >首页</a> -&gt; <a href="#" >景区</a></span>景区</li>
        </ul>
        </div>
    <div class="ny_lylb_nr">
       <div class="ny_lynr_nr_lb">
           <div class="ny_lynr_nr_lb_img"><img src="<%=path %>/uploads/${viewspace.picture}"></div>
           <div class="ny_lynr_nr_lb_wz">
<table style="border-collapse:collapse;" cellpadding="0" cellspacing="0" border="1" bordercolor="#38a7fd" width="480" height="150">
  <tbody><tr>
    <td align="center" width="50">ID号：</td>
    <td width="240">${viewspace.spaceId}</td>
    <td width="60"><a href="<%=path%>/index/querybasedata.do" style="color:#000">返回线路首页</a></td>
  </tr>
  <tr>
    <td align="center">名称：</td>
    <td>${viewspace.spaceName}</td>
    <td><a onclick="window.close();" href="#" style="color:#000">关闭此页</a></td>
  </tr>
  <tr>
    <td align="center">地址：</td>
    <td>${viewspace.address}</td>
    <td><a href="javascript:window.print()" style="color:#000">打印该线路</a></td>
  </tr>
  <tr>
    <td align="center">报价：</td>
    <td>${viewspace.price}元/人&nbsp;&nbsp; </td>
    <td><a  href="<%=path%>/comment/addcomm.do?spaceId=${viewspace.spaceId}">用户评价</a></td>
  </tr>
  
</tbody></table>
           </div>
       <div style="clear:both;"></div>
       </div>
       
       
       
       <div class="ny_lynr_xcts">
       	 <div class="ny_lynr_xcts_top">
       		<ul>
          		<li><a href="<%=path%>/comment/show.do?spaceId=${spaceId}">查看客户评价</a></li>
        </ul>
       </div>
       <div class="ny_lynr_xcts_nr">
       		
       <c:forEach var="v" items="${contents }"  varStatus="status">
       		<p><span style="font-family:SimSun;font-size:12px;">
       		${ status.count}.${v}
       		</span></p>
       		</c:forEach>
       		<p><span style="font-family:SimSun;font-size:12px;"></span></p>
       		
       </div>
       
       <div class="ny_lynr_xcap">
       	 <div class="ny_lynr_xcts_top">
       		<ul>
          		<li>评价</li>
        </ul>
       </div>
       <div class="ny_lynr_xcap_nr">
       <form action="<%=path%>/comment/add.do?spaceId=${spaceId}"  method="post">
         <table align="center" border="1" bordercolor="#d1d1d1" width="680">
           <tbody><tr>
             <td align="center" width="70">用户名：</td>
             <td align="center" width="260"><input size="40" type="text" name="username"/></td>
			 <td align="center" width="70">phone：</td>
             <td align="center" width="260"><input size="40" type="text" name="tel"/></td>
           </tr>
           <tr><td colspan="4"><textarea cols="81" rows="10" name="content" ></textarea>
</td></tr> 
<tr><td colspan="4"><center><input type="submit" name="submit" value="提交" />
<input type="reset" name="reset" value="取消" /></center>
</td></tr> 
          
       </tbody></table>
	   </form>
       
           
            
            <div style="clear:both"></div>
       </div>
       
       </div>
       <div class="ny_lynr_xcts">
       	 <div class="ny_lynr_xcts_top">
       		<ul>
          		<li>价格包含</li>
        </ul>
       </div>
       <div class="ny_lynr_xcts_nr">
       		<p><span style="font-family:SimSun;font-size:12px;">1、门票：大明宫门票</span></p><p><span style="font-family:SimSun;font-size:12px;">2、车型：当地空调旅游巴士车</span></p><p><span style="font-family:SimSun;font-size:12px;">3、导游：优秀导游全程讲解服务</span></p><p><span style="font-family:SimSun;font-size:12px;">4、保险：全程含旅行社责任险</span></p><br>       </div>
       
       </div>
       <div class="ny_lynr_xcts">
       	 <div class="ny_lynr_xcts_top">
       		<ul>
          		<li>价格不含</li>
        </ul>
       </div>
       <div class="ny_lynr_xcts_nr">
       		<p>1、全程不含餐</p><p>2、推荐自费景点：明城墙54元/人</p>       </div>
       
       </div>
       <div class="ny_lynr_xcts">
       	 <div class="ny_lynr_xcts_top">
       		<ul>
          		<li>温馨提示</li>
        </ul>
       </div>
       <div class="ny_lynr_xcts_nr">
       	<p><span style="font-family: SimSun;">1、报名方法：请至少提前一天报名，可以到我们公司报名，也可以拨打电话报名；我公司导游和司机将在约定的时间和地接接您。</span></p><p><span style="font-family: SimSun;">2、优惠证件：持老年证或学生证等优惠证件的游客，请提前出示或说明，我们将退还您所参观景点对您的优惠价与旅行社协议价的差额部分。如没有提前说明，不予退还优惠差价</span></p><p><span style="font-family: SimSun;">3、儿童报价：只含车费和导游服务费，不含门票，产生现付（1.4米以下为儿童，1.4米以上没有学生证等同于大人），备注：16周岁以下跟随父母参观兵马俑凭证件是免费的。　　　　　　　　　</span></p><p><span style="font-family: SimSun;">4、
乘火车或飞机到西安的客人需提前告知我们您的车次或航班信息,我们会提前安排好接站事宜.如果火车7：30之前抵达西安，可参加当天旅游行程。火车站或者
是西安机场大巴停靠站，接送都是免费，接站：火车站免费，机场4人以下120元/辆，23点以后落地航150元/辆，4人以上35元/人（需要少许等待）</span></p><p><span style="font-family: SimSun;">5、 每条线路早上接人时间约为7：30-8：00，具体根据你所住的位置远近而定。因为是散客拼团，所以接您的车辆并不一定是当日带您去旅游的车辆。接到您后我们会回到发车地点，待当天旅游的客人接完后，8：30左右发车；　　</span></p><p><span style="font-family: SimSun;">6、 旅游费用不含餐费，导游中午会安排和预留用餐的时间，费用自理。全国旅游景区的餐厅价格较高且环境味道一般，建议客人在点餐前了解清楚，以免造成不愉快。也可自带食物</span></p> 
       </div>
       
       </div>
    </div>
    
  </div>
    
    <div style="clear:both;"></div>
</div>


<%@ include file="foot.jsp" %>

    </body>
</html>