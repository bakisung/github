<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 연습</title>
</head>
<body>
	<!-- JSP문서에서 세션은 'session' 이라는 이름으로 이미 저장되어 있다. -->
	<h2>Session 테스트 페이지 입니다.</h2>
	<hr>
<%-- 	<h2>testSession : <%= session.getAttribute("testSession") %></h2> --%>
<!-- 	<hr> -->
<%-- 	<h2>name : <%= session.getAttribute("userName") %></h2> --%>
<!-- 	<hr> -->
<%-- 	<h2>age : <%= session.getAttribute("age") %></h2> --%>
<!-- 	<hr> -->
	<a href="<%= request.getContextPath()%>/SessionAddServlet.do">Session 정보 저장하기</a><br><br>
	<a href="<%= request.getContextPath()%>/SessionReadServlet.do">저장된 Session 정보 확인하기</a><br><br>
	<a href="<%= request.getContextPath()%>/SessionDeleteServlet.do">저장된 Session 정보 삭제하기</a><br><br>
</body>
</html>