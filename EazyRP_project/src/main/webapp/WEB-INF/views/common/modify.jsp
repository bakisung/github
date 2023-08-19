<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	alert('수정이 완료되었습니다.');
	location.href = "<%=request.getContextPath()%>/member/qna.do?mcode=${mcode }"
</script>