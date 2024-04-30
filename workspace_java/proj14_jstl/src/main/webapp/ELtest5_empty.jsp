<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="m2" class="java.util.ArrayList" scope="page"></jsp:useBean>

m2(ArrayList)를 생성 : null은 아니고 size()==0인 상태<br>
\${empty m2 }:${empty m2 }<br> <!-- 비어있어서 true -->

<%
	m2.add(1);
%>
\${empty m2 }:${empty m2 }<br> <!-- false -->

<hr>
출력할 내용이 있으면 empty는 false<br>
출력할 내용이 없으면 true<br>
\${empty "글씨" }:${empty "글씨" }<br>
\${empty null }:${empty null }<br>
\${empty "" }:${empty "" }<br>

<hr>
<!-- EL은 null일때 아무것도 안나온다 -->
\${null } : 123${null }456

<br>
<%="abcdsdfa".isEmpty()%>
<br>
<%="abcdsdfa".isBlank()%>
<br>
<%=m2.isEmpty() %>


</body>
</html>