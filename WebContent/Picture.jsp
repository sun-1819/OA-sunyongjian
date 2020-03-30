<%@page import="oAbangong.mvc.model.User"%>
<%@page import="oAbangong.mvc.model.EmailInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title><%-- background="resource/<%=u.getPicture() %>" --%>
<%
String Id = session.getAttribute("id").toString(); 
User u = new User(Id);
u=u.queryUserById();%>
</head>
<body style="overflow:hidden;background-image:url(resource/4.jpg);background-size:100%;">
<font style="float:left;" color="#525d76" size="5px">头像</font>
<div style="text-align:center;"><a href="Img.jsp" target="_self"><img src="resource/<%=u.getPicture() %>" width="100px" height="100px"style="border-radius:50px;"></a></div>
<font style="float:left;" color="#525d76" size="5px">姓名：</font>
<font style="float:left;" color="#525d76" size="5px"><%=u.getName() %></font>
</body>
</html>