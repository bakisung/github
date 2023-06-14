<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DW University</title>
</head>
<style>
	#div1 {
		position: relative;
		left: 37%;
		top: 200px;
	}
	
	#div2 {
		position: relative;
		left: 46%;
		top: 250px;
	}
</style>
<body>
	<div id="div1">
		<h1>로그인 페이지 입니다. index.jsp</h1>
	</div>
	
	<div id="div2">
		<form method="post" action="<%=request.getContextPath() %>/LoginServlet.do">
			<input type="text" name="id" width="500px" placeholder="관리자 아이디"><br><br>
			<input type="password" name="password" width="500px" placeholder="관리자 비밀번호"><br><br>
			<input type="submit" value="로그인">
			<input type="button" value="비밀번호 찾기"><br><br>
		</form>
	</div>
<script>
	location.href="<%=request.getContextPath()%>/member/memberList.do";
</script>
</body>
</html>