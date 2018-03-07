<%@page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/web/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta name="Generator" content="易·网站管理系统 V6.2.3" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="keywords"
	content="陕西中国旅行社有限责任公司官方网站,陕西旅游,西安旅游,陕西旅行社,西安旅行社,西安周边游,西安一日游,出境旅游,国内旅游,西安旅游景点,西安旅游线路,西安旅游网,中国旅行社,西安旅游介绍,去西安旅游" />
<meta name="description"
	content="陕西中国旅行社有限责任公司是中国旅行社协会常务理事单位和中国中旅集团常务理事单位，陕西旅游集团成员单位，是国家旅游局首批特许经营中国公民出国旅游的国际旅行社。" />
<title>用户注册</title>
<base href="<%=basePath%>">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script src="js/lxb.js" charset="utf-8"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script src="#" type="text/javascript"></script>
<script type="text/javascript">
 <!--用户名验证-->
 function isValidName(obj,id){
     var reg = /^[\u4e00-\u9fa5]{2,4}$/;
     var strId = obj.value;
    //window.alert(strId);
     if(strId==""){
        document.getElementById(id).innerHTML="姓名不能为空！";
        return false;
     }else if(reg.test(obj.value)){
     document.getElementById(id).innerHTML="✔";
     return true;
     }else{
         document.getElementById(id).innerHTML="请输入正确的姓名(2～4个汉字)";
         return false;
     }
 }

 <!--密码验证-->
 function isValidPwd(obj,id){
     var reg = /^[A-Za-z0-9]{6,18}$/;
     var strId = obj.value;
    //window.alert(strId);
     if(strId==""){
        document.getElementById(id).innerHTML="密码不能为空！";
        return false;
     }else if(reg.test(obj.value)){
     document.getElementById(id).innerHTML="✔";
     return true;
     }else{
         document.getElementById(id).innerHTML="密码必须由6～18为字母.数字组成!";
         return false;
     }
 }

 <!--Email验证-->
 function isValidEmail(obj,id){
     var reg = /^[A-Za-z0-9]*@([A-Za-z0-9]+\.)+[A-Za-z]{1,4}$/;
     var strId = obj.value;
     if(strId==""){
            document.getElementById(id).innerHTML="Email不能为空！";
            return false;
         }else if(reg.test(obj.value)){
         document.getElementById(id).innerHTML="✔";
         return true;
         }else{
             document.getElementById(id).innerHTML="请输入合法的Email!";
             return false;
         }
 }
 
 <!--联系电话验证-->
 function isValidTelNum(obj,id){
     var reg = /^[0-9]{6,14}$/;
     var strId = obj.value;
     if(strId==""){
            document.getElementById(id).innerHTML="";
            return false;
         }else if(reg.test(obj.value)){
         document.getElementById(id).innerHTML="✔";
         return true;
         }else{
             document.getElementById(id).innerHTML="请输入正确的联系电话!";
             return false;
         }
 }

 <!--非必选汉字验证-->
 function isValidChinese(obj,id){
     var reg = /^[\u4e00-\u9fa5]{2,150}$/;
     var strId = obj.value;
    //window.alert(strId);
    if(strId==""){
    	return true;
    } else if(!reg.test(obj.value)){
     document.getElementById(id).innerHTML="备注可以为空或2~150位汉字信息!";
     return false;
     }
 }
 </script>
</head>

<body>
	<div class="head">
		<div class="header">
			<div class="header_top">
				<ul>
					<li id="header_li1"><a href="#"  title="用户注册"
						rel="sidebar">收藏本站</a></li>
					<li id="header_li2"><a href="#">联系我们</a></li>
					<li id="header_li3"><a href="#">帮助中心</a></li>
				</ul>
			</div>
			<div>
				<a href="#"><img src="images/logo.jpg" /></a>
			</div>
		</div>
		<div id="dh">
			<div class="nav">
				<ul>
					<li><a href="#">网站首页</a></li>
					<li><a href="#">西安旅游</a></li>
					<li><a href="#">出境旅游</a></li>
					<li><a href="#">国内旅游</a></li>
					<li><a href="#">周边旅游</a></li>
					<li><a href="#">青岛世园会</a></li>
					<li><a href="#">关于我们</a></li>
					<li><a href="#">联系我们</a></li>
				</ul>
			</div>
		</div>
	</div>
	<%@ include file="ss.jsp"%>
	<div class="main">
		<div class="main_left">
			<div class="ny_left_lvxl">
				<div class="ny_left_lvxl_top">西安旅游线路</div>
				<div class="ny_left_lvxl_fl">
					<ul>
						<li><a href="#" target="_blank">西安一日游</a></li>
						<li><a href="#" target="_blank">西安二日游</a></li>
						<li><a href="#" target="_blank">西安三日游</a></li>
						<li><a href="#" target="_blank">西安四日旅</a></li>
						<li><a href="#" target="_blank">西安五日游</a></li>
						<li><a href="#" target="_blank">西安全线游</a></li>
					</ul>
				</div>
			</div>
			<div class="ny_left_lxwm">
				<div class="ny_left_lvxl_top">联系我们</div>
				<div class="ny_left_lxwm_nr">

					<p align="left">
						<strong>免费电话：</strong>400-029-1023<br /> <strong>直拨电话：</strong>
					</p>
					<p align="left">029-89581951</p>
					<p align="left">029-89581952</p>
					<p align="left">02987559406</p>
					<p align="left">
						<strong>传 真：<br />029-82402743<br />手 机: <br /></strong>15002982802<br />18192638562<br />13309100131
					</p>
					<p align="left">
						<br /> <strong>地 址：西安市东关正街70#招商局广场9E<br />邮编：710048<br />
							<br /> <br /></strong>
					</p>
				</div>
				<div class="ny_jpxl_top"></div>
				<div class="ny_jpxl_bt">
					<ul>
						<li>精品线路</li>
					</ul>
				</div>
				<div class="ny_jpxl_nr_list">
					<ul>
						<li><a href="#" target="_blank">大明宫、钟鼓楼广场、大雁塔广...</a></li>
						<li><a href="#" target="_blank">乾陵、永泰公主墓/懿德太子墓...</a></li>
						<li><a href="#" target="_blank">半坡、华清池骊山、兵马俑（含秦...</a></li>
						<li><a href="#" target="_blank">兵马俑(含秦始皇陵)、华清池、...</a></li>
						<li><a href="#" target="_blank">华山一日游（含北峰往返索道及进...</a></li>
						<li><a href="#" target="_blank">乾陵、法门寺、茂陵纯玩经典一...</a></li>
						<li><a href="#" target="_blank">明城墙、大雁塔广场、钟鼓楼广...</a></li>
						<li><a href="#" target="_blank">革命圣地延安、黄帝陵、壶口两...</a></li>
						<li><a href="#" target="_blank">兵马俑、华清宫、西安市区两日...</a></li>
						<li><a href="#" target="_blank">兵马俑、华清宫、华山两日游</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="ny_lylb">
			<div class="ny_lylb_top">
				<ul>
					<li><span>当前位置：<a href="index.jsp" target="_blank">首页</a>
							-&gt; <a href="#" target="_blank">用户注册</a></span>用户注册</li>
				</ul>
			</div>
			<div class="ny_lylb_nr">
				<div class="ny_lylb_nr_lb">
					<form method="post" action="<%=path%>/index/addcustomer.do">
						<table cellpadding="5" cellspacing="0" border="0" width="100%">
							<tbody>
								<tr>
									<td class="border_t_l_r_01" align="right" width="14%"
										height="30">用户名：</td>
									<td class="border_t_r_01" width="31%"><input type="text"
										class="input_01" style="WIDTH: 150px" maxlength="50"
										name="customername" onblur="isValidName(this,'nameTip');"></input>
										<span style="color: #FF0000" id="nameTip">*</span></td>
								</tr>
								<tr>
									<td class="border_t_r_01" align="right" width="15%">用户昵称：</td>
									<td class="border_t_r_01" width="40%"><input type="text"
										class="input_01" style="WIDTH: 200px" maxlength="50"
										name="customernickname" /></td>
								</tr>
								<tr>
									<td class="border_t_r_01" align="right" width="15%">密码：</td>
									<td class="border_t_r_01" width="40%"><input
										type="password" class="input_01" style="WIDTH: 200px"
										maxlength="50" name="password"
										onblur="isValidPwd(this,'password');" /><span
										style="color: #FF0000" id="password">*</span></td>
								</tr>
								<tr>
									<td class="border_t_l_r_01" align="right" height="30">email：</td>
									<td colspan="3" class="border_t_r_01"><input type="text"
										class="input_01" style="WIDTH: 200px" maxlength="20"
										name="email" onblur="isValidEmail(this,'email');" /><span
										style="color: #FF0000" id="email">*</span></td>
								</tr>
								<tr>
									<td class="border_t_l_r_01" align="right" height="30">联系电话：</td>
									<td colspan="3" class="border_t_r_01"><input type="text"
										class="input_01" style="WIDTH: 200px" maxlength="20"
										name="iphone" onblur="isValidTelNum(this,'iphone');" /><span
										style="color: #FF0000" id="iphone">*</span></td>
								</tr>
								<tr>
									<td class="border_t_l_r_01" align="right" height="30">地址：</td>
									<td colspan="3" class="border_t_r_01"><input type="text"
										class="input_01" style="WIDTH: 200px" maxlength="20"
										name="address" /></td>
								</tr>
								<tr>
									<td class="border_t_l_r_01" align="right" height="30">性别：</td>
									<td colspan="3" class="border_t_r_01"><input type="radio"
										name="gender" checked="checked" value="男">男</input> <input
										type="radio" name="gender" value="女">女</input></td>
								</tr>
								<tr>
									<td class="border_t_l_r_01" align="right" height="30">备注：<br />
										<font color="red">150汉字以内</font></td>
									<td colspan="3" class="border_t_r_01"><textarea
											name="remarks" class="input_01"
											style="height: 60px; WIDTH: 495px"
											onblur="isValidChinese(this,'remarks');"></textarea> <span
										id="remarks"></span></td>
								</tr>
								<tr>
									<td colspan="3" class="border_t_b_r_01" align="left"><input
										value=" 注册" name="submit" style="width: 200px; height: 30px;"
										type="submit"></input></td>
								</tr>
							</tbody>
						</table>
					</form>
					<div style="clear: both;"></div>
				</div>
			</div>
			<div class="page"></div>
		</div>
		<div style="clear: both;"></div>
	</div>
	<div style="height: 15px;"></div>
	<div class="link">
		<div class="link_bt">友情链接</div>
		<div class="link_nr">
			<a href="http://029ctssx.com/" target="_blank">陕西中国旅行社</a> <a
				href="http://www.520xa.cn/" target="_blank">陕西中国旅行社</a> <a
				href="http://www.520cts.com/" target="_blank">陕西中国旅行社</a>
		</div>
		<!--<div class="link_gd">更多+</div>-->
	</div>
	<div class="f">
		<div class="f_t">
			<div class="f_t_l">
				<ul>
					<li style="font-size: 14px; font-weight: bold;">预订流程说明</li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=4">签署合同</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=3">选择付款方式</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=2">在线提交订单</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=1">查询线路</a></li>
				</ul>
			</div>
			<div class="f_t_l">
				<ul>
					<li style="font-size: 14px; font-weight: bold;">支付说明</li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=8"
						target="_blank">上门收款</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=7"
						target="_blank">银行转帐</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=6"
						target="_blank">网上支付</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=5"
						target="_blank">门市到店付款</a></li>
				</ul>
			</div>
			<div class="f_t_l">
				<ul>
					<li style="font-size: 14px; font-weight: bold;">签署旅游合同</li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=12"
						target="_blank">上门签署</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=11"
						target="_blank">快递签署</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=10"
						target="_blank">传真签署</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=9"
						target="_blank">旅游合同范本</a></li>
				</ul>
			</div>
			<div class="f_t_l">
				<ul>
					<li style="font-size: 14px; font-weight: bold;">其他事项</li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=16">自由行攻略</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=15">退款退团问题</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=14">旅游保险问题</a></li>
					<li><a href="http://029cts.cn/?mod=help_detail&amp;id=13">签证相关问题</a></li>
				</ul>
			</div>
			<div style="float: right; margin-right: 15px; width: 202px;">
				<img src="images/gj.jpg" />
			</div>
		</div>
	</div>
</body>
</html>
