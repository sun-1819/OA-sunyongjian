<%@page import="java.util.ArrayList"%>
<%@page import="oAbangong.mvc.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%User u = new User();
ArrayList<User> uList = u.selectAllUser();%>
<body>
<form action="AddEmail" method="post" enctype="multipart/form-data">
<div class="row">
联系人
<select name="toid">
<%
			for(int i = 0;i < uList.size();i++){
				User u1 = uList.get(i); 
				if(!u1.getId().equals(session.getAttribute("id").toString())){%>
				<option value="<%=u1.getId() %>"><%=u1.getName() %>-账号-<%=u1.getId() %></option>
					
			
				
		<% }}%>
<%-- <c:forEach items="<%=uList %>" var="user">
					<option value="${user.id}">${user.name }"-账号-"${(user.id}</option>
				</c:forEach> --%>
				</select><br >
				</div>

<div class="row">
		 请选择文件<input type="file" name="picture" >
		</div>
		<div class="row">
		 <input type="submit" value="发送" >
		</div>
</form>
<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>
</body>
</html>