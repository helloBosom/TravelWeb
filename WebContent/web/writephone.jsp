<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path=request.getContextPath(); 
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
</head>

<body>


<%@ include file="head.jsp"%>


<div class="main">
  <%@ include file="main_left.jsp" %>>
  <div class="ny_lylb">
    <div class="ny_lylb_top">
        <ul>
          <li><span>当前位置：<a href="index.htm" target="_blank">第三步</a> -&gt; <a href="#" target="_blank">填写联系方式</a></span><h3>填写联系方式</h3></li>
        </ul>
        </div>
    <div class="ny_lylb_nr">

       <div class="ny_lylb_nr_lb">
 <form id="frmguestbook" name="frmguestbook" method="post" action="<%=path%>/index/addtraveltailer.do" onsubmit="return checkForm();">
                <input name="action" value="add" type="hidden">
                <table cellpadding="5" cellspacing="0" border="0" width="100%">
                 
                     <tbody>
					 <tr> 
                        <td class="border_t_l_r_01" align="right" width="14%" height="30">姓名：</td>
                        <td colspan="3" class="border_t_r_01" > <input class="input_01" style="WIDTH: 200px" maxlength="50" name="realname" id="realname" value="${sessionScope.customername}"> <font color="red">*</font></td>
                      </tr>
					  
					  <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">手机号：</td>
                        <td colspan="3" class="border_t_r_01"> <input class="input_01" style="WIDTH: 200px" maxlength="20" name="telephone">&nbsp;<input type="button" value="发送验证码"></td>
                      </tr>
					  <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">验证码：</td>
                        <td colspan="3" class="border_t_r_01"> <input class="input_01" style="WIDTH: 200px" maxlength="20" name="money">&nbsp;收不到验证码，联系客服</td>
                      </tr>
			
                   
                      
                      <tr> 
                        <td colspan="3" class="border_t_b_r_01" align="center"><input value=" 上一步 " name="submit" style="width:200px; height:30px;" type="submit"></td>
						<td colspan="3" class="border_t_b_r_01" align="center"><input value=" 提交需求 " name="submit" style="width:200px; height:30px;" type="submit"></td>
                      </tr>
                  </tbody>
                  
                  </table>
               </form>          
           
           
       <div style="clear:both;"></div>
       </div>
     

  
    </div>
    <div class="page">
 		
            </div>
    
  </div>
    
    <div style="clear:both;"></div>
</div>



<div style="height:15px;"></div>

<div class="f">
 
   </html>