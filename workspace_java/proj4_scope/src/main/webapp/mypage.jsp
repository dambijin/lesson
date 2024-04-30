<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    // 키가 없으면 null반환
    // Boolean : null을 포함할 수 있는 불리언
    Boolean isLogon = (Boolean)session.getAttribute("isLogon");
    if(isLogon == null || !isLogon){
    	// 로그인이 안되었다면 cookieTest.jsp로 이동
    	response.sendRedirect("cookieTest.jsp");
    	
    	// http://localhost:8080/proj4_scope/session?id=admin
    	//	여기 주소갔다가
    	//	http://localhost:8080/proj4_scope/mypage.jsp
    	//	여기 가면 body내용이 보임
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 이 글 보고싶으면
http://localhost:8080/proj4_scope/session?id=admin
여기 주소갔다가
http://localhost:8080/proj4_scope/mypage.jsp
여기 가면 아래 정보들이 보임
 -->
내 신상 정보, 민감한 정보 표시 되는 중.... 
</body>
</html>