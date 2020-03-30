<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=
">
<title>Insert title here</title>
</head>
<body><% 
  String code= request.getParameter("code");
  if(code==null){%>
<a href="SelectUserServlet" target="rightdown">全体用户查询</a>
<a href="Work.jsp?code=1" target="rightdown">按信息查询</a>
<%}else if(code!=null&&code.equals("1")){
		  %>
		  <form action="SelectUserServlet" method="post">
		  <div class="row">                     
                                 账号<input type="text" name="id"  > 
          </div>
		<div class="row">                     
                                  员工姓名<input type="text" name="name"  > 
          </div>
          <div class="row">                     
                             员工性别 <input type="radio" name="sex" value="男" checked>男 <br>
		<input type="radio" name="sex" value="女" >女
          </div>
        <div class="row">
                         身份证信息<input type="text" name="id_card" >
        </div>
		<div class="row">
                       手机号码<input type="text" name="tel" >  
        </div>
        <div class="row">
        <input type="radio" name="role" value="普通员工">普通员工 <br>
		<input type="radio" name="role" value="人事管理员" >人事管理员
		<input type="radio" name="role" value="经理">经理  <br>
		</div>
		<div class="row">
		 操作人账号<input type="text" name="playerid" >
		</div>
		<div class="row">
		<input type="submit" value="上传" >
         </div> 
         </form> 
	  <%
	  }
	
	
	%>
	<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>
</body>
</html>