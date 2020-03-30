<%@page import="oAbangong.mvc.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%User u = (User)request.getAttribute("user"); 
String s = u.getRole();%>
<body>

<form action="UpdateUserServlet" method="post">
     <div class="row1">
     <img src="resource/${user.picture}" width="80px">
     </div>
		<div class="row1">
			账号<input type="text" name="id" value="${user.id}" readonly="readonly">
		</div>
		<!-- name| type | amout | author   | concern| price | stock | remark | bookcode -->
		<div class="row1">
			员工姓名<input type="text" name="name" value="${user.name}">
		</div>
		<div class="row1">
			身份证号码<input type="text" name="id_card" value="${user.id_card}">
		</div>
		<div class="row1">
			手机号码<input type="text" name="tel"  value="${user.tel}" onblur="check()">
		</div>
		
		<div class="row1">
		职位
        <input type="radio" name="role" value="普通员工" <%=("普通员工" .equals(s)) ? "checked":"" %>>普通员工 <br>
		<input type="radio" name="role" value="人事管理员" <%= ("人事管理员" .equals(s)) ? "checked":"" %>>人事管理员
		<input type="radio" name="role" value="经理" <%=("经理" .equals(s)) ? "checked":"" %>>经理  <br>
		</div>
		
		
		<div class="row1">
			<input type="submit" value="修改信息">
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