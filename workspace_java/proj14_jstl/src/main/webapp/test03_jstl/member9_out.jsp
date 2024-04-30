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
param.id : ${param.id }<br>
<c:out value="asdf" /> <br>


c:out을 안쓰면 마음대로 페이지를 바꿀 수 있음<br>
그래서 이러한걸 방지하려고 c:out을 사용하는 것<br>

특수문자를 치환해서 문자 그 자체로 출력되게 해줌<br>
<c:out value="${param.id }" /> <br>

<hr>
< : &lt;
> : &gt;
& : &amp;
' : &#039;
" : &#034;
" "(공백문자) : &nbsp;
. . . : . . .

</body>
</html>