<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<form method="post" action="upload.pr" enctype="multipart/form-data"
    accept-charset="utf-8">
    <table>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="user_id"></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="user_pw"></td>
        </tr>
        <tr>
            <td>프로필사진</td>
            <td><input type="file" name="img_file" accept=".jpg, .png, .bmp"></td>
        </tr>
    </table>
    <input type="submit" value="회원가입">
</form>
<script>
    document.querySelector("#btn1").addEventListener("click", function(){
        document.querySelector("#file1").click();
    });
</script>

</body>
</html>