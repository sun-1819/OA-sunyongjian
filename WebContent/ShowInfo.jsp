<%@page import="oAbangong.mvc.model.User"%>
<%@page import="oAbangong.mvc.model.EmailInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html  >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/css.css">
</head><%	
ArrayList<EmailInfo> u = new ArrayList<EmailInfo>();
 Object uList = session.getAttribute("uList");
 String n = request.getParameter("i");
 System.out.print(n);
 int i = Integer.parseInt(n);
 System.out.print(i);
 if(uList != null){
u = (ArrayList<EmailInfo>) uList;
 if(u==null){
	 System.out.print("21行s"); 
 }
 EmailInfo emi = new EmailInfo();
 
 System.out.print("22行s");
 String id = u.get(i).getId();
boolean result = emi.updateInfo(id);
if(result){
	System.out.print("已读取成功");
}
 System.out.print(u.get(0).getName());}
 else{
	 System.out.print("uListkong"); 
 }
 User us = new User(u.get(i).getFromid());
us = us.queryUserById();
%>
<body>
<div>
<font>第<%=i+1 %>条信息</font>
</div>
<div><a id ="bt1" href ="ShowInfo.jsp?i=<%=i-1%>&uList=<%=uList%>" onclick="<%=(i==0)? "return false;":"return true;" %>">上一条</a>
<a id ="bt2" href ="ShowInfo.jsp?i=<%=i+1%>&uList=<%=uList%>" onclick="<%=(i==(u.size()-1))? "return false;":"return true;" %>">下一条</a>
</div>

		<form action="">
		
		<div>
		时间<input type="text" value="<%=u.get(i).getTime() %>" readonly>
		</div>	
		<div>	<font>主题</font>
		</div>
		
<div>		
<input type="text" name="name" value="<%=u.get(i).getName() %>" readonly>
</div>
		
		<div>
			<font>来自联系人</font>
			
		
		
			<font><%=us.getName() %> 账号- <%=us.getId() %></font>
			
		</div>
		
	<div>	
<textarea rows="9" cols="20" class="rowgg" style="font-size:39px;"name="mailbody" readonly><%=u.get(i).getMailbody() %></textarea>
</div>

</form>
<font><%=i+1 %></font>
<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>
</body>
<!-- <script type="text/javascript"> -->
<!-- function changeZi(){
	
if(i != (uList.size() -1)){
	document.getElementById("bt1").disabled=false;
i = i+1;
session.setAttribute(i);
}else{session.setAttribute(i);document.getElementById("bt1").disabled=ture;
}}
function changeJi(){
	
	if(i != 0){
		document.getElementById("bt2").disabled=false;
	i = i-1;
	session.setAttribute(i);
	}else{session.setAttribute(i);document.getElementById("bt2").disabled=ture;
	}}
</script> -->
</html>