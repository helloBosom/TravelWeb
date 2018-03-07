<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript">
<!--用户名验证-->
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
	<a href="<%=path%>/route/routeAndProduct.do"><input type="submit"
		name="button" value="route"></a>
	<hr>
	<a href="<%=path%>/product/addproduct.do">productlink</a>
	<hr>
	<a href="<%=path%>/product/findproduct.do">productlink</a>
	<form action="<%=path%>/customer/customerlogin.do" method="post">
		customername:<input type="text" name="customername"
			onblur="isNullName(this,'name');"><span id="name"></span><br>
		password:<input type="possword" name="password"
			onblur="isNullName(this,'pwd');"><span id="pwd"></span> <input
			type="submit" value="ok">
	</form>
</body>
</html>