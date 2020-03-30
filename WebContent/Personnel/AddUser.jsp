<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加用户</title>
<link rel="stylesheet" href="../Css/css.css">
</head>
<%String info="请添写用户信息";
String code= request.getParameter("code");
if(code!=null){
	  if(code.equals("1")){
		  info = "注意—必须填写用户信息";
	  }}%>
<body>
<font  class="rows"><%=info %></font>
<div class="big">
<form action="../AddUserServlet" method="post" name="test" enctype="multipart/form-data">
          <div class="row">                     
                                  用户名<input type="text" name="name"  required> 
          </div>
        <div class="row">
                         身份证信息<input type="text" name="id_card" required>
        </div>
		<div class="row">
                       手机号码<input type="text" name="phone" onblur="check()"  required oninvalid="setCustomValidity('请填写')" oninput="setCustomValidity('')">
        </div>
        <div class="row">
        <input type="radio" name="pri" value="普通员工" checked="checked">普通员工 <br>
		<input type="radio" name="pri" value="人事管理员" >人事管理员
		<input type="radio" name="pri" value="经理">经理  <br>
		</div>
		<div class="row">
		 用户头像<input type="file" name="picture" >
		</div>
		<div class="row">
		<input type="submit" value="注册" >
         </div>
         
</form>
</div>
<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>
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


</body>
</html>