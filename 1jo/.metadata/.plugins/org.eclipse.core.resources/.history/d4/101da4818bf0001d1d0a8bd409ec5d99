<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="heesung.Quartz" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login result</title>
</head>
<body>
	<%
		String memId = (String)session.getAttribute("memId");
	
		if(!memId.equals("dongju")) {
	%>
		<script>
			alert("설정된 아이디와 패스워드로만 로그인 됩니다.")
			history.go(-1);
		</script>
	<%
		} else {
	%>
			<h1> 동주 왔니? </h1>
	<%
		Quartz.main(null);
		}
	%>
	
	
</body>
</html>