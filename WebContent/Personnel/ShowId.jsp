<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<font>恭喜您注册成功</font>
<font>请记住您的账号及初始密码</font>
  账号:<input type="text" placeholder=${idmap.get("id") } readonly>
  密码:<input type="text" placeholder=123456 readonly>
<font>请尽快修改您的初始密码</font>

<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>
</body>
</html>