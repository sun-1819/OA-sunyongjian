<%@page import="java.util.ArrayList"%>
<%@page import="oAbangong.mvc.model.EmailInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%String id = session.getAttribute("id").toString();
EmailInfo emi = new EmailInfo();
ArrayList<EmailInfo> emiList = emi.selectReceiveInfo(id);%>
</head>
<body>
<table border="1px" align="center">
		<tr>
			<th width="200px">消息主题</th>
	        <th width="200px">发送人</th>
			<th width="200px">消息状态</th>
			<th width="200px">接收时间</th>
			<th width="200px">详细</th>
			
		</tr>
<%
		
		for(int i = 0;i < emiList.size();i++){
			EmailInfo e = emiList.get(i);%>
			<tr align="center">
				<td><%=e.getName() %></td>
				<td><%=e.getFromid() %></td>
				<td><%=e.getStatus() %></td>
				<td><%=e.getTime()%></td>
				<td><a href="ShowInfoById?id=<%=e.getId()%>">查看详细信息</a></td>
				
			</tr>
		
		<% 
		} 
		%>
		
	</table>
	<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>

</body>
</html>