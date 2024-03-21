<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>표현 언어로 여러가지 데이터 출력하기</h1>
\${100 }: ${100 } <br>
\${"안녕하세요" }: ${"안녕하세요" } <br>
\${10+1}: ${10+1} <br>
\${"10"+1}: ${"10"+1} <br>
<%-- \${null+10}: ${null+10}<br> --%>
<%-- \${"안녕"+11}: ${"안녕"+11}<br> --%>
<%-- \${"hello"+"world"}: ${"hello"+"world"}<br> --%>

<!-- div : 나누기 -->
\${100 div 9 }: ${100 div 9 } <br>
<!-- mod : 나머지 -->
\${100 mod 9 }: ${100 mod 9 } <br>
<hr>
<h1>여러가지 비교연산자</h1>
\${10 == 10 }: ${10 == 10 } <br>
\${10 eq 10 }: ${10 eq 10 } <br><br>

\${"hello" == "hello" }: ${"hello" == "hello" } <br>
\${"hello" eq "hello" }: ${"hello" eq "hello" } <br><br>

\${20 != 10 }: ${20 != 10 }<br>
\${20 ne 10 }: ${20 ne 10 }<br><br>

\${"hello" != "apple" }: ${"hello" != "apple" }<br>
\${"hello" ne "apple" }: ${"hello" ne "apple" }<br><br>

\${10 < 10 }: ${10 < 10 } <br>
\${10 lt 10 }: ${10 lt 10 } <br><br>

\${100 > 10 }: ${100 > 10 } <br>
\${100 gt 10 }: ${100 gt 10 } <br><br>

\${100 <= 10 }: ${100 <= 10 } <br>
\${100 le 10 }: ${100 le 10 } <br><br>

\${100 >= 10 }: ${100 >= 10 } <br>
\${100 ge 10 }: ${100 ge 10 } <br><br>
<hr>
<h1>여러가지 논리연산자</h1>
<!-- 연산자 양쪽 값이 true면 ture반환 -->
\${(10==10) && (20==20) }: ${(10==10) && (20==20) } <br>
\${(10==10) and (20!=20) }: ${(10==10) and (20!=20) } <br><br>

<!-- 연산자 양쪽 값 중 하나라도 true면 ture반환 -->
\${(10==10) || (20!=30) }: ${(10==10) || (20!=30) } <br>
\${(10!=10) or (20==20) }: ${(10!=10) or (20==20) } <br><br>

<!-- 비교 연산자의 결과값이 false여서 true출력 -->
\${!(20==10) }: ${!(20==10) } <br>
\${not(20==10) }: ${not(20==10) } <br><br>

<!-- 비교 연산자의 결과값이 true여서 false출력 -->
\${!(20!=10) }: ${!(20!=10) } <br>
\${not(20!=10) }: ${not(20!=10) } <br><br>
</body>
</html>