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
  <title>职位管理</title>
  <base href="<%=basePath%>">
  <link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
 <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25><img src="images/frame/web_icon01.gif" width="11" height="8" > 当前位置：城市管理</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td>
      <form action="<%=path%>/city/update.do" method="post">
        <table align="center" class="table-form"><tr><td colspan="2" class="table-title">修改城市</td>
          <tr>
            <!-- 用户编号只读 -->
            <td width="10%" class="table-list_title">编号</td>            
            <td width="40%"><input name="id" type="text" class="input"  value="${city.id}" readonly="readonly"><span class="red"><font color="red" size="1">不能修改</font></span></td>
          </tr>
          <tr>  
            <td width="10%" class="table-list_title">城市</td>
            <td width="40%"><input name="cityname" type="text" class="input" value="${city.cityname}"><span class="red">*</span></td>
          </tr>
          <tr>
            <td class="table-list_title">备注</td>
            <td ><input name="remarks" type="text" class="input" value="${city.remarks}"></td>
          </tr>
          <tr>
            <td align="right" colspan="2" height="30" style="padding-right:300px;" class="table-button"> 
            <input type="submit" value="提交" name="submit" class="input" >
            <input type="reset" value="重置" name="reset" class="input" >
                       说明：其中带<span class="red">*</span>号为必填项 </td>
          </tr>
        </table>
      </form>
       
      </td>
    </tr>
  </table>
</body>
</html>