<%@page import="oAbangong.mvc.model.User"%>
<%@page import="oAbangong.mvc.model.Email"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%	
ArrayList<Email> uList = new ArrayList<Email>();
 Object u = request.getAttribute("uList");
 String n = request.getParameter("i");
 System.out.print(n);
 int i = Integer.parseInt(n);
 if(u != null){
 uList = (ArrayList<Email>) u;
 Email ema = new Email();
 String id = uList.get(i).getId();
boolean result = ema.update(id);
if(result){
	System.out.print("已读取成功");
}
 System.out.print(uList.get(0).getPicture());}
 else{
	 System.out.print("uListkong"); 
 }
 User us = new User(uList.get(i).getId());
 us = us.queryUserById();
%>
</head>
<body>
<div>
<font>第<%=i+1 %>条信息</font>
</div>
<div><a id ="bt1" href ="ShowEmail.jsp?i=<%=i-1%>" onclick="<%=(i==0)? "return false;":"return true;" %>">上一条</a>
<a id ="bt2" href ="ShowEmail.jsp?i=<%=i+1%>" onclick="<%=(i==(uList.size()-1))? "return false;":"return true;" %>">下一条</a>
</div>
</div>

		<form action="">
		<div>	<font>主题</font>
		</div>
		<div>		
<input type="text" name="name" value="<%=uList.get(i).getPicture() %>" readonly>
</div>
<div>
		时间<input type="text" value="<%=uList.get(i).getTime() %>" readonly>
		</div>	
		
		
		<div>
			<font>来自联系人</font>
			
		
		
			<font><%=us.getName() %> 账号- <%=us.getId() %></font>
			
		</div>
		<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>
</body>
</html>