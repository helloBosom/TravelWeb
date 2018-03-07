<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>环球风情分销平台</title>
</head>
<frameset rows="63,*" cols="*" framespacing="0" frameborder="yes" border="0">
    <frame src="Head.jsp" name="headFrame" scrolling="NO" noresize marginwidth="0"
           marginheight="0">
    <frameset name="main" rows="*" cols="180,*" framespacing="0" frameborder="NO" border="0">
        <frame name="viewFrame" src="ViewFrame.jsp" frameborder="0" scrolling="0">
        <frame name="mainFrame" src="Main.jsp">
    </frameset>
</frameset>
<noframes>
    <body>
    </body>
</noframes>
</html>