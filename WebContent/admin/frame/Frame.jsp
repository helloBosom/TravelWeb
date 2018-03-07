<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<html>

<head>
<link href="<%=path%>/admin/css/styles.css" rel="stylesheet" type="text/css">
<SCRIPT language=JavaScript>

function switchSysBar(){
if (switchPoint.innerText==3){
switchPoint.innerText=4
document.all("frmTitle").style.display="none"
}else{
switchPoint.innerText=3
document.all("frmTitle").style.display=""
}}

</SCRIPT>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>环球风情分销平台</title>
</head>
<!-- <frameset rows="63,*" cols="*" framespacing="0" frameborder="yes" border="0">
    <frame src="Head.jsp" name="headFrame" scrolling="NO" noresize marginwidth="0"
           marginheight="0">
    <frameset name="main" rows="*" cols="180,*" framespacing="0" frameborder="NO" border="0">
        <frame name="viewFrame" src="ViewFrame.jsp" frameborder="0" scrolling="0">
        <frame name="mainFrame" src="Main.jsp">
    </frameset>
</frameset> -->
<BODY style="MARGIN: 0px" scroll=no topmargin="0" leftmargin="0" >
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD colSpan=3><IFRAME 
      style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 100px" 
      name=Explorer_Tool marginWidth=0 marginHeight=0 
      src="<%=path%>/admin/frame/Head.jsp" frameBorder=0 noResize scrolling=no 
       bordercolor="threedface" ></IFRAME></TD></TR>
  <TR>
    <TD id=frmTitle align=middle width=170 height="100%"><IFRAME 
      style="Z-INDEX: 2; VISIBILITY: inherit; WIDTH: 170; HEIGHT: 100%" 
      id=BoardLeft name=BoardLeft marginWidth=0 frameSpacing=2 marginHeight=0 
      src="<%=path%>/admin/frame/Menu.jsp" frameBorder=0 noResize></IFRAME></TD>
  <<TD width=3 bgcolor="#A3A7A3" style="HEIGHT: 100%" onclick="switchSysBar();"><FONT 
      style="FONT-SIZE: 9pt; CURSOR: hand; COLOR: #000000; FONT-FAMILY: Webdings"><SPAN 
      id=switchPoint>3</SPAN></FONT></TD>
    <TD height="100%"><IFRAME 
      style="Z-INDEX: 3; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 100%" 
     id=BoardRight name=BoardRight  frameSpacing=1 src="<%=path%>/admin/frame/Main.jsp" 
      frameBorder=0></IFRAME></TD></TR>
</TBODY></TABLE>
</BODY>

</html>