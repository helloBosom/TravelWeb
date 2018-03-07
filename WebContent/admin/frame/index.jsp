<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/main.css" rel="stylesheet" type="text/css">
<title>环球风情</title>
<style type="text/css">
	body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #0B6BC1;
}
.table-button input {
	font-size: 12px;
	color: #003366;
	background-image: url(../images/login.jpg);
	text-align: center;
	vertical-align: bottom;
	border: none;
	height: 27px;
	width: 69px;
	cursor: hand;
	background-repeat: no-repeat;
}
.con_2 {
	background-image: url(../images/18_04.gif);
	background-repeat: no-repeat;
	height: 74px;
	width: 1280px;
}
.foot {
	background-image: url(../images/18_05.gif);
	background-repeat: no-repeat;
	height: 256px;
	width: 1280px;
}
    .top {
	background-image: url(../images/18_01.gif);
	background-repeat: no-repeat;
	height: 294px;
	width: 1280px;
}
    .con {
	background-image: url(../images/18_02.gif);
	background-repeat: no-repeat;
	height: 104px;
	width: 1280px;
}
    #cont {
	width: 600px;
	margin-right: auto;
	margin-left: auto;
	padding-top: 28px;
	padding-left: 50px;
	height: 80px;
	clear: both;
}
    .con_1 {
	background-image: url(../images/18_03.gif);
	background-repeat: no-repeat;
	height: 72px;
	width: 1280px;
}
    #cont1 {
	width: 600px;
	padding-left: 50px;
	padding-top: 14px;
	margin-right: auto;
	margin-left: auto;
	height: 30px;
}
    #cont2 {
	margin-right: auto;
	margin-left: 470px;
	width: 300px;
	height: 30px;
	vertical-align: middle;
	padding-top: 2px;
}
    #login {
	background-image: url(../images/login.jpg);
	height: 27px;
	width: 69px;
}
    </style>
	</head>
<script language="javascript">
  function ss(){
  flog=true ;
  if(document.form1.username.value =="admin" && document.form1.pwd.value =="admin" ){
		window.location.href('frame/Frame.html');
		return  flog=false;
		
	}if(document.form1.username.value =="test" &&document.form1.pwd.value =="123"){
		window.location.href('frame_fenxiao/Frame.html');
		return  flog=false;
			
	}
  if(document.form1.username.value==""){
 
 //document.getElementById('msg').innerHTML="用户名为空";
 alert("用户名为空");
  
  return  flog=false;
  }
    if(document.form1.username.value!=""&&document.form1.username.value!="admin" && document.form1.username.value!="test"){
  // document.getElementById('msg').innerHTML="用户名错误";
    alert("用户名错误");
    
  return flog=false;
   }
    if(document.form1.pwd.value==""){
//  document.getElementById('msg').innerHTML="密码为空";
 alert("密码为空");
  return flog=false;
  }
    if(document.form1.pwd.value!=""&&document.form1.pwd.value!="admin" && document.form1.pwd.value!="123"){
     alert("密码错误");
 // document.getElementById('msg').innerHTML="密码错误";
  return flog=false;
  }
  
 
 
  
  //return flog;
  }
  
  
  </script>
<body>
 <form name="form1"  method="post" enctype='multipart/form-data' onSubmit="return ss()">
	<div class ="top"></div>
       <div class="con">
       	  <div id="cont" align="center" >
     
        <p>&nbsp;</p>
        <p>
          <input name="username" type="text" size="24">
        
        </p>
        
      	</div>
      </div>
      <div class="con_1">
      		<div id="cont1" align="center" >
      
        
       	  	<input name="pwd" type="password" size="25">
      
        	</div>
       </div>
    <div class="con_2">
    	<div id="cont2" align="center" >
        <span class="table-button"><input type="submit" value=" " name="login" class="input" 
         id="login"> </span></div>
    
    </div>
        <div class="foot"></div>
 </form>   
</body>
</html>
