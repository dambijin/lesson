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
		<td><button value="<%=empno%>" name="insert_empno" id="insert_empno">조회</button></td>
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
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
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
<% List empinsert=(List) request.getAttribute("empinsert"); %>
	document.querySelector("#insert_empno").addEventListener("click", function(event){
			doAjax();
		})
			
	function doAjax(){
		console.log("doAjax 실행")
		// ajax 객체 생성
		let chr = new XMLHttpRequest();
		// 보낼 준비
		xhr.open("get", "practice");
		// 보내기(단! 언제 끝날지 모름)
		xhr.send();
		
		// 다녀온 후 (응답 이후)
		chr.onload=function(){
			// 받아온 내용이 저장되는 곳
			let data=xhr.responseText;
			console.log(data);
			}		
		}
</script>
</body>
</html>