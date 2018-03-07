<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>环球风情分销平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/top.css" rel="stylesheet" type="text/css">
<script>
function correctPNG() 
{
for(var i=0; i<document.images.length; i++)
{
var img = document.images[i]
var imgName = img.src.toUpperCase()
if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
{
var imgID = (img.id) ? "id='" + img.id + "' " : ""
var imgClass = (img.className) ? "class='" + img.className + "' " : ""
var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
var imgStyle = "display:inline-block;" + img.style.cssText 
if (img.align == "left") imgStyle = "float:left;" + imgStyle
if (img.align == "right") imgStyle = "float:right;" + imgStyle
if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle 
var strNewHTML = "<span "+ imgID + imgClass + imgTitle + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";" + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader" + "(src='" + img.src + "', sizingMethod='scale');\"></span>" 
img.outerHTML = strNewHTML
i = i-1
}
}
}
window.attachEvent("onload", correctPNG); 

</script>
</head>

<body>
<div id="top">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td id="logo"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="322" height="63">
      <param name="movie" value="../swf/head.swf">
      <param name="quality" value="high">
      <param name="Wmode" value="transparent">
      <embed src="../swf/head.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="322" height="63"></embed>
    </object></td>
    <td width="350" align="right"><table width="180" border="0" cellpadding="0" cellspacing="0">
        <tr>
        <!--
          <td align="center"><a target="_parent"  href="../../../电子工单/frame/Frame.html" title="切换进入EOMS系统" style="color: #FFFFFF;"><img src="../images/frame/head/EOMS.png" width="30" height="30" border="0"></a></td>
          <td align="center"><a href="#" title="帮助" style="color: #FFFFFF;"><img src="../images/frame/head/user.png" width="30" height="30" border="0"></a></td>
          <td align="center">
          <a id="atag" href="#" title="切换职位" style="color: #FFFFFF;"><img src="../images/frame/head/job.png" width="30" height="30" border="0" /></a></td>-->
          <td align="center">
            <a id="atag" href="#" title="切换职位" style="color: #FFFFFF;"><img src="../images/frame/head/pass.png" width="30" height="30"  border="0"/></a><a href="#" title="修改用户资料" style="color: #FFFFFF;"></a></td>
          <td align="center"><a id="atag" href="#" title="切换职位" style="color: #FFFFFF;"><img src="../images/frame/head/help.png" width="30" height="30"  border="0"/></a><a href="#" title="修改用户资料" style="color: #FFFFFF;"></a></td>
          <td align="center" onClick="mainPrint();">
            <a href="#"><img src="../images/frame/head/print.png" width="30" height="30"  border="0"/></a></td>
          <td align="center">
            <a href="#" style="color: #FFFFFF;"><img src="../images/frame/head/exit.png" width="30" height="30"  border="0"/></a></td>
        </tr>
		<tr>
        <!--
			  <td align="center" valign="middle"><span style="color:#FFFFFF">切换</span></a></td>
			  <td align="center" valign="middle"><span style="color:#FFFFFF">安丹</span></a></td>
			  <td align="center" valign="middle"><a href="#"><span style="color:#FFFFFF">职位</span></a></td>-->
			  <td align="center" valign="middle"><a href="#"><span style="color:#FFFFFF">密码</span></a></td>
			  <td align="center" valign="middle"><a href="#"><span style="color:#FFFFFF">帮助</span></a></td>
			  <td align="center" valign="middle"><a href="#"><span style="color:#FFFFFF">打印</span></a></td>
			  <td align="center" valign="middle"><a href="#"><span style="color:#FFFFFF">退出</span></a></td>
		</tr>
      </table></td>
  </tr>
</table>

</div>
</body>
</html>
