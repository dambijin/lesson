<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>request3</h1>
<%
    request.setAttribute("name","진태쨩");
    request.setAttribute("address","두정역");
    response.sendRedirect("request2.jsp");
%>

</body>
</html>