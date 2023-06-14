
<%@page import="kr.or.dw.util.SendEmail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>비밀번호 변경페이지입니다.</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/dist/css/adminlte.min.css">
</head>

<style>
/* 백그라운드 이미지에 투명도를 주기 위한 가상요소 */
	.box01::before {
        background: url(../img/행정관.jpg);
        background-size: cover;
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        content: "";
        opacity: 0.99;
	}
</style>

<script src="<%=request.getContextPath()%>/assets/plugins/jquery/jquery.js"></script>

</head>



<body class="login-page box01">
	<div class="login-box">
		<div class="login-logo">
			<a href="../../index2.html"><b>굴다리</b>&nbsp;종합정보시스템</a>
		</div>
		
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">비밀번호 변경</p>
				<form method="post" id="save" action="<%=request.getContextPath()%>/student/emailPassUpdateResult.do">
					<input type="hidden" name="stu_id" value="<%=(String)request.getAttribute("stu_id")%>">
					<div class="input-group mb-3">
						<input type="password" name="stu_pwdChange" class="form-control" placeholder="변경 비밀번호"> 
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					
					<div class="input-group mb-3">
						<input type="password" name="stu_pwdCheck" class="form-control" placeholder="비밀번호 확인"> 
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-12">
							<input class="btn btn-primary btn-block" type="submit" id="saveBtn" value="비밀번호 저장"> 
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
	
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script
	src="<%=request.getContextPath()%>/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script
	src="<%=request.getContextPath()%>/assets/dist/js/adminlte.min.js"></script>