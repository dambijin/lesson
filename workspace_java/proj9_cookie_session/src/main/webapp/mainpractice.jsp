<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("session")== null){
response.sendRedirect("prsession");
}else{%>
	메인페이지예요 뀨쀼뀨쀼
<%}%>


</body>
</html>