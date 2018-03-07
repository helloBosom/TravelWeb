<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path=request.getContextPath();%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>修改主题</title>
  <link href="<%=path %>/admin/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25><img src="<%=path%>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：旅游主题管理》修改主题</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td>
      
        <table align="center" class="table-form">
          <tr>
            <td colspan="4" class="table-title"> 旅游主题信息</td>
          </tr>
          <tr>
          <form action="<%=path %>/theme/${theme.themeId }/updatetheme.do"  method="post" enctype="multipart/form-data">
            <td class="table-list_title">主题名称</td>
            <td><input name="themename" type="text" class="input" value="${theme. themeName}"> <span class="red">*</span></td>
            <td class="table-list_title">序号</td>
            <td><input name="themeId" type="text" disabled class="input" value="${theme.themeId }" readonly></td>
          </tr>
          <tr>
            <td class="table-list_title">主题描述</td>
            <td><textarea name="themedescribe" cols="25" rows="6" class="input" value="">${theme.themeDescribe}
 </textarea>              <span class="red">*</span></td>
            <td class="table-list_title">主题图片</td>
            <td >
            <p><input type="file" name="imgFile" style="width:80%" onChange="fnCheckFile(file)"></p>
              <img src="<%=path %>/admin/images/test.png" width="200" height="200">
            </td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="30%" class="pizhu">说明：其中带<span class="red">*</span>号为必填项</td>
            <td height="30" style="padding-right:300px;" class="table-button">
			<input type="submit" value="保存" name="B333" class="input" >
			<input type="reset" value="重置" name="B332" class="input" >
            <input type="button" value="返回" name="B331" class="input" onClick="javascript:history.back()">
               </form>
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</body>
</html>
