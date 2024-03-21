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
<c:set var="id" value="hong"/>
<c:set var="age" value="23"/>

<c:if test="${id =='hong' }">
${id }님 안녕하세요 <br>
</c:if>

<c:if test="${(id eq'hong') and(age eq 23) }">
${id }님 나이는 ${age }입니다.<br>
</c:if>

<%-- <c:if test='${age > 20 }'> --%>
<c:if test='${age gt 20 }'>
age가 20보다 큽니당<br>
</c:if>

${'acaa'>'abzz' } : 앞 글자부터 하나씩 비교<br>
${'aa'<'aaa'} <br>

<hr>
c:else가 없다


</body>
</html>