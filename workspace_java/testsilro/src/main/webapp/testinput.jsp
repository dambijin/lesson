<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@font-face {
    font-family: 'KNUTRUTHTTF';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2312-1@1.1/KNUTRUTHTTF.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
textarea{
	font-family: 'KNUTRUTHTTF';
	width : 500px;
	height : 300px;
	font-size : 20px;
}

.btn{
	font-family: 'KNUTRUTHTTF';
	font-size : 16px;
}
</style>
</head>
<body>
<form method="post" action="test0324">
<textarea name="tarea">
<%List<Map<String, String>> select= (List<Map<String, String>>)request.getAttribute("select");%>
<%=select.get(0).get("TEXTAREA")%>
</textarea>
<input type="submit" value="저장" class="btn">
</form>
</body>
</html>