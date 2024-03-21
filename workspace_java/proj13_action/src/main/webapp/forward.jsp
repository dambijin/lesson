<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- image.jsp에서 include1.jsp를 거쳐 여기서 forward방식으로 받음 -->
	
<!-- 	<h1>내가 보이나요?</h1>가 보이지 않는 것은 얘를 안보여주기 때문, include1.jsp 페이지를 보여주기 때문인데
		주소창에는 forward방식이라 forward라고 주소창에 뜸 -->
	
	<h1>내가 보이나요?</h1>
	
	
	<jsp:forward page="include1.jsp"></jsp:forward>
</body>
</html>