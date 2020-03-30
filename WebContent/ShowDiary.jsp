<%@page import="oAbangong.mvc.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>
<body>

<table border="1px" align="center">
		<tr>
		    <th width="200px">员工账号</th>
	        <th width="200px">员工姓名</th>
			<th width="200px">日志标题</th>
			<th width="200px">上传时间</th>
			<th width="200px">查看详细</th>
			<th width="200px">编辑|删除</th>
		</tr>
		<c:forEach items="${dList}" var="diary">
			<tr align="center">
			<%System.out.print("25没问题"); %>
			<td>${diary.fromid }</td>
			<%System.out.print("27没问题"); %>
			<c:set var="bl" value="${diary.fromid }" scope="request"></c:set>
			
			<%
			User u = new User(request.getAttribute("bl").toString() );
			User u1 = u.queryUserById();%>
			
			
			<%System.out.print(request.getAttribute("bl") ); %>
				<td><%=u1.getName() %></td>
				<%System.out.print("32没问题"); %>
				<td>${diary.tittle }</td>
				<%System.out.print("34没问题"); %>
				<td>${diary.time }</td>
				<%System.out.print("36没问题"); %>
				<td><a href="ShowDiaryContent.jsp?id=${diary.id }">点击查看</a></td>
				<td><a href="Deletediaryby_idServlet?id=${diary.id }" >删除</a></td>
			</tr>
		
		</c:forEach>
		
	</table>
<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div></body>
</html>