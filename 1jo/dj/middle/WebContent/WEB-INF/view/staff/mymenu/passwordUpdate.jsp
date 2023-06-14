<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<title>초기 비밀번호 변경 페이지입니다.</title>
<script>
	$(function(){
		$('#resetBtn').on('click', function(){
			location.href = "<%=request.getContextPath()%>/staff/staffInfo.do";
		});
	})
</script>
</head>
<style>
	*, ::after, ::before {
    	box-sizing: border-box;
	}
    input + input {
		margin-left: 0.3em;
	}
	.btn-container {
        display: flex;
        justify-content: center;
    }
</style>
<body>

	<div class="w-50 p-3 m-auto" style="margin-top:5em;">
		<main class="form-signin w-100 m-auto" style="padding-top: 7em;">
			<form method="post" id="save" action="<%=request.getContextPath()%>/staff/passwordUpdateResult.do">
				<h1 class="h3 mb-3 fw-normal" style="text-align: center;">비밀번호 변경</h1>
				<div class="form-floating w-75 m-auto" style="padding-bottom: 0.5em;">
					<input type="password" name="staff_pwd" class="form-control" placeholder="현재 비밀번호"> 
						<label for="floatingInput">현재 비밀번호</label>
				</div>
				<div class="form-floating w-75 m-auto"style="padding-bottom: 0.5em;">
					<input type="password" name="staff_pwdChange" class="form-control" placeholder="변경 비밀번호"> 
					<label for="floatingPassword">변경 비밀번호</label>
				</div>
				<div class="form-floating w-75 m-auto"style="padding-bottom: 0.5em;">
					<input type="password" name="staff_pwdCheck" class="form-control" placeholder="비밀번호 확인"> 
					<label for="floatingPassword">비밀번호 확인</label>
				</div>
				<br>
				<div class="btn-container" style="padding-bottom: 5em;">
					<div style="margin: 0 auto;">
						<input class="w-10 btn btn-primary" type="submit" id="saveBtn" value="저장" style="width: 5em;"> 
						<input class="w-10 btn btn-danger" type="button" id="resetBtn" value="취소" style="width: 5em;">
					</div>
				</div>
			</form>
		</main>
	</div>

	<%@ include file="../footer.jsp"%>