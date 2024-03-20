<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>request2</h1>
이름 : <%=request.getAttribute("name") %><br>
주소 : <%=request.getAttribute("address") %><br>
</body>
</html>