<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Filter 테스트 페이지</title>
</head>
<body>
	<form method="post" action="<%= request.getContextPath()%>/FilterEncodingTestServlet.do">
		이름 : <input type="text" name="userName"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>