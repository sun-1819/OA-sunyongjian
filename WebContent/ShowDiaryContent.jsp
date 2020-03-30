<%@page import="oAbangong.mvc.model.Diary"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/css.css">
</head>
<%String id = request.getParameter("id");
Diary d = new Diary();
d=d.queryByDiaryId(id);%>
<body>
<textarea rows="9" cols="20" class="rowgg" style="font-size:39px;">
<%=d.getContent() %>
</textarea>
</body>
</html>