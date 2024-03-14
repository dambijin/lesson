<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
현재 잔액<br>
<%=request.getAttribute("getResult")%>입니다.
<br>
<form method="post" action="bank" id="dep">
	<input type="number" name="dps">
	<input type="submit" value="입금" id="deposit">
</form>
<br>
<form method="post" action="bank" id="pay">
<input type="number" name="pm">
<input type="submit" id="payment" value="출금">
</form>

<script>
// 입금 버튼 클릭

document.querySelector("#deposit").addEventListener("click", function(event){
	// event.preventDefault() : submit 막는거
	event.preventDefault();
	var dps = document.querySelector("input[name='dps']").value;
	let form =document.querySelector("#dep");
	if(dps == null || dps==""){
		alert("입금 금액을 입력하지 않았습니다.");
	}else{
		// ~~.submit() : submit보내는거
		form.submit();
	}
})

document.querySelector("#payment").addEventListener("click", function(event){
	event.preventDefault();
	let form =document.querySelector("#pay");
	var pay = document.querySelector("input[name='pm']").value;
	
	if(pay == null ||pay==""){
		alert("출금 금액을 입력하지 않았습니다.");
	} else{
		if(<%=request.getAttribute("getResult")%><pay){
			alert("예금 잔액보다 출금 금액이 큽니다.");
		}else{
			form.submit();
		}
		
	}
	
})

</script>
</body>
</html>