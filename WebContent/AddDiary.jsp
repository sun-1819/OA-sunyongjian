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
<form action="AddDiary" method="post">
<div class="row">
<input type="text" name="name" placeholder="日志标题">
</div>
<div class="row">
<textarea rows="9" cols="20" class="rowgg" style="font-size:39px;" name="content" placeholder="内容："></textarea>
</div>
<div class="row">
<div class="row">
      权限  <input type="radio" name="role" value="1" checked="checked">仅自己可见 <br>
		<input type="radio" name="role" value="2" >经理可见
		<input type="radio" name="role" value="3">所有人可见  <br>
		</div>
</div>
<div class="row">
		<input type="submit" value="上传日志" >
         </div>
</form>
<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>

</body>
</html>