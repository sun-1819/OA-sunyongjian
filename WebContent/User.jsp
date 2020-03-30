<%@page import="oAbangong.mvc.model.Email"%>
<%@page import="oAbangong.mvc.model.EmailInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%String info="消息记录";
String id = session.getAttribute("id").toString();
 EmailInfo emi = new EmailInfo();
 String count = emi.selectNumInfo(id);
  if(count!=null&& !count.equals("0")){
	   info = "有"+count+"条新消息未读";
	  }
	  
	  String emfo="邮件记录";
 Email ema = new Email();
 String cont = ema.selectNum(id);
  if(cont!=null&& !cont.equals("0")){
	   emfo = "有"+cont+"条新邮件请及时查收";
	  }%>
</head>
<body style="overflow:hidden;background-image:url(resource/7.jpeg);background-size:220px 700px;">
<div>
<a href="SetSelfInfo.jsp" target="rightdown"><input type="button" value="个人设置" style=" background-color:#fd8103;"></a>
</div>
<!-- <div>
<a href=""><input type="button" value="待办事宜" style=" background-color:#fd8103;"></a>
</div> -->
<div>
<a href="PlayDiary.jsp" target="rightdown"><input type="button" value="工作日志" style=" background-color:#fd8103;"></a>
</div>
<div>
<a href=<%=(count.equals("0"))? "SelectInfo.jsp":"ShowDefaultInfoServlet"%>  target="rightdown"><input type="button" value="<%=info %>" style=" background-color:#fd8103;"></a>
</div>
<div>
<a href="Info.jsp" target="rightdown"><input type="button" value="发消息" style=" background-color:#fd8103;"></a>
</div>
<%-- <div>
<a href=<%=(cont.equals("0"))? "SelectEmail.jsp":"ShowDefaultEmail"%>  target="rightdown"><input type="button" value="<%=emfo %>" style=" background-color:#fd8103;"></a>
</div> --%>
<div>
<a href="AddEmail.jsp" target="rightdown"><input type="button" value="发邮件" style=" background-color:#fd8103;"></a>
</div>


<% Object p = session.getAttribute("pri");
Object i= session.getAttribute("id");
System.out.println("id"+i);
  String code= p.toString();
  if(code != null&& code.equals("1")){%>
  <div>
  <a href="Notice.jsp" target="rightdown"><input type="button" value="公告栏" style=" background-color:#fd8103;"></a>
  </div>
  <div>
  <a href="Personnel/AddUser.jsp" target="rightdown"><input type="button" value="员工登记" style=" background-color:#fd8103;"></a>
  </div>
<div>
  <a hreF="Work.jsp" target="rightdown"><input type="button" value="员工信息维护" style=" background-color:#fd8103;"></a>
  </div>
  <!-- <div>
  <a hreF="" target="rightdown"><input type="button" value="安排工作" style=" background-color:#fd8103;"></a>
  </div> -->
  <%}else if(code!=null&&code.equals("2")){
		  %>
		  <div>
		  <a href="Personnel/AddUser.jsp" target="rightdown"><input type="button" value="员工登记" style=" background-color:#fd8103;"></a>
		  </div>
		    <div>
		  <a href="Work.jsp" target="rightdown"><input type="button" value="员工信息维护" style=" background-color:#fd8103;"></a>
		  </div>
		  <a></a>
		  
		  <%}else if(code!=null&&code.equals("3")){
		  %>
		 
		  
		   <%
	  }
	
	
	%>
<div>
</div>
<br>
<br>
<br>
<br>
<br>
<font>注销：</font>
<div>
<a href="Login.jsp" target="_top"><img src="resource/102.png"width="38" height="38"></a>
</div>
<br>
<font>刷新：</font>
<div>
<a href="SelectUserFrameset.jsp" target="_top"><img src="resource/106.png"width="38" height="38"></a>
</div>
</body>
</html>