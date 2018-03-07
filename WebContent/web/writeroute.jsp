<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>路线详情</title>
<base href="<%=basePath%>">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/css.css" rel="stylesheet" type="text/css">
<script src="js/lxb.js" charset="utf-8"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script src="#" type="text/javascript"></script>
<script type="text/javascript">
   function before(){
	   document.getElementById('frmguestbook').action="<%=path%>/index/querycity.do?t="+Math.random();
	  document.getElementById('frmguestbook').submit();
   }
   function after(){
	 
	   document.getElementById('frmguestbook').action="<%=path%>/index/gaincity.do?t="+Math.random();
		  document.getElementById('frmguestbook').submit();
	   
   }
</script>
</head>

<body>


<%@ include file="head.jsp"%>




 	
</div>

<div class="main">
  <%@ include file="main_left.jsp" %>>
  
  <div class="ny_lylb">
    <div class="ny_lylb_top">
        <ul>
          <li><span>当前位置：<a href="index.htm" target="_blank">第二步</a> -&gt; <a href="#" target="_blank"></a></span><h3>填写行程</h3></li>
        </ul>
        </div>
    <div class="ny_lylb_nr">

       <div class="ny_lylb_nr_lb">
  <form id="frmguestbook" name="frmguestbook" method="post"> 
                <input name="action" value="add" type="hidden">
                <input name="citys" value="<% String city = request.getParameter("citys");out.print(city);%>" type="hidden">
                <table cellpadding="5" cellspacing="0" border="0" width="100%">
                 
                     <tbody>
                      
					 <tr> 
                        <td class="border_t_l_r_01" align="right" width="14%" height="30">出发城市：</td>
                        
                        <td class="border_t_r_01" width="31%"> <input class="input_01" style="WIDTH: 200px" maxlength="50" name="realname" id="realname"><font color="red">*</font></td>
                      </tr>
					  <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">出发日期： </td>
                        <td colspan="3" class="border_t_r_01"> 
						<select name="year">
						
						<option value="2016">2016年</option>
						<option value="2017">2017年</option>
						<option value="2018">2018年</option>
						</select>
						<select name="month" >
						
						<option value="1">1月</option>
						<option value="2">2月</option>
						<option value="3">3月</option>
						<option value="4">4月</option>
						<option value="5">5月</option>
						<option value="6">6月</option>
						<option value="7">7月</option>
						<option value="8">8月</option>
						<option value="9">9月</option>
						<option value="10">10月</option>
						<option value="11">11月</option>
						<option value="12">12月</option>
						</select>
						<input type="text" name="day" size="5"/>日
						</td>
                      </tr>
                      
                      
					  <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">游玩天数：</td>
                        
                        <td colspan="3" class="border_t_r_01"> <input class="input_01" style="WIDTH: 200px" maxlength="20" name="tel">(天)</td>
                      </tr>
                      
					  <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">出行人数：</td>
                        <td colspan="3" class="border_t_r_01"> <input class="input_01" style="WIDTH: 200px" maxlength="20" name="peoplenumber">(人)</td>
                      </tr>
			         
                      <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">人均预算：</td>
                        <td colspan="3" class="border_t_r_01"> <input class="input_01" style="WIDTH: 200px" maxlength="20" name="money">(元)/人</td>
                      </tr>
                     
                      <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">其他要求：<br><font color="red">150汉字以内</font></td>
                        <td colspan="3" class="border_t_r_01"> <textarea name="Content" class="input_01" style="height:60px;WIDTH:495px"></textarea><font color="red">*</font>
                        <!--br><div style="width:520px"></div--></td>
                      </tr>
                    
                      <tr> 
                        <td colspan="3" class="border_t_b_r_01" align="center"><input value=" 上一步 " name="button1" style="width:200px; height:30px;" type="button" onclick="javaScript:before()"></td>
						<td colspan="3" class="border_t_b_r_01" align="center"><input value=" 下一步 " name="button2" style="width:200px; height:30px;" type="button"onclick="javaScript:after()"></td>
                      </tr>
                  </tbody></table>
               </form>     
           
           
       <div style="clear:both;"></div>
       </div>
     

  
    </div>
    
  </div>
    
    <div style="clear:both;"></div>
</div>
<%@ include file="foot.jsp" %>
</div>



	</body>
   </html>