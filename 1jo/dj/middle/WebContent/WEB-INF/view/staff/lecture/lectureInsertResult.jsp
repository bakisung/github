<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	<%
	 if(request.getAttribute("result") != null){
		 int result = (int)request.getAttribute("result");
		 if(result != 0){
	%>
		alert("작업이 성공적으로 완료되었습니다.");
		location.href="<%=request.getContextPath()%>/lecture/lectureManaging.do";
	<%
		 }else{
	%>
		alert("작업에 실패하였습니다.");
		location.href="<%=request.getContextPath()%>/lecture/lectureInsertForm.do";
	<%
		 }
	 }
	%>
</script>