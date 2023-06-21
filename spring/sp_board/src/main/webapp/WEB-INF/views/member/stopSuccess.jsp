<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if (${enabled} == "1") {
		alert("${id}님의 사용을 중지했습니다.");
	} else{
		alert("${id}님의 정지를 해제했삼.");
	}
		location.href="detail.do?id=${id}";
		window.opener.location.reload(true);
		window.close();
</script>