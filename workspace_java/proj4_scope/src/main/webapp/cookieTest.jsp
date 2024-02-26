<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div.popup {
	border: 1px solid red;
	height: 200px;
	width: 100px;
	background-color: green;
	color: #fff
}
.hide {
	display : none;
}
</style>

</head>
<body>
<% int a=10;
String name="최민수";
%>
	<div class="popup">
		공지입니다. 아주아주 귀찮은 공지예요. <br> 
		<input type="checkbox" id="hidePopup"><%=a %>초 동안 열지 않기
	</div>
	
	<script>
		let time=<%=a %>;
		let name= "<%= name %>";
		console.log(document.cookie);
		
		if(document.cookie !=""){
			// k=v; k2=v2; k3=v3;
			let cookies=document.cookie.split(";"); // split : 문자로 잘라서 배열로 돌려줌
			for(let i=0; i<cookies.length; i++){
				let cookie=cookies[i].trim(); // trim : 앞뒤의 공백 제거
				let name=cookie.split("=")[0];
				let value= cookie.split("=")[1];
				
				if(name == "noShow" && value=="true"){
					// remove : 클래스 삭제
					document.querySelector(".popup").classList.add("hide");	// 클래스 추가	
					
					//* document.querySelector(".popup").style.display = "none" */
				}
			}
			
		}
		document.querySelector("#hidePopup").addEventListener("click", function(){
			if(this.checked){
				let now= new Date();
				let after_10s = now.getSeconds() +<%=a %>; //10초 뒤 시간
				now.setSeconds(after_10s); // after_10s로 현재 초를 재설정
				
				// key=value : 경로;만료일
				document.cookie = "noShow=true;path=/;expires="+now.toGMTString();
				
			}	
			// TODO: 체크해제시 쿠키 삭제
			// document.cookie = "쿠키내용" : 쿠키 추가
			// 쿠키를 삭제하는 경우에는
			// 만료일을 과거로 세팅한 쿠키를 추가
			
						
		})
	</script>
</body>
</html>