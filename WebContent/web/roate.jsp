<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta name="Generator" content="易·网站管理系统 V6.2.3">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="陕西中国旅行社有限责任公司官方网站,陕西旅游,西安旅游,陕西旅行社,西安旅行社,西安周边游,西安一日游,出境旅游,国内旅游,西安旅游景点,西安旅游线路,西安旅游网,中国旅行社,西安旅游介绍,去西安旅游">
<meta name="description" content="陕西中国旅行社有限责任公司是中国旅行社协会常务理事单位和中国中旅集团常务理事单位，陕西旅游集团成员单位，是国家旅游局首批特许经营中国公民出国旅游的国际旅行社。">
<title>线路预订</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/css.css" rel="stylesheet" type="text/css">
<script src="js/lxb.js" charset="utf-8"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script src="#" type="text/javascript"></script></head>

<body>

<%@ include file="head.jsp"%>

<%@ include file="ss.jsp"%>

<%@ include file="banner.jsp" %>




<div class="main">
  
  
  <%@ include file="main_left.jsp %>

  
  <div class="ny_lylb">
    <div class="ny_lylb_top">
        <ul>
          <li><span>当前位置：<a href="#" >首页</a> -&gt; <a href="#" >线路预订</a></span>线路预订</li>
        </ul>
        </div>
    <div class="ny_lylb_nr">

       <div class="ny_lylb_nr_lb">
                          <form id="frmguestbook" name="frmguestbook" method="post" action="/?mod=yuding" onsubmit="return checkForm();">
                <input name="action" value="add" type="hidden">
                <table cellpadding="5" cellspacing="0" border="0" width="100%">
                 
                     <tbody><tr> 
                        <td class="border_t_l_r_01" align="right" height="30">留言类型：</td>
                        <td colspan="3" class="border_t_r_01"> <select name="InfoType">
                            <option value="0">请选择留言类型</option>
                            <option value="1" selected="selected">线路预定</option>
                            <option value="2">酒店预定</option>
<!--                            <option value="3">业务咨询</option>
                            <option value="4">业务合作</option>
                            <option value="5">意见建议</option>-->
                        </select><font color="red">*</font></td>
                      </tr>
                      
                      <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">留言主题：</td>
                        <td colspan="3" class="border_t_r_01"> <input class="input_01" style="WIDTH: 495px" maxlength="60" name="title" value="大明宫、钟鼓楼广场、大雁塔广场一日游"><font color="red">*</font></td>
                      </tr>
                      
                      <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">留言内容：<br><font color="red">150汉字以内</font></td>
                        <td colspan="3" class="border_t_r_01"> <textarea name="Content" class="input_01" style="height:60px;WIDTH:495px"></textarea><font color="red">*</font>
                        <!--br><div style="width:520px"></div--></td>
                      </tr>
 <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">心　　情：</td>
                        <td colspan="3" class="border_t_r_01"> <span class="right_put" style="width:75%"><img src="images/1_002.gif"><input name="Face" value="/templates/default/images/guestbook/face/1.gif" checked="checked" type="radio"><img src="images/2.gif"><input name="Face" value="/templates/default/images/guestbook/face/2.gif" type="radio"><img src="images/3.gif"><input name="Face" value="/templates/default/images/guestbook/face/3.gif" type="radio"><img src="images/4_002.gif"><input name="Face" value="/images/guestbook/face/4.gif" type="radio"><img src="images/5.gif"><input name="Face" value="/images/guestbook/face/5.gif" type="radio"><img src="images/6.gif"><input name="Face" value="/images/guestbook/face/6.gif" type="radio"><img src="images/7.gif"><input name="Face" value="/images/guestbook/face/7.gif" type="radio"><img src="images/8.gif"><input name="Face" value="/images/guestbook/face/8.gif" type="radio"><img src="images/9.gif"><input name="Face" value="/images/guestbook/face/9.gif" type="radio"><img src="images/10.gif"><input name="Face" value="/images/guestbook/face/10.gif" type="radio">
                          <br>
                        <img src="images/11_002.gif"><input name="Face" value="/images/guestbook/face/11.gif" type="radio"><img src="images/12.gif"><input name="Face" value="/images/guestbook/face/12.gif" type="radio"><img src="images/13.gif"><input name="Face" value="/images/guestbook/face/13.gif" type="radio"><img src="images/14.gif"><input name="Face" value="/images/guestbook/face/14.gif" type="radio"><img src="images/15.gif"><input name="Face" value="/images/guestbook/face/15.gif" type="radio"><img src="images/16.gif"><input name="Face" value="/images/guestbook/face/16.gif" type="radio"><img src="images/17.gif"><input name="Face" value="/images/guestbook/face/17.gif" type="radio"><img src="images/18.gif"><input name="Face" value="/images/guestbook/face/18.gif" type="radio"><img src="images/19.gif"><input name="Face" value="/images/guestbook/face/19.gif" type="radio"><img src="images/20.gif"><input name="Face" value="/images/guestbook/face/20.gif" type="radio"></span></td>
                      </tr>
                      <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">图　　像：</td>
                        <td colspan="3" class="border_t_r_01"> <span class="right_put" style="width:90%"><img src="images/1.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/1.gif" checked="checked" type="radio"><img src="images/2_002.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/2.gif" type="radio"><img src="images/3_002.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/3.gif" type="radio"><img src="images/4.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/4.gif" type="radio"><img src="images/5_002.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/5.gif" type="radio"><img src="images/6_002.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/6.gif" type="radio">
                          <br>
                        <img src="images/7_002.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/7.gif" type="radio"><img src="images/8_002.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/8.gif" type="radio"><img src="images/9_002.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/9.gif" type="radio"><img src="images/10_002.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/10.gif" type="radio"><img src="images/11.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/11.gif" type="radio"><img src="images/12_002.gif" style="border: 5px dotted #ccc;" width="50" height="50"><input name="Head" value="/images/guestbook/head/12.gif" type="radio"></span></td>
                      </tr>                      
                       <tr> 
                        <td class="border_t_l_r_01" align="right" width="14%" height="30">姓　　名：</td>
                        <td class="border_t_r_01" width="31%"> <input class="input_01" style="WIDTH: 150px" maxlength="50" name="realname" id="realname"><font color="red">*</font></td>
                        <td class="border_t_r_01" align="right" width="15%">联系电话：</td>
                        <td class="border_t_r_01" width="40%"> <input class="input_01" style="WIDTH: 200px" maxlength="50" name="tel" id="tel"><font color="red">*</font></td>
                      </tr>
                      <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">电子邮箱：</td>
                        <td class="border_t_r_01"> <input class="input_01" style="WIDTH: 200px" maxlength="50" name="email" id="email"><font color="red">*</font></td>
                        <td class="border_t_r_01" align="right">个人主页：</td>
                        <td class="border_t_r_01"> <input class="input_01" style="WIDTH: 200px" maxlength="50" name="HomePage"></td>
                      </tr>
                      <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">ＱＱ号码：</td>
                        <td colspan="3" class="border_t_r_01"> <input class="input_01" style="WIDTH: 200px" maxlength="20" name="QQ"></td>
                      </tr>
                      <tr style="display:"> 
                        <td class="border_t_l_r_01" align="right" height="30">公司名称：</td>
                        <td colspan="3" class="border_t_r_01"> <input class="input_01" style="WIDTH: 200px" maxlength="50" name="CompanyName"></td>
                      </tr>
                      <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">联系地址：</td>
                        <td colspan="3" class="border_t_r_01"> <input class="input_01" style="WIDTH: 359px" maxlength="50" name="Address"></td>
                      </tr>
                       <tr> 
                        <td class="border_t_l_r_01" align="right" height="30">邮政编码：</td>
                        <td class="border_t_r_01"> <input class="input_01" style="WIDTH: 60px" maxlength="6" name="PostCode"></td>
                        <td class="border_t_r_01" align="right">验 证 码：</td>
                        <td class="border_t_r_01"><input name="yzcode" class="t_input" id="yzcode" style="width:60px;" maxlength="5" type="text"><img id="vcodeImg" src="images/getcode.png" onerror="this.onerror=null;this.src='/includes/getcode.php?s='+Math.random();" alt="验证码" title="看不清楚?换一张" style="cursor:pointer;" onclick="src='/includes/getcode.php?s='+Math.random()"></td>
                      </tr>              
                      <tr style="display:none;"> 
                        <td align="right" height="50">添加时间：</td>
                        <td colspan="3" height="50"> <input style="WIDTH: 180px" maxlength="50" name="times" value="{}" class="guestbookinput"></td>
                      </tr>
                      <tr> 
                        <td class="border_t_b_l_r_01" align="center" height="30">&nbsp; </td>
                        <td colspan="3" class="border_t_b_r_01" align="left"><input value=" 填好了，现在就提交留言！ " name="submit" style="width:200px; height:30px;" type="submit"></td>
                      </tr>
                  </tbody></table>
               </form>          
           
           <!--<div class="ny_lylb_nr_lb_wz">
               <ul>



                </ul>
                </div>-->
       <div style="clear:both;"></div>
       </div>
     

  
    </div>
    <div class="page">
 		
            </div>
    
  </div>
    
    <div style="clear:both;"></div>
</div>


<%@ include file="foot.jsp" %>

   </html>