<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세번째 Servlet 입니다.</title>
</head>
<body>
	<h1>Servlet 요청 연습</h1>
	<hr>
	
	<h2>GET방식 요청1 ==> 링크 방식</h2>
	<a href="http://localhost:8080/servlet01/ServletTest03.do">Get 방식 요청1</a>
	<hr>
	
	<h2>
		GET방식 요청2 ==> form의 submit 방식<br>
		==> form태그의 method 속성을 생략하거나 'get'으로 설정한 경우
	</h2>
	<form action="http://localhost:8080/servlet01/ServletTest03.do" method="get">
		<input type="submit" value="GET방식 요청2">
	</form>
	<hr>
	
	<h2>
		POST방식 요청2 ==> form의 submit 방식<br>
		==> form태그의 method 속성을 'post'로 설정한 경우
	</h2>
	<form action="http://localhost:8080/servlet01/ServletTest03.do" method="post">
		<input type="submit" value="POST 방식 요청">
	</form>
	<hr>
</body>
</html>