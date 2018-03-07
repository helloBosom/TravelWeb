<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>viewFrame</title>
</head>

<frameset cols="*,10" frameborder="no" border="0"  name="viewArea"  framespacing="0">
  <frame src="Menu.jsp" name="menuFrame" id="mainFrame" />
  <frame src="SizeControl.jsp" name="sizeControlFrame" scrolling="No" noresize="noresize" id="SizeControl" />
</frameset>
<noframes><body>
</body>
</noframes></html>
