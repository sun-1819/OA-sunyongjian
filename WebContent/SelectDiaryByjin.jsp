<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="SelectDiaryByjin" method="post">
<div>
<font size="29px">日志主题</font><input type ="text" name = tittle>
</div>
<div class="row">
    <font size="29px">  权限</font>  <input type="radio" name="pri" value="1" checked="checked">仅自己可见 <br>
		<input type="radio" name="pri" value="2" >经理可见
		<input type="radio" name="pri" value="3">所有人可见  <br>
		</div>
		<div class="row">
		<input type="submit" value="查询">
</div>

</form>

</body>
</html>