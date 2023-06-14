<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 로그인 폼 페이지</title>
</head>
<body>
	<form method="post" action="<%= request.getContextPath()%>/SessionLoginServlet.do">
		<table>
			<tr>
				<td>ID : </td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>PASSWORD : </td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"></td>
				<td><input type="reset" value="초기화"></td>
			</tr>
		</table>
	</form>
</body>
</html>