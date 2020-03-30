<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<div id="thisDiv" style="margin-bottom:10px;text-align:center;border:3px solid #95f900;height:170px; width=100%;" >

<input type ="button" value="复制" style="margin-top:139px;"onclick ="exeCopy()">
<input type ="button" value="删除" style="margin-top:139px;"onclick ="exeDelt()">
</div>

<script type="text/javascript">
var i = 1;
function exeCopy(){
	
	
	var sourseNode = document.getElementById("thisDiv");
	var cloneNode = sourseNode.cloneNode(true);
	cloneNode.setAttribute("id","thisDiv"+i);
	sourseNode.parentNode.appendChild(cloneNode);
	i++;
}
function exeDelt(){
	var sourseNode = document.getElementById("thisDiv");
	i--;
var idd = "thisDiv" +i

var e = document.getElementById(idd);
sourseNode.parentNode.removeChild(e);


}

</script>
</body>
</html>