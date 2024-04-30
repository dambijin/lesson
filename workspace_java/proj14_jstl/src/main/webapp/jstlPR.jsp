<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List, java.util.ArrayList, java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>깜짝 실습</title>

</head>
<body>
<%
ArrayList<Map<String, String>> select= (ArrayList<Map<String, String>>)request.getAttribute("emp2");
%>
<c:set var="emp2" value="<%=select %>"/>
	<table>
		<tr>
			<th>Empno</th>
			<th>Ename</th>
			<th>JOB</th>
			<th>MGR</th>
			<th>Hiredate</th>
			<th>Sal</th>
			<th>Comm</th>
			<th>Deptno</th>
		</tr>
		<c:forEach var="emp2" items="<%=select %>" begin="1">
		<tr>
			<td>${emp2.EMPNO }</td>
			<td>${emp2.ENAME }</td>
			<td>${emp2.JOB }</td>
			<td>${emp2.MGR }</td>
			<td>${emp2.HIREDATE }</td>
			<td>${emp2.SAL }</td>
			<td>${emp2.COMM }</td>
			<td>${emp2.DEPTNO}</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>