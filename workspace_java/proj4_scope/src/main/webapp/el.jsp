<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
context : ${application}<br>
session : ${session}<br>
request : [${request }]<br>
<hr>
members : ${members }<br>
members1 : ${members[0] }<br>
members1-ename : ${members[0].ename }<br>
members1-empno : ${members[0]["empno"] }<br>
\${ASDFASDFA }

<script>
let a= 10;
console.log("123");
console.log('asdfadsf');
console.log('\${a}');
</script>
</body>
</html>