<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 	String path = request.getContextPath(); 
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/admin/";  
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>城市管理</title>
  <base href="<%=basePath%>">
  <link href="css/main.css" rel="stylesheet" type="text/css">
</head>

<body>
<form action="<%=path %>/city/add.do" method="post">
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：城市添加</td>
    </tr>
  </table>
  
  <table align="center" class="table-form"><tr><td colspan="2" class="table-title">添加城市</td>
      
          <tr>  
            <td width="10%" class="table-list_title">城市</td>
            <td width="40%"><input name="cityName" type="text" class="input"><span class="red">*</span></td>
          </tr>
          
          <!-- 待定 -->
          <tr>  
            
            
          </tr>
          
          <tr>
            <td class="table-list_title">详细</td>
            <td>
            <textarea name="remarks" cols="25" rows="6" class="input"></textarea></td>
          </tr>
          <tr>
            <td align="right" colspan="2" height="30" style="padding-right:300px;" class="table-button"> 
            <input type="submit" value="提交" name="submit" class="input" >
            <input type="reset" value="重置" name="reset" class="input" >
                       说明：其中带<span class="red">*</span>号为必填项 </td>
          </tr>
    </table>
</form>
</body>
</html>