<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("권한이 업슴다!");
	if (window.opener) {
		window.close();
	}else{
		history.go(-1);
	}
</script>