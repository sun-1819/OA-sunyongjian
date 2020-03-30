<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>


<div id="11">

<input type="button" onclick="niubi()">
</div>


</body>
<script type="text/javascript">

function niubi(){
	
	var  r = new XMLHttpRequest();
	
	r.onreadystatechange = function(){
		
		if(r.readyState == 4){
			
			var data = r.responseText;
			alert(data);
		}
		
	}
	r.open("get","AddDiary",true);
	r.send(null)
}


</script>
</html>