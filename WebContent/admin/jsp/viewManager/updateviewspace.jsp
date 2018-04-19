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
		<script>
	   function mySubmit(){
	      with(document){
	         var spaceName = getElementById("spaceName");
	         if(spaceName.value == null || spaceName.value.length ==0){
	            alert("景区名称不能为空，请填上.");
	            spaceName.focus();
	            return false;
	         }else if(spaceName.value.length > 50){
	            alert("景区名称最大长度不能超过50个字符，请调整.");
	            spaceName.focus();
	            return false;
	         }
	          
	         var address = getElementById("address");
	         if(address.value == null || address.value.length==0){
	            alert("景区地址不能为空，请填上.");
	            address.focus();
	            return false;
	         }else if(address.value.length > 50){
	            alert("景区名称最大长度不能超过150个字符，请调整.");
	            address.focus();
	            return false;
	         }
	         
	         var website = getElementById("website");
	         if(website.value != null){
	            if(website.value.length > 100){
	               alert("网址的长度不能超过100个字符。");
	               website.focus();
	               return false;
	            }else if(website.value.toUpperCase().indexOf("HTTP://") != 0){
				   alert("网址必须以http://开头。");
				   website.focus();
	               return false;
				}
	         }   
	         return true;
	      }
	      
	   }
	</script>
	</head>
	<body>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-location">
		<tr>
			<td height=25 bgcolor="#FFFFFF"><img src="<%=path%>/admin/images/frame/web_icon01.gif" width="11" height="8" align="absmiddle"> 当前位置：修改景区</td>
		</tr>
	</table>
		<div>
			<form action="<%=path %>/view/update/${viewSpace.spaceId}.do"
				onsubmit="return mySubmit()"  method="post">
				</div>
					<table align="center" class="table-table">
          <tr>
            <td colspan="2" class="table-title"> 景区信息</td>
          </tr>
			<tr>
			<td class="table-title1" width="15%">景区名称：</td>
			<td class="table-title1"><input type="text" name="spaceName" value="${viewSpace.spaceName }" style="width: 100%" /></td></tr>
			<tr><td>景区地址：</td>
			<td><input type="text" name="address" value="${viewSpace.address}" style="width: 100%" /></td></tr>
			<tr><td>景区网址：</td><td><input type="text" name="website"  value="${viewSpace.website}" style="width: 100%" /></td>	</tr>
			<tr><td>简介：</td>
			<td><input type="text" name="description" value="${viewSpace.description}" style="width: 100%; height: 100px" /></td></tr>
			<tr>
			<td >旅游主题类型:</td><c:choose>
                <c:when test="${empty themes}">
                </c:when>
                <c:otherwise>
                <td>
                <select   class='common-select' name="themeidvalue">
                <c:forEach var="v" items="${themes}">
		        <option value="${v.themeId }">${v.themeName}</option>
                </c:forEach>
                 </select>
                   </td>
                </c:otherwise>
                </c:choose>
                </tr>
                <tr>
			<td  >城市:</td>
			 <c:choose>
                <c:when test="${empty citys}">
                </c:when>
                <c:otherwise>
                <td>
                <select   class='common-select' name="cityId">
                <c:forEach var="v" items="${citys}">
		        <option value="${v.id }">${v.cityname}</option>
                </c:forEach>
                 </select>
                   </td>
                </c:otherwise>
                </c:choose>
                </tr>
			<tr>
			<td colspan="2" align="center">
			<input type="submit" value="保存">
			<input type="reset" value="重置">
								<input type="hidden" name="price"  value="${viewSpace.price }"/>
								<input type="hidden" name="status" value="${viewSpace.status }"/>
								<input type="hidden" name="remarks" value="${viewSpace.remarks }"/>
								<input type="hidden" name="spaceId" value="${viewSpace.spaceId }"/>
								
                
               
							</td>
						</tr>
					</table>
			</form>
			<div>
				<div>
					<table border="1px" width="100%">
						<tr>
							<td colspan="5">
								<div style="float: left">
									景区景点
								</div>
								<div style="float: right">
									<a href="<%=path%>/view/addpoint/${viewSpace.spaceId }.do"/>新增</a>
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
							<td>
								操作
							</td>
						</tr>
						
			<c:forEach var="viewPoint"  varStatus="status" items="${viewSpace.viewPoints }">
			
					<tr>
					<td>${status.count}</td>
					<td>${viewPoint.pointName}</td>
					<td>${viewPoint.ticketPrice }</td>
					<td>${viewPoint.description }</td>
					<td>
									<a href="<%=path %>/view/${viewPoint.pointId }/edit.do"/>更改</a>
								&nbsp;
									<a href="<%=path %>/view/${viewPoint.pointId }/delete.do"/>删除</a>
							</td>
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
