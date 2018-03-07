<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/web/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="Generator" content="易·网站管理系统 V6.2.3">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords"
	content="陕西中国旅行社有限责任公司官方网站,陕西旅游,西安旅游,陕西旅行社,西安旅行社,西安周边游,西安一日游,出境旅游,国内旅游,西安旅游景点,西安旅游线路,西安旅游网,中国旅行社,西安旅游介绍,去西安旅游">
<meta name="description"
	content="陕西中国旅行社有限责任公司是中国旅行社协会常务理事单位和中国中旅集团常务理事单位，陕西旅游集团成员单位，是国家旅游局首批特许经营中国公民出国旅游的国际旅行社。">
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

	<%@ include file="ss.jsp"%>

	<div class="main">

		<%@ include file="main_left.jsp"%>


		<div class="ny_lylb">
			<div class="ny_lylb_top">
				<ul>
					<li><span>当前位置：<a href="index.htm" target="_blank">首页</a>
							-&gt; <a href="#" target="_blank">订单详情</a></span>订单详情</li>
				</ul>
			</div>
			<div class="ny_lylb_nr">

				<div class="ny_lylb_nr_lb">
					<form id="frmguestbook" name="frmguestbook" method="post"
						action="<%=path %>/index/buyit.do" >
						<input name="action" value="add" type="hidden">
						<table cellpadding="5" cellspacing="0" border="0" width="100%">

							<tbody>
								<tr>
									<td class="border_t_l_r_01" align="right" width="14%"
										height="30">订单人：</td>
									<td class="border_t_r_01" width="31%"><input
										class="input_01" style="WIDTH: 150px" maxlength="50"
										name="realname" readonly="readonly" id="realname"
										value="${sessionScope.customername }"><font
										color="red">*</font></td>
									<td class="border_t_r_01" align="right" width="15%">人数：</td>
									<td class="border_t_r_01" width="40%"><input
										class="input_01" style="WIDTH: 200px" maxlength="50"
										name="peoplenum" readonly="readonly" id="tel"
										value="${peoplenum }"><font color="red">*</font></td>
								</tr>
								<tr>
									<td class="border_t_l_r_01" align="right" height="30">手机号码：</td>
									<td colspan="3" class="border_t_r_01"><input
										class="input_01" style="WIDTH: 200px" maxlength="20"
										name="telnum1" value="${telphone }"></td>
								</tr>
								<tr>
									<td class="border_t_l_r_01" align="right" height="30">联系电话：</td>
									<td colspan="3" class="border_t_r_01"><input
										class="input_01" style="WIDTH: 200px" maxlength="20"
										name="telnum2"></td>
								</tr>
								<tr>
									<td class="border_t_l_r_01" align="right" height="30">应付金额：</td>
									<td colspan="3" class="border_t_r_01"><input
										class="input_01" style="WIDTH: 200px" maxlength="20"
										name="money" readonly="readonly" value="${sum }">(元)</td>
								</tr>
								<tr>
									<td class="border_t_l_r_01" align="right" height="30">支付方式：</td>
									<td colspan="3" class="border_t_r_01"><select
										name="InfoType">
											<option value="0">请选择支付方式</option>
											<option value="1" selected="selected">网上支付</option>
											<option value="2">现金支付</option>
											<!--                            <option value="3">业务咨询</option>
                            <option value="4">业务合作</option>
                            <option value="5">意见建议</option>-->
									</select><font color="red">*</font></td>
								</tr>
								<tr>
									<td class="border_t_l_r_01" align="right" height="30">已付金额：</td>
									<td colspan="3" class="border_t_r_01"><input
										class="input_01" style="WIDTH: 200px" maxlength="20"
										name="pay">(元)</td>
								</tr>

								<tr>
									<td class="border_t_l_r_01" align="right" height="30">留言内容：<br>
									<font color="red">150汉字以内</font></td>
									<td colspan="3" class="border_t_r_01"><textarea
											name="content" class="input_01"
											style="height: 60px; WIDTH: 495px"></textarea><font
										color="red">*</font> <!--br><div style="width:520px"></div--></td>
								</tr>


								<tr id="ntable">
									<table border="0">
										<tr>
											<td align="center" height="30" width="141">编号</td>
											<td align="center" height="30" width="20%">产品名称</td>
											<td align="center" height="30" width="20%">单价</td>
											<td align="center" height="30" width="20%">人数</td>
											<td align="center" height="30" width="20%">合计</td>
										</tr>
										<c:choose>
											<c:when test="${empty sessionScope.orders }">
												<tr>no data</tr>
											</c:when>
											<c:otherwise>
												<c:forEach var="v" items="${sessionScope.orders}">
													<tr>
														<td align="center" height="30" width="141">${v.num }</td>
														<td align="center" height="30" width="20%">${v.productName }</td>
														<td align="center" height="30" width="20%">${v.price }</td>
														<td align="center" height="30" width="20%">${v.pNum}</td>
														<td align="center" height="30" width="20%">${v.price*v.pNum }</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>

										</table>
								</tr>


								<tr>
									<td colspan="3" class="border_t_b_r_01" align="left">
									<input value=" 结算 " name="submit" style="width: 200px; height: 30px;" type="submit">
									</td>
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


	<%@ include file="foot.jsp"%>
</html>