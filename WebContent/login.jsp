<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>用户登录</title>
</head>
<body>
<p>
    <font color="red">${error}</font>
</p>
<form action="<%=path%>/dologin.do">
    名称:<input type="text" name="username"/><br>
    密码:<input type="password" name="password"/><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>