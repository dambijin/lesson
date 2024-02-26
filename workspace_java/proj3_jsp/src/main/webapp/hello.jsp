<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.ArrayList"
    import="java.util.List"
    %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
int a = 10;

for(int i=0; i<3; i++){ %>
	<h1>Hello JSP</h1>
<% } %>

<%
	out.println("<h2>subject</h2>");
%>

<%!
	int b = 5;
	void test(){
		// 메소드
	}
%>

<!-- html주석 -->
<%-- JSP 주석--%>


	a : <% out.println(a); %><br>
	a : <%= a %><br>
	<!-- a : <%= a %><br> -->
	
<hr>
<%
	String id = request.getParameter("id");
%>
id : <input type="text" value="<%= id %>"><br>
</body>
</html>