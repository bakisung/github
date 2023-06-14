<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Main 페이지</title>
</head>
<body>
	<h2>Session 연습용 main 페이지입니다.</h2>
	회원 아이디 : <%= session.getAttribute("memId") %>
	<hr>
	<!-- form에서 method 값이 post가 아닌 모든것은 get방식 -->
	<a href="<%= request.getContextPath()%>/SessionLoginServlet.do">로그인</a>
</body>
</html>