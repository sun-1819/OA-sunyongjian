<%@page import="org.apache.catalina.core.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
        request.setCharacterEncoding("UTF-8");          // 设置编码防止中文出现乱码
        String info = request.getParameter("content");  // 获取表单内容
    	// 表单提交到本身页面必须进行null判断
        info = (info == null)? "" : "!!!公告:"+info; 
        // 判断内容是否为空
        application.setAttribute("info", info);
    %>
 
   
 
    <%-- 表单提交到本身页面 --%>
    <form action="Notice.jsp" method="POST">
        <label for="conteny">请输入公告信息：</label>
        <input type="text" id="conteny" name="content" />
        <input type="submit" value="发布" />
        
    </form>
<div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>
</body>
</html>