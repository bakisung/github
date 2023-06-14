<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie 연습</title>
</head>
<body>
	<!-- 
		세션은 서버에 정보 저장, 쿠키는 클라이언트쪽에 저장
		쿠키 사용시 단점 : 클라이언트쪽에 저장. 문자열만 저장할 수 있음.(암호화는 가능) ==> 해킹에 노출될 가능성이 있다.
		세션 사용시 장점 : 문자열뿐만 아니라 모든 데이터를 저장할 수 있다. 서버에 저장하기 때문에 쿠키를 사용하는 것보다 안전하다.
	 -->
	 
	 <%
	 	Cookie[] cookies = request.getCookies();
	 	for(Cookie c : cookies){
	 %>
 		쿠키 변수 : <%= c.getName()%><br>
 		쿠키 값 : <%= URLDecoder.decode(c.getValue(), "utf-8") %><hr>
 	 <%
	 	}
 	 %>	
	 
	 <!-- getContextPath : /servlet01 -->
	 <a href="<%=request.getContextPath() %>/CookieAddServlet.do">Cookie 정보 저장하기</a><br>
	 <a href="<%=request.getContextPath() %>/CookieReadServlet.do">저장된 Cookie 정보 확인하기</a><br>
	 <a href="<%=request.getContextPath() %>/CookieDeleteServlet.do">저장된 Cookie 정보 삭제하기</a><br>
</body>
</html>