<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/css.css">
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
html{
/*  background-image:url(resource/303.jpg); */ 
}
#wrap {
	height: 75%;
	width: 100;
	/*  background-image:url(resource/303.jpg);  */
	background-repeat: no-repeat;
	background-position: center center;
	position: relative;
}
#head {
	height: 46px;
	width: 100;
	background-color: #66CCCC;
	text-align: center;
	position: relative;
}
#wrap .logGet {
	height: 408px;
	width: 368px;  
	position: absolute;
	background-color: #FFFFFF;
	top: 20%;
	right: 15%;
}
.logC input {
	width: 100%;
	height: 45px;
	background-color: #ee7700;
	border: none;
	color: white;
	font-size: 18px;
}
 .logGet .logD.logDtip .p1 {
	display: inline-block;
	font-size: 30px;
	margin-top: 30px;
	width: 86%;
	 color: #f35626;
     background-image:-webkit-linear-gradient(92deg,#f35626,#feab3a);
    -webkit-animation: hue 27s infinite linear;
    -webkit-text-fill-color: transparent;
    -webkit-background-clip:text; 
} 
#wrap .logGet .logD.logDtip {
	width: 86%;
	border-bottom: 1px solid #ee7700;
	margin-bottom: 60px;
	margin-top: 0px;
	margin-right: auto;
	margin-left: auto;
}
.logGet .lgD img {
	position: absolute;
	top: 12px;
	left: 8px;
}
.logGet .lgD input {
	width: 100%;
	height: 42px;
	text-indent: 2.5rem;
}
#wrap .logGet .lgD {
	width: 86%;
	position: relative;
	margin-bottom: 30px;
	margin-top: 30px;
	margin-right: auto;
	margin-left: auto;
}
#wrap .logGet .logC {
	width: 86%;
	margin-top: 0px;
	margin-right: auto;
	margin-bottom: 0px;
	margin-left: auto;
}
 
 
.title {
	font-family: "宋体";
	color: #FFFFFF;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
	font-size: 36px;
	height: 40px;
	width: 30%;
}
 
.copyright {
	font-family: "宋体";
	/* color: #FFFFFF; */
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
	height: 60px;
	width: 40%;
	text-align:center;
}
	
 
.copyright .img .icon {
	display: inline-block;
	width: 24px;
	height: 24px;
	margin-left: 22px;
	vertical-align: middle;
/*  background-image: url(th:@{resource/303.jpg}); */
	background-repeat: no-repeat;
	vertical-align: middle;
	margin-right: 5px;
}
	
.copyright .img .icon1 {
	display: inline-block;
	width: 24px;
	height: 24px;
	margin-left: 22px;
	vertical-align: middle;
	/*  background-image: url(resource/303.jpg);  */
	background-repeat: no-repeat;
	vertical-align: middle;
	margin-right: 5px;
}
.copyright .img .icon2 {
	display: inline-block;
	width: 24px;
	height: 24px;
	margin-left: 22px;
	vertical-align: middle;
	 /* background-image: url(resource/303.jpg); */
	background-repeat: no-repeat; 
	vertical-align: middle;
	margin-right: 5px;
}
</style>
</head>
 
<body style="overflow:hidden;background-image:url(resource/303.jpg);background-size:1390px 580px;">
<div class="header" id="head">
  <div class="title">孙总监的OA办公系统</div>
	
</div>
	
<div class="wrap" id="wrap">
	<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1" >请登录</p>
			</div>
			<!-- 输入框 -->
			<div>
<div>
<form action="DiffUsersServlet" method="post">
<c:choose>
			<c:when test="${param.code != null }">
				<span class="error">用户名或者密码错误</span>
			</c:when>
			
		</c:choose>
			<div class="lgD">
				<img src="resource/16.png" width="20" height="20" />
				<input type="text"
					placeholder="输入账号"  name="id" id="userAccount" />
				<span ></span>
			</div>
			<div class="lgD">
				<img src="resource/101.png" width="20" height="20" />
				<input type="password"
					placeholder="输入用户密码" name="password" id="userPwd"/>
					<span ></span>
			</div>
			<div class="logC">
				<input type="submit" id="loginButton" value="登录">
			</div>
</form>
		</div>
</div>
</div>
<!-- </head>
<body> -->
<%-- <div>
<form action="DiffUsersServlet" method="post">
<c:choose>
			<c:when test="${param.code != null }">
				<span class="error">用户名或者密码错误</span>
			</c:when>
			
		</c:choose>
<p><input type="text" name="id" placeholder="账号"></p>
<p><input type="password" name="password" placeholder="密码"></p> --%>
<!-- <div class="logC">
<input type="submit" id="loginButton" value="登录"> -->


</div>

</body>

</html>