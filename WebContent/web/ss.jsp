<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="ss">
	<div class="ss_bd">
    	<ul>
         <form method="post" action="/?mod=search">
           <input value="" name="module" type="hidden">
           <input value="add" name="action" type="hidden">
        	<li class="ss_bd_l">
            <input name="keyword" style="width:188px; border:1px solid #e7e7e7; background:#fff; height:26px; line-height:26px; padding-left:5px;" type="text">
            </li>
            <li class="ss_bd_r">
            <input name="button" id="button" value="" class="ss_an" type="submit">
            </li>
         </form>   
        </ul>
  </div>
 	<div class="gjc">   
        <a href="<%=request.getContextPath() %>/index/querybasedata.do" >首页</a>
        <a href="<%=request.getContextPath() %>/index/queryviewspace.do" >景区列表</a>
        <a href="<%=request.getContextPath() %>/index/gotoOrder.do" >购物车</a>
        <a href="<%=request.getContextPath() %>/index/querycity.do" >旅游定制</a>
        <a href="<%=request.getContextPath() %>/web/register.jsp" >用户注册</a>
        <a href="<%=request.getContextPath() %>/admin/login.jsp" >登录后台</a>
        </div>
</div>