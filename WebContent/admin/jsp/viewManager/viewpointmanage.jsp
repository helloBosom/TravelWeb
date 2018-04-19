<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>景点管理</title>
  <link href="../../css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
    <tr>
      <td height=25 bgcolor="#FFFFFF"><img src="../../images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：景点管理</td>
    </tr>
  </table>
  <table width="100%" align="center" class="table-list">
    <tr>
      <td bgcolor="#FFFFFF">
      <table align="center" class="table-form">
          <tr>
            <td colspan="3" class="table-title"> 景点查询</td>
          </tr>
          <tr>
            <td class="table-list_title">景点名称</td>
            <td><input name="textfield2" type="text" class="input"></td>
            <td><span class="table-button"><input type="button" value="查询" name="B33" class="input" onClick="location.href('#')"> </span></td>
          </tr>
        </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="60%" bgcolor="#FFFFFF">&nbsp;</td>
            <td width="40%" height="30" bgcolor="#FFFFFF" class="table-button">
			<input type="button" value="添加" name="B332" class="input" onClick="location.href('equipmentMold_add.html')">
			
			<input type="button" value="删除" name="B334" class="input" onClick="location.href('equipmentMold_list.html')"></td>
          </tr>
        </table>
<table align="center" class="table-table">
          <tr>
            <td colspan="6" class="table-title"> 景点信息</td>
          </tr>
          <tr>
            <td width="5%" align="center" class="table-title1">选择</td>
            <td width="5%" align="center" class="table-title1">景点名称</td>
            <td width="5%" align="center" class="table-title1">地址</td>
            <td width="70%" align="center" class="table-title1">描述</td>
            <td width="5%" align="center" class="table-title1">序号</td>
            <td width="10%" align="center" class="table-title1">操作</td>
          </tr>
          <tr>
            <td width="5%"><input type="checkbox" name="checkbox" value="checkbox"></td>
            <td width="5%">华山</td>
            <td width="5%">渭南</td>
           <td>陕西西安阎良区</td>
            <td>1</td>
             <td><a href="equipmentMold_update.html">修改｜<a href="equipmentMold_update.html">删除</a></a></td>
          </tr>
          <tr>
            <td><input type="checkbox" name="checkbox2" value="checkbox"></td>
            <td>大雁塔</td>
            <td>西安</td>
            
            <td>陕西西安户县</td>
            <td>2</td>
            <td><a href="equipmentMold_update.html">修改｜<a href="equipmentMold_update.html">删除</a></a></td>
          </tr>
          <tr>
            <td><input type="checkbox" name="checkbox3" value="checkbox"></td>
            <td>小雁塔</td>
            <td>西安</td>
           
            <td>陕西西安灞桥区</td>
            <td>3</td>
             <td><a href="equipmentMold_update.html">修改｜<a href="equipmentMold_update.html">删除</a></a></td>
          </tr>
          <tr>
            <td><input type="checkbox" name="checkbox3" value="checkbox"></td>
            <td>景点名称</td>
            <td>&nbsp;</td>
            
            <td>陕西西安新城区</td>
            <td>4</td>
            <td><a href="equipmentMold_update.html">修改｜<a href="equipmentMold_update.html">删除</a></a></td>
          </tr>
        </table>
        <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td align="right" bgcolor="#FFFFFF"> 共1条记录 <a href="#">首页</a> | <a href="#">上一页</a> | <a href="#">下一页</a> | <a href="#">尾页</a>
              <select name="_page">
                <option value="1" selected="selected">1/2</option>
                <option value="2">2/2</option>
              </select>
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
</body>
<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>
</html>
