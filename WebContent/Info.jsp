<%@page import="java.util.ArrayList"%>
<%@page import="oAbangong.mvc.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html >
<%User u = new User();
ArrayList<User> uList = u.selectAllUser();%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/css.css">
</head>
<body>
<form action="AddInfo" method="post">
<div class="row">
<input type="text" name="name" placeholder="消息主题">
</div>
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
<textarea  rows="9" cols="20" class="rowgg" style="font-size:39px;" name="mailbody" placeholder="请输入消息"></textarea>
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
<script type="text/javascript">
private void button1_Click(Object sender, EventArgs e)
{
    string s = "Hello world";
    Graphics g = CreateGraphics();
    var size = g.MeasureString(s, Font);
    g.FillRectangle(SystemBrushes.Highlight, 10, 10, size.Width, size.Height);
    g.DrawString(s, Font, SystemBrushes.HighlightText, 10.0F, 10.0F);
}</script>
</html>