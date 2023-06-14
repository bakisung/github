<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
<%
	int result = (int)request.getAttribute("result");
	if(result == 1) {
%>
		alert("환영합니다.");
		location.href = "<%=request.getContextPath()%>/student/main.do";
<%
	}else {
%>
		alert("아이디 혹은 비밀번호가 일치하지 않습니다.");
		history.go(-1);
<%
	}
%>
</script>
