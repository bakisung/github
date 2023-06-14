<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패 화면</title>
</head>
<body>
<script>
	alert("아이디 혹은 비밀번호가 틀렸습니다.\n다시 입력해주세요.");
	//history.go(-1);
	location.href="loginCheck.jsp";
</script>
</body>
</html>