<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.List" %>
   <%@ page import="sec01.ex01.jdbc.part.EmpDTO" %>
   <%@ page import="java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실습1</title>
<style>
.tbst td, 
.signup td,
.insertemp td{
border : 1px solid black;
text-align:center;
padding: 5px;

}
.tbst table,
.signup table,
.insertemp table {
border-collapse: collapse;
}

</style>
</head>

<body>
<% List emp=(List) request.getAttribute("emp"); %>
<div class="tbst">
<table>
	<tr>
		<td>사원번호</td>
		<td>사원명</td>
		<td>연봉</td>
		<td>삭제</td>
		<td>조회</td>
		<td>사원번호변경</td>
		<td>이름변경</td>
	</tr>
<!-- 	서블릿에 있는 for문 이식완료 -->
	<% for(int i=0; i<emp.size(); i++){ 
	EmpDTO empDTO = (EmpDTO) emp.get(i);
	int empno = empDTO.getEmpno();
	String ename = empDTO.getEname();
	String job = empDTO.getJob();
	int mgr = empDTO.getMgr();
	Date hiredate = empDTO.getHiredate();	
	int sal = empDTO.getSal();
	int comm= empDTO.getComm();
	int deptno= empDTO.getDeptno();%>
	<tr>	
		<td><%=empno%></td>
		<td><%=ename%></td>
		<td><%=sal%></td>
		<td><button>삭제</button></td>
		<td><button value="<%=empno%>" name="insert_empno" id="in_empno">조회</button></td>
		<td><input type="text"><button>변경</button></td>
		<td><input type="text"><button>변경</button></td>
	</tr>
	<%} %>
</table>
</div>
<br>
<hr>
<br>
<div class="insertemp">
조회내용
<table>
	<tr>
		<td>사원번호</td>
		<td>이름</td>
		<td>직업</td>
		<td>직속선배</td>
		<td>고용날짜</td>
		<td>연봉</td>
		<td>comm</td>
		<td>부서번호</td>
	</tr>
	<tr>
		<td id="inse_empno"></td>
		<td id="inse_ename"></td>
		<td id="inse_job"></td>
		<td id="inse_mgr"></td>
		<td id="inse_hiredate"></td>
		<td id="inse_sal"></td>
		<td id="inse_comm"></td>
		<td id="inse_deptno"></td>
	</tr>
</table>
</div>
<br>
<hr>
<br>
<div class="signup">
<table>
	<tr>
		<td>사원번호</td>
		<td>사원명</td>
		<td>직업</td>
		<td>MGR</td>
		<td>입사날짜</td>
		<td>연봉</td>
		<td>COMM</td>
		<td>DEPTNO</td>
	</tr>
	
	<tr>
		<td><input type="text"></td>
		<td><input type="text"></td>
		<td><input type="text"></td>
		<td><input type="text"></td>
		<td><input type="text"></td>
		<td><input type="text"></td>
		<td><input type="text"></td>
		<td><input type="text"></td>
	</tr>
</table>
<button>추가</button>
</div>

<script>
<% List empinsert=(List) request.getAttribute("empinsert"); 
for(int i=0; i<empinsert.size(); i++){ 
	EmpDTO empDTO = (EmpDTO) empinsert.get(i);
	int empno = empDTO.getEmpno();
	String ename = empDTO.getEname();
	String job = empDTO.getJob();
	int mgr = empDTO.getMgr();
	Date hiredate = empDTO.getHiredate();	
	int sal = empDTO.getSal();
	int comm= empDTO.getComm();
	int deptno= empDTO.getDeptno();
%>

document.querySelector("#in_empno").addEventListener("click", function(event){
		let in_empno=document.querySelector("#in_empno").value;
		
		let inse_empno=document.querySelector("#inse_empno").value;
		let inse_ename=document.querySelector("#inse_ename").value;
		let inse_job=document.querySelector("#inse_job").value;
		let inse_mgr=document.querySelector("#inse_mgr").value;
		let inse_hiredate=document.querySelector("#inse_hiredate").value;
		let inse_sal=document.querySelector("#inse_sal").value;
		let inse_comm=document.querySelector("#inse_comm").value;
		let inse_deptno=document.querySelector("#inse_deptno").value;
		
		
		inse_empno=<%=empno%>;
		
		
				
		})
			
<%}
%>
</script>
</body>
</html>