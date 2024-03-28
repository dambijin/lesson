<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>emp 목록</h1>
<hr>

<table>
	<thead>
		<tr>
			<th>사원번호</th>
			<th>이름</th>
			<th>선배</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${list }">
		<tr>
			<td>1234</td>
			<td>스캇</td>
			<td>234</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>