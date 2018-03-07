<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<html>
<head>
<title></title>
<script type="text/javascript">
	function isValidName(obj, id) {
		var reg = /^[\u4e00-\u9fa5]{2,4}$/;
		var strId = obj.value;
		//window.alert(strId);
		if (strId == "") {
			document.getElementById(id).innerHTML = "姓名不能为空！";
			return false;
		} else if (reg.test(obj.value)) {
			document.getElementById(id).innerHTML = "";
			return true;
		} else {
			document.getElementById(id).innerHTML = "请输入正确的姓名(2～4个汉字)";
			return false;
		}
	}

	<!--密码验证-->
	function isValidPwd(obj, id) {
		var reg = /^[A-Za-z0-9]{6,18}$/;
		var strId = obj.value;
		//window.alert(strId);
		if (strId == "") {
			document.getElementById(id).innerHTML = "密码不能为空！";
			return false;
		} else if (reg.test(obj.value)) {
			document.getElementById(id).innerHTML = "";
			return true;
		} else {
			document.getElementById(id).innerHTML = "密码必须由6～18为字母.数字组成!";
			return false;
		}
	}
</script>
</head>
<body>
	
	<div class="main_left">
		<div class="ny_left_lvxl">
		<c:choose>
		<c:when test="${empty sessionScope.customername }">
		<form action="<%=request.getContextPath()%>/index/customerlogin.do" method="post">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="customername"
					onblur="isNullName(this);"></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><a href="register.jsp"><input type="button" value="注册"></a></td>
				<td><input type="submit"  value="登录" ></td>
			</tr>
		</table>
	</form>
		</c:when>
		<c:otherwise>
		欢迎你:${ sessionScope.customername}
		<a href="<%=request.getContextPath()%>/index/customerlogin.do?operation=invalidate"><input type="button" value="注销"></a>
		</c:otherwise>
		</c:choose>
		
			<div class="ny_left_lvxl_top">西安旅游线路</div>
			<div class="ny_left_lvxl_fl">
				<ul>
					<c:choose>
						<c:when test="${empty viewroutes}">
							<li>no data</li>
						</c:when>
						<c:otherwise>
							<c:forEach var="v" items="${viewroutes}">
								<li><a href="<%=request.getContextPath()%>/index/queryproductlist.do?routeid=${v.routeid}">${v.routename}</a></li>
							</c:forEach>
						</c:otherwise>
					</c:choose>

					

				</ul>
			</div>

		</div>
		<div class="ny_left_lxwm">
			<div class="ny_left_lvxl_top">联系我们</div>
			<div class="ny_left_lxwm_nr">

	
				<p align="left">
					联系电话: <br></strong>18392328045<br>18291168747<br>
					18292542379<br>
					
					
				</p>
				<p align="left">
					<br> <strong>地 址：西安市高新区锦业一路<br>邮编：700000<br>
						<br> <br> <br></strong>
				</p>


			</div>



			<div class="ny_jpxl_top"></div>
			
			
		</div>

	</div>
</body>
</html>