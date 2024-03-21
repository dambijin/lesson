<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="sec01.ex01.MemberBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>member6.jsp</h1>
<%
	System.out.println("useBean 실행전");
// 	MemberBean m2 = new MemberBean();
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="request"></jsp:useBean>
<%
	System.out.println("useBean 실행후");
%>
<jsp:setProperty name="m" property="*"></jsp:setProperty>
<hr>
<jsp:getProperty name="m" property="id"></jsp:getProperty>
<hr>
<%
	// useBean이 하는 일 1번
	// java 변수 선언
	out.println(m.getId());
%>
<hr>
<%
	// useBean이 하는 일 2번
	// scope영역에 setAttribute해준다
	sec01.ex01.MemberBean m2 = (sec01.ex01.MemberBean) request.getAttribute("m");
	out.println(m2.getId());
%>
</body>
</html>