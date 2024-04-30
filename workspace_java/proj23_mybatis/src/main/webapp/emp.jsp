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
ename : ${ename }<br>
	<table>
		<thead>
			<tr>
				<th>empno</th>
				<th>ename</th>
				<th>deptno</th>
			</tr>
		</thead>
		<tbody>
			<!-- 비어있지 않은 list라면 -->
			<c:if test="${not empty list }">
				<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.empno }</td>
					<td>${dto.ename }</td>
					<td>${dto.deptno }</td>
				</tr>
			</c:forEach>
			</c:if>	
			<c:if test="${empty list }">
				<tr>
					<td colspan="3">조회할 내용이 없습니다.</td>
				</tr>
			</c:if>
		</tbody>
	</table>

</body>
</html>