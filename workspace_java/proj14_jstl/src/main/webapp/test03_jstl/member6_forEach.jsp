<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List dataList = new ArrayList();
	dataList.add("진태1");
	dataList.add("진태2");
	dataList.add("진태3");
	dataList.add("진태4");
	dataList.add("진태5");
	dataList.add("진태6");
	dataList.add("진태7");
	dataList.add("진태8");
	dataList.add("진태9");
%>
dataList : <%=dataList %><br>
<c:set var="list" value="<%=dataList %>"/><br>
<br>
<hr>
<fieldset>
	<legend>진태 반복</legend>
	<div>
      <c:forEach var="i" begin="1" end="5">
         <strong> 진태i : </strong> 진태${i }<br>
      </c:forEach>
   </div>
</fieldset>
<hr>
step<br>
<c:forEach var="i" begin="1" end="10" step="4">
	<strong> 진태i : </strong> 진태 ${i }<br>
</c:forEach>


<hr>
varStatus<br>
<c:forEach var="i" begin="1" end="10" step="4" varStatus="loop">
	<strong> i값 : </strong> ${i }<br>
	loop.index : ${loop.index }<br>
	loop.count : ${loop.count }<br>
	loop.first : ${loop.first }<br>
	loop.last : ${loop.last }<br>
	<c:if test="${not loop.last }">,</c:if>
</c:forEach>

<hr>
dataList 모두 출력<br>
<c:forEach var="data" items="${list }">
	${data }<br>
</c:forEach>

<hr>
items와 begin, end같이 사용<br>
<c:forEach var="data" items="${list }" begin="2" end="5">
	${data }<br>
</c:forEach>

<hr>
end가 items의 개수보다 큰 경우<br>
<c:forEach var="data" items="${list }" begin="2" end="500">
	${data }<br>
</c:forEach>

<hr>
begin이 end보다 큰 경우<br>
<c:forEach var="data" items="${list }" begin="20" end="5">
	${data }<br>
</c:forEach>

<hr>
begin,end음수 안됨 : JspTagException<br>

<hr>
왜그런진 모르겠지만 var에 lsit써놓고 뭐가 뭔지 모르는 경우 있음<br>
<c:forEach var="data" items="${list }" begin="20" end="5">
	${data }<br>
</c:forEach>

</body>
</html>