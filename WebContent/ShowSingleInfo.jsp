<%@page import="oAbangong.mvc.model.EmailInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="oAbangong.mvc.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Css/css.css">
</head><%	
ArrayList<EmailInfo> uList = new ArrayList<EmailInfo>();
 Object u = request.getAttribute("tList");
 String n = request.getParameter("i");
 System.out.print(n);
 int i = Integer.parseInt(n);
 System.out.print(i);
 if(u != null){
 uList = (ArrayList<EmailInfo>) u;
 if(uList==null){
	 System.out.print("21行s"); 
 }
 EmailInfo emi = new EmailInfo();
 
 System.out.print("22行s");
 String id = uList.get(i).getId();
boolean result = emi.updateInfo(id);
if(result){
	System.out.print("已读取成功"+uList.get(i).getId());
}
 System.out.print(uList.get(0).getName());}
 else{
	 System.out.print("uListkong"); 
 }
 User us = new User(uList.get(i).getFromid());
us = us.queryUserById();
System.out.print(us.getName()+"-"+us.getId());
%>
<body>


		<form action="">
		<div>	<font>主题</font>
		</div>
		<div>		
<input type="text" name="name" value="<%=uList.get(i).getName() %>" readonly>
</div>
<div>	<font>时间</font>
		</div>
		<div>
		<input type="text" value="<%=uList.get(i).getTime() %>" readonly>
		</div>	
		
		

		
		<div>
			<font>发送至</font>
			
		</div>
		<div>
			<input type ="text"value="<%=us.getName() %> 账号: <%=us.getId() %>" readonly>
			
		</div>
		
		<div>
			<font>内容</font>
			
		</div>
	<div>	
<textarea rows="9" cols="20" class="rowgg" style="font-size:39px; name="mailbody" readonly ><%=uList.get(i).getMailbody() %></textarea>
</div>

</form>
<input type="button" name="jump" value= "返回主页" onclick="location.href='User.jsp'"/>
<input type="button" name="jump" value= "返回主页" onclick="location.href='Failure.jsp' "/>
<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>
</body>
</html>