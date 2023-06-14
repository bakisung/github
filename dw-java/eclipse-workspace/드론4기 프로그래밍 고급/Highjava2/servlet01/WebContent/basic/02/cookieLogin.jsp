<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie Login 테스트</title>
</head>
<body>
	<%
		String rememberId = "";	// 쿠키에 들어있는 ID가 저장될 변수
		String rememberChk = "";
		Cookie[] cookies = request.getCookies();
		if(cookies.length > 0 && cookies != null){
			for(int i = 0; i < cookies.length; i++){
				if(cookies[i].getName().equals("id")){
					rememberId = cookies[i].getValue();
					rememberChk = "checked";
				}
			}
		}
	%>

	<form method="post" action="<%=request.getContextPath()%>/CookieLogin.do">
		<table>
			<tr>
				<td>ID : </td>
				<td>
					<input type="text" name="id" value="<%= rememberId %>">
					<input type="checkbox" name="chkId" value="ok" <%= rememberChk %>>ID 저장
				</td>
			</tr>
			
			<tr>
				<td>PASSWORD : </td>
				<td>
					<input type="password" name="pwd">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align:center;">
					<input type="submit" value="로그인">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>