<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="banner">
  <div id="ibanner">
    <div id="ibanner_pic">
	  
       <table id="pictable">
		 <tr>
		 <c:choose>
		 <c:when test="${empty viewspaces}">
		 <tr>no data</tr>
		 </c:when>
		 <c:otherwise>
		 <c:forEach var="v" items="${viewspaces}">
		 <td><a href="<%=request.getContextPath() %>/index/queryviewspacedetail.do?viewspaceid=${v.spaceId}"><img src="<%=request.getContextPath() %>/uploads/${v.picture}" width="310px"></a><br>
		        
				<span><center><a href="<%=request.getContextPath() %>/index/queryviewspacedetail.do?viewspaceid=${v.spaceId}"><font style="color:red;font-size:150%" >${v.spaceName}</font></a></center><br>
				${v.description }</span></td>
		</c:forEach>
		</c:otherwise>
		</c:choose>
		</tr>
				
		  <tr>
		  <c:choose>
		 <c:when test="${empty viewspacess}">
		 <tr>no data</tr>
		 </c:when>
		 <c:otherwise>
		 <c:forEach var="v" items="${viewspacess}">
		 <td><a href="<%=request.getContextPath() %>/index/queryviewspacedetail.do?viewspaceid=${v.spaceId}"><img src="<%=request.getContextPath() %>/uploads/${v.picture}" width="310px"></a><br>
		        
				<span><center><a href="<%=request.getContextPath() %>/index/queryviewspacedetail.do?viewspaceid=${v.spaceId}"><font style="color:red;font-size:150%" >${v.spaceName}</font></a></center><br>
				${v.description }</span></td>
		</c:forEach>
		</c:otherwise>
		</c:choose>	
		</tr>
        </table>
</div>
</div>
</div>