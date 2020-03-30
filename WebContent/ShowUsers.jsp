<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table border="1px" align="center">
		<tr>
			<th width="200px">用户头像</th>
			<th width="200px">员工账号</th>
	        <th width="200px">员工姓名</th>
			<!-- <th width="200px">员工密码</th> -->
			<th width="200px">员工性别</th>
			<th width="200px">员工身份证号码</th>
			<th width="200px">员工手机号码</th>
			<th width="200px">员工职位</th>
			<th width="200px">员工状态</th>
			<th width="200px">操作员账号</th>
			<th width="200px">编辑|删除</th>
			
		</tr>
		<%String path =request.getSession().getServletContext().getRealPath("/resource");%>
		<c:forEach items="${uList}" var="user">
			<tr align="center">
			    <td><img src="resource/${user.picture}" width="80px"></td>
				<td>${user.id}</td>
				<td>${user.name }</td>
				<td>${user.sex }</td>
				<td>${user.id_card }</td>
				<td>${user.tel }</td>
				<td>${user.role }</td>
				<td>${user.status }</td>
				<td>${user.playerid }</td>
				<td><a href="SelectUserby_idServlet?id=${user.id }"target="right" >修改</a>|<a href="DeleteUserby_idServlet?id=${user.id }" target="right">删除</a></td>
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