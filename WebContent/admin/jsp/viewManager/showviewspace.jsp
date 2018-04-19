<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path=request.getContextPath(); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<%=path%>/admin/css/main.css" rel="stylesheet" type="text/css">
		<title>${viewForm.viewSpace.spaceName}</title>
	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
		<tr>
			<td height=25 bgcolor="#FFFFFF"><img src="<%=path%>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：${viewSpace.spaceName }详情</td>
		</tr>
	</table>
		<div>
			
				<div>
					<table align="center" class="table-table">
          <tr>
            <td colspan="2" class="table-title"> 景区信息</td>
          </tr>
			<tr>
			<td class="table-title1" width="15%">景区名：</td>
			<td class="table-title1"><input type="text" name="spaceName" value="${viewSpace.spaceName }" style="width: 100%" /></td></tr>
			<tr><td>景区地址：</td>
			<td><input type="text" name="address" value="${viewSpace.address}" style="width: 100%" /></td></tr>
			<tr><td>景区网址：</td><td><input type="text" name="website"  value="${viewSpace.website}" style="width: 100%" /></td>	</tr>
			<tr><td>简介：</td>
			<td><input type="text" name="description" value="${viewSpace.description}" style="width: 100%; height: 150px" /></td></tr>
			<c:if test="${!empty viewSpace.picture}">
								<tr>
									<td>
										景区图片
									</td>
									<td colspan="4">
										<img
										src="<%=path%>/uploads/${viewSpace.picture}" width="100px"/>
									</td>
								</tr>
							</c:if>
			
					</table>
			
			<c:choose>
			<c:when test="${empty viewSpace.comments }"></c:when>
			<c:otherwise>
			<table align="center" class="table-table" border="1">
			<tr>
            <td colspan="6" class="table-title"> 用户评论</td>
          </tr>
           <tr>
            <td width="5%" align="center" class="table-title1">用户名</td>
            <td width="10%" align="center" class="table-title1">用户电话</td>
            <td width="10%" align="center" class="table-title1">用户IP</td>
            <td width="%" align="center" class="table-title1">评论内容</td>
            <td width="5%" align="center" class="table-title1">状态</td>
            <td width="10%" align="center" class="table-title1">操作</td>
          </tr>
          <c:forEach var="comment" items="${viewSpace.comments}">
          <tr>
          <td width="5%" align="center" class="table-title1">${comment.username}</td>
            <td width="10%" align="center" class="table-title1">${comment.phone}</td>
            <td width="10%" align="center" class="table-title1">${comment.ip}</td>
            <td width="%" align="center" class="table-title1">${comment.content}</td>
            <td width="5%" align="center" class="table-title1">
            <c:if test="${comment.status==0}">未审核</c:if>
            <c:if test="${comment.status==1 }">通过审核</c:if>
            <c:if test="${comment.status==2}">不通过</c:if>
            </td>
            <td width="10%" align="center" class="table-title1">
            <a href="<%=path%>/comment/delete.do?commentid=${comment.commentId}&spaceId=${viewSpace.spaceId}">删除</a>
            &nbsp;<a href="<%=path%>/comment/nopass.do?commentid=${comment.commentId}&spaceId=${viewSpace.spaceId}">不通过</a>
           &nbsp;<a href="<%=path%>/comment/pass.do?commentid=${comment.commentId}&spaceId=${viewSpace.spaceId}">  通过</a></td>
           </tr>
          </c:forEach>
			</table>
			</c:otherwise>
			</c:choose>
			
			<div>
				<div>
					<table border="1px" width="100%">
						<tr>
							<td colspan="5">
								<div style="float: left">
									景区景点
								</div>
								
							</td>
						</tr>
						<tr>
							<td width="4%">
								序号
							</td>
							<td width="20%">
								景点名
							</td>
							<td width="10%">
								票价(元)
							</td>
							<td width="50%">
								简介
							</td>
						
						</tr>
						
			<c:forEach var="viewPoint"  varStatus="status" items="${viewSpace.viewPoints }">
			
					<tr>
					<td>${status.count}</td>
					<td>${viewPoint.pointName}</td>
					<td>${viewPoint.ticketPrice }</td>
					<td>${viewPoint.description }</td>
					
					</tr>
							<c:if test="${!empty viewPoint.imgFile}">
								<tr>
									<td>
										景点图片
									</td>
									<td colspan="4">
										<img
										src="<%=path%>/uploads/${viewPoint.imgFile}" width="100px"/>
									</td>
								</tr>
							</c:if>
							</form>
						</c:forEach>
					</table>
				</div>
			</div>
	</body>
	<script type="text/javascript">var Ptr=document.getElementsByTagName("tr");function recolor() {for (i=1;i<Ptr.length+1;i++) {Ptr[i-1].className = (i%2>0)?"t1":"t2";}}window.onload=recolor;for(var i=0;i<Ptr.length;i++) {Ptr[i].onmouseover=function(){this.tmpClass=this.className;this.className = "t3";};Ptr[i].onmouseout=function(){this.className=this.tmpClass;};}</script>
</html>
