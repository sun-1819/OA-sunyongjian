<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/css.css">
</head>
<body>

	<div align="center">请输入注册信息<form name="form1" method="post"action="ChangePassword">
		
				<%String n ="";
				String ccv = request.getParameter("ccv");
				if(ccv != null){
				n="您输入的原始密码错误";}%> <span class="error"><%=n %></span>
			
		<table border="0"align="center">
		<tr>
		 <td>请输入您的旧密码：</td>
		 <td><input type="password"name="password0"></td>
		</tr>
		<tr>
		 <td height="12">请输入您的新密码：</td>
		 <td height="12"><input id="password" type="password"name="password"></td>
		</tr>
		<tr>
		 <td height="12">请再次输入您的密码：</td>
		 <td height="12"><input id="passwordConfirm" type="password" name="passwordConfirm"></td>
		</tr>
		
		
	<tr>
	 <td>
	   <div align="right">
	     <input id="sub" type="button" name="Submit" value="确认修改" >
	   </div> 
	 </td>
	 <td>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </td>
	</tr>
</table>
</form>
</div>
<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	
</body>
<script >
(function(){
	var sub = document.getElementById("sub");
	//初始化移入移出事件
	if(sub.addEventListener){
		sub.addEventListener("click", test);	
	}else if(sub.attachEvent){
		sub.attachEvent("onClick", test);
	}
})();
function test(){
	var password = document.getElementById("password");
	var passwordConfirm = document.getElementById("passwordConfirm");
	if(password.value != passwordConfirm.value)
		alert("对不起，您2次输入的密码不一致");
	else
	document.forms[0].submit();
	
}
</script>

</html>