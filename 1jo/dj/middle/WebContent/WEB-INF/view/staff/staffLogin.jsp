<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
<script
	src="<%=request.getContextPath()%>/assets/plugins/jquery/jquery.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>타이틀</title>

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

<body class="login-page box01">
	<div class="login-box">
		<div class="login-logo">
			<a href="../../index2.html"><b>굴다리</b>&nbsp;종합정보시스템</a>
		</div>

		<div class="card">
			<div class="card-body login-card-body">
				<h4 class="login-box-msg" style="padding: 0px;">교직원 로그인 페이지 입니다.</h4>
				<hr>
				<p style="font-size: 12px; text-align: center;">초기 비밀번호는 주민번호 뒷자리입니다.</p>
				<form id="login" action="<%=request.getContextPath()%>/staff/staffLogin.do" method="post">
					<div class="input-group mb-3">
						<input type="text" id="stu_id" name="staff_id" class="form-control" placeholder="ID">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input type="password" id="stu_pwd" name="staff_pwd" class="form-control" placeholder="Password">
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<button type="submit" id="loginInformation" class="btn btn-primary btn-block">로그인</button>
						</div>
					</div>
				</form>
				<div class="social-auth-links text-center mb-3">
					<a href="<%=request.getContextPath()%>/staff/findStaffPassword.do" id="findPassword" class="btn btn-block btn-danger"> 
						<!-- <i class="fab fa-google-plus mr-2"></i> --> 비밀번호 찾기 및 변경
					</a>
				</div>
				<div class="social-auth-links text-center mb-3">
					<a href="/" class="btn btn-outline-primary btn-block"> 
						<!-- <i class="fab fa-google-plus mr-2"></i> --> 학생 로그인 페이지로 이동
					</a>
				</div>
			</div>

		</div>
	</div>


	<script src="plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script
		src="<%=request.getContextPath()%>/assets/dist/js/adminlte.min.js"></script>


</body>