<%@page import="oAbangong.mvc.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<% String id = session.getAttribute("id").toString();
User u = new User(id); 
u = u.queryUserById();%>
<body>
<form action="UpdateSelf" method="post">

<p>
<font>姓名</font><input type="text" name="name" value="<%=u.getName()%>">
</p>
<p>
<font>手机号码</font> <input type="text" name="tel" onblur="check()" value="<%=u.getTel()%>" >
        
</p>
<p>
<font>工作状态</font>  <div class="row">
        <input type="radio" name="status" value="正常" checked="checked">正常 <br>
		<input type="radio" name="status" value="休假" >休假
		<input type="radio" name="status" value="出差">出差  <br>
		</div>
</p>
<div><input type="submit" value="修改"></div>
</form>
<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>
</body>
<script type="text/javascript">

function check()
{
if (isNaN(window.document.test.phone.value))
{
	alert("号码必须为数字");
return false;
}
if (window.document.test.phone.value.length != 11)
{
alert("长度必须为11位")
return false;
}
return true;
}

</SCRIPT>

</html>