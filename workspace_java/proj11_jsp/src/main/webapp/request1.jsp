<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>request1</h1>
   <%
    request.setAttribute("name","진태쨩");
    request.setAttribute("address","두정역");
    
	request.getRequestDispatcher("request2.jsp").forward(request,response);
%>
</body>
</html>