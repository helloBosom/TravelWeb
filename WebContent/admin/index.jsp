<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>login.jsp</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<style type="text/css">
	body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.con_2 {
	background-image: url(images/18_04.gif);
	background-repeat: no-repeat;
	height: 74px;
	width: 1280px;
}
.foot {
	background-image: url(images/18_05.gif);
	background-repeat: no-repeat;
	height: 256px;
	width: 1280px;
}
    .top {
	background-image: url(images/18_01.gif);
	background-repeat: no-repeat;
	height: 294px;
	width: 1280px;
}
    .con {
	background-image: url(images/18_02.gif);
	background-repeat: no-repeat;
	height: 104px;
	width: 1280px;
}
    #cont {
	height: 200px;
	width: 600px;
	margin-right: auto;
	margin-left: auto;
	padding-top: 25px;
	padding-left: 50px;
}
    .con_1 {
	background-image: url(images/18_03.gif);
	background-repeat: no-repeat;
	height: 72px;
	width: 1280px;
	margin-right: auto;
	margin-left: auto;
	padding-left: 25px;
}
    #cont1 {
	padding-top: 10px;
}
    #cont2 {
	padding-top: 5px;
	margin-right: auto;
	margin-left: auto;
}
    #login {
	background-image: url(images/login.jpg);
	height: 27px;
	width: 69px;
}
    </style>
	</head>
	<script type="text/javascript">
  function ss(){
  flog=true ;
  if(document.form1.username.value==""){
 
 //document.getElementById('msg').innerHTML="用户名为空";
 alert("用户名为空");
  
  return  flog=false;
  }
    if(document.form1.username.value!=""&&document.form1.username.value!="admin"){
  // document.getElementById('msg').innerHTML="用户名错误";
    alert("用户名错误");
    
  return flog=false;
   }
    if(document.form1.pwd.value==""){
//  document.getElementById('msg').innerHTML="密码为空";
 alert("密码为空");
  return flog=false;
  }
    if(document.form1.pwd.value!=""&&document.form1.pwd.value!="admin"){
     alert("密码错误");
 // document.getElementById('msg').innerHTML="密码错误";
  return flog=false;
  }
 
  
  //return flog;
  }
  
  
  </script>
	<body>
     <form action="frame/Frame.html" method="post" enctype="multipart/form-data">
	<div class ="top"></div>
       <div class="con">
       	  <div id="cont" align="center" >
     
        <p>&nbsp;</p>
        <p>
          <input name="user" type="text" size="23">
        
        </p>
        
      </div></div>
      <div class="con_1" align="center">
      	<div id="cont1" align="center" ><input name="pass" type="password" size="23"></div>
        </div>
    <div class="con_2">
    	<div id="cont1" align="center" ><input name="login" type="submit" id="login" value=" "></div>
    
    </div>
        <div class="foot"></div>
    </form>
	</body>
</html>
