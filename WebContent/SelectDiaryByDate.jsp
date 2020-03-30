<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js">
</script>
<body>
<form action="SelectDiaryByDate" method="post">
<div style="position:absolute;margin-top:160px;">
<input type="text" name="i_date" placeholder ="日历--请选择" style="background-color: #eb396; border-color: #f00cf;"onfocus="WdatePicker()"/>
 <br>
 <br>
 <input id="sub" type="submit"  value="查询" >
	   </div> 
	   
	    
	 <div>
<a href="ee.jsp"><input type="button" value="回到主页"></a>
</div>
	<div>
	     <input type="button"name="btn"value="返回上一页"onclick="history.go(-1)">
	 </div>
</form>
</body>
</html>