<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
<%
	int result = (int)request.getAttribute("passResult");
	int success = (int)request.getAttribute("passSuccess");
	String pass = (String)request.getAttribute("staffPass");
	if(result == 1 && success == 1) {
%>
		alert("비밀번호가 변경되었습니다.");
		location.href = "<%=request.getContextPath()%>/staff/staffPasswordUpdate.do?pwd=<%=pass%>";
<%
	}else {
%>
		alert("비밀번호가 일치하지 않습니다.");
		history.go(-1);
<%
	}
%>
</script>