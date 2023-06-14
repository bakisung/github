<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 로그인 결과페이지</title>
</head>
<body>
	<!-- 
		로그인이 성공하면 ~~~님 반갑습니다.
		로그아웃 버튼을 누르면 ==> 로그아웃을 처리하고 main페이지로 이동
		
		로그인이 실패하면
		alert("로그인 실패");
		이전 페이지로 이동
	 -->
	 
	 <%
	 	// 세션값 읽기
	 	String memId = (String)session.getAttribute("memId");
	 
	 	if(memId == null) {	// 로그인 실패
	 %>
	 	<script>
	 		alert("로그인 실패");
	 		history.go(-1);
	 	</script>
	 <%
	 	}else{
	 %>
	 	<h3><%= memId %>님 환영합니다!!</h3>
	 	<a href="<%= request.getContextPath() %>/SessionLogoutServlet.do">로그아웃</a>
	 <%
	 	}
	 %>
</body>
</html>