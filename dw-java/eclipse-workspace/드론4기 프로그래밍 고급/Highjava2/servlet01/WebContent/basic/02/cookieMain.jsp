<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie 로그인 성공 페이지</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
	%>
	<h2>Cookie 연습용 main 페이지 입니다.</h2>
	<h3><%=id %>님 환영합니다!!</h3>
	<hr>
	<a href="<%= request.getContextPath()%>/basic/02/cookieLogin.jsp">로그인 페이지로 이동</a>
</body>
</html>