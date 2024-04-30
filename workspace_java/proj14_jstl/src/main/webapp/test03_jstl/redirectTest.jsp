<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
진태쨩 진태쨩 진태쨩 진태쨩 진태쨩 
<c:redirect url="member5_choose.jsp?name=abcd">
	<c:param name="name" value="이름"/>
</c:redirect>


<!-- 두개 적어도 오류는 안남 -->
<%-- <c:redirect url="member5_choose.jsp?name=이름" /> --%>
</body>
</html>