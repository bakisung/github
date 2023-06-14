<%@page import="javax.tools.DocumentationTool.Location"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DW University</title>
</head>
<body>
	<h1>메인페이지 입니다. mainPage.jsp</h1>
	
	<% 
		String userId = (String) session.getAttribute("userId");
		String userPassword = (String) session.getAttribute("userPassword");
	
		if (userId != null && userPassword != null && userId.equals("dongju") && userPassword.equals("1004")) {
	%>	
			<script type="text/javascript">
				alert("로그인에 성공하였습니다.\n메인 페이지로 이동합니다.");
			</script>
	<%
		} else {
	%>
			<script type="text/javascript">
				alert("로그인에 실패하였습니다.\n이전 페이지로 돌아갑니다.");
				history.go(-1);
			</script>
	<%
		}
	%>	
</body>
</html>