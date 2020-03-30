
<%@page import="java.awt.Color"%>
<%@page import="oAbangong.mvc.model.User"%>
<%@page import="oAbangong.mvc.model.Message"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/css.css">
</head>
<%
User u = new User(session.getAttribute("id").toString());
u = u.queryUserById();
String role = u.getRole();
String r = role;
String info ="暂无最新公告";
Object o = application.getAttribute("info");
if(o !=null){
	 info=o.toString();}%>
<body style="overflow:hidden;background-image:url(resource/6.jpg);background-size:180px;">
 <%-- 使用marquee标签, 在其中使用表达式进行输出ff2750-95f900 --%>
    <marquee onMouseOver="this.stop()" onMouseOut="this.start()" behavior="scroll" scrollamount="7" direction="left" loop="-1">
    <%Color c= new Color(128,0,255);c.brighter().brighter().brighter().brighter().brighter().brighter().brighter().brighter().brighter().brighter().brighter(); %>
        <font color="#ff2750" size="6px" ><%=info%></font>
    </marquee>
    <%//刷新页面，数字1带表秒
		
		response.setHeader("refresh", "28");
		%>
    <div style="margin:6px 319px;text-align:center;background:url(resource/3.jpg);background-size:180px;border:3px solid #95f900; width=100%;">
    <font size="10px" class="text"><%=r %></font>
    </div>
</body>
</html>