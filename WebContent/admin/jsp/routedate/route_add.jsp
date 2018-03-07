<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>添加线路</title>
  <link href="<%=path %>/admin/css/main.css" rel="stylesheet" type="text/css">
  <link href="<%=path %>/admin/js/datepicker/default/datepicker.css" rel="stylesheet" type="text/css">
  <link href="<%=path %>/admin/js/datepicker/whyGreen/datepicker.css" rel="stylesheet" type="text/css" disabled>
    <script language="javascript" type="text/javascript" src="<%=path %>/admin/js/datepicker/WdatePicker.js"></script>
</head>
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="<%=path%>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：发布线路—>修改线路</td>
    </tr>
    
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
      <form action="<%=path %>/route/addviewroute.do" method="post">
        <table align="center" class="table-form">
          <tr>
            <td colspan="5" class="table-title"> 线路添加</td>
          <tr>
            <td width="10%" class="table-list_title">路线名称</td>
            <td><input name="routename" type="text" class="input" placeholder="路线名称"><span class="red">*</span></td>
            <td width="10%" class="table-list_title">路线状态</td>
            <td><select name='routestates'  class='common-select'>
              <option selected>全部</option>
              <option>销售中...</option>
              <option>已停止销售！</option>
            </select>              <span class="red">*</span></td>
      
          </tr>
          <tr>
            <td class="table-list_title">路线专员</td>
            <td><input name="routeuserid" type="text" placeholder="路线专员">
            <span class="red">*</span></td>
            <td class="table-list_title"></td> 
            <td></td>
          </tr>
          <tr>
            <td class="table-list_title">发布日期</td>
            <td><span class="table-title1">
              <input name="publishdate" type="text" class="Wdate" onFocus="new WdatePicker(this,'%Y-%M-%D',true)">
            </span></td>
            <td class="table-list_title">结束日期</td>
            <td><span class="table-title1">
              <input name="enddate" type="text" class="Wdate" onFocus="new WdatePicker(this,'%Y-%M-%D',true)">
            </span></td>
          </tr>
         
          <tr>
          <td colspan="5" class="table-title"> 备注信息</td>
          </tr>
          <tr>
          
          	<td colspan="4" ><label for="textarea"></label>
          	  <textarea name="remarks" id="textarea" cols="45" rows="5"></textarea>
          	  
            </td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="30%" class="pizhu">说明：其中带<span class="red">*</span>号为必填项</td>
            <td height="30" style="padding-right:300px;" class="table-button"> <input type="submit" value="保存" name="B333" class="input" > <input type="reset"  value="重置" name="B332" class="input" onClick="location.href('#')"> 
            </td>
          </tr>
        </table>
       
      </td>
    </tr>
  </table>
   </form>
</body>
</html>