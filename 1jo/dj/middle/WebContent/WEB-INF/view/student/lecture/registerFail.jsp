<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("수강정원이 다 찼습니다.");
	location.href="<%=request.getContextPath()%>/lecture/lectureRegisterForm.do";
</script>