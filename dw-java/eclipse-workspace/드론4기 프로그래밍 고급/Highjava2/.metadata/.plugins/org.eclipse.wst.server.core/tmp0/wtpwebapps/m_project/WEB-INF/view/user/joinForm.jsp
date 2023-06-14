<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<script>
	$(function(){
		
		n_check = false;
		
		$('#joinForm').on('submit', function(e){
			if($('#joinForm').find('.is-invalid').length > 0){
				alert("형식에 맞게 입력해주세요.");
				$('#joinForm').find('.is-invalid').focus();
				e.preventDefault();
				return;
			};
			
			if(n_check == false){
				alert("닉네임 중복확인 체크를 해주세요.");
				$('input[name=nick]').focus();
				e.preventDefault();
				return;
			};
		});
		
		// email 정규식 체크
		let email = $('input[name=email]');
		email.on('keyup', function(){
			let emailVal = email.val().trim();
			
			regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
			
			if( !(regEmail.test(emailVal)) ){
				email.attr('class', 'form-control is-invalid');	
			}else{
				email.attr('class', 'form-control is-valid');
			};
		});
		
		// password 정규식 체크 - 영문 소문자, 대문자, 특수문자, 숫자가 반드시 하나 이상씩 입력
		let pass = $('input[name=pass]');
		pass.on('keyup', function(){
			passVal = pass.val().trim();
			
			regPass = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[`~!@$%&?*])[A-Za-z\d`~!@$%&?*]{8,15}/;
			
			if( !(regPass.test(passVal)) ){
				pass.attr('class', 'form-control is-invalid');
			}else{
				pass.attr('class', 'form-control is-valid');
			};
		});
		
		// pass2 pass일치 비교
		let passCheck = $('input[name=passCheck]');
		passCheck.on('keyup', function(){
			let passCheckVal = passCheck.val().trim();
			
			if(passVal == passCheckVal){
				passCheck.attr('class', 'form-control is-valid');
			}else{
				passCheck.attr('class', 'form-control is-invalid');
			}
		});
		
		let nickCheck = false;
		
		// 닉네임 정규식 체크
		let nick = $('input[name=nick]');
		nick.on('keyup', function(){
			nickVal = nick.val().trim();
			
			regNick = /^[가-힣a-zA-Z0-9]{3,13}$/;
			if( !(regNick.test(nickVal)) ){
				nick.attr('class', 'form-control is-invalid');
				nickCheck = false;
			}else{
				nick.attr('class', 'form-control is-valid');
				nickCheck = true;
			};
		});
		
		// 닉네임 중복체크
		$('#nickCheckBtn').on('click', function(){
			if(nickCheck){
				$.ajax({
					url : '<%= request.getContextPath() %>/user/nickCheck.do',
					method : 'post',
					data : {'nick' : nickVal},
					dataType : 'json',
					success : function(res){
						if(res == '사용가능한 닉네임입니다.'){
							alert(res);
							n_check = true;
						}else{
							alert(res);		
							n_check = false;
						}
					},
					error : function(req){
						alert('상태 : ' + req.status);
					}
				});
			}else{
				alert('닉네임을 확인해주세요.');
			};
		});
		
		// 생년월일 체크 - 14살 이상
		let bir = $('input[name=bir]');
		bir.on('change', function(){
			let birVal = bir.val().trim();
			
			regBir = new Date(birVal);
			now = new Date();
			
			if((now - regBir) < 0){
				alert("올바른 형식이 아닙니다!");
				bir.attr('class', 'form-control is-invalid');
				bir.focus();
			}else if(14 > (now.getFullYear() - regBir.getFullYear()) ){
				alert("14세 이상만 가입 가능합니다!");
				bir.attr('class', 'form-control is-invalid');
				bir.focus();
			}else{
				bir.attr('class', 'form-control is-valid');
			}
		});
		
	})
</script>

<!-- Main content -->
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="card card-info">
					<div class="card-header">
						<h3 class="card-title">Input Addon</h3>
					</div>
					<form method="post" action="<%=request.getContextPath()%>/user/insertUser.do" id="joinForm">
						<div class="card-body">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="fas fa-envelope"></i></span>
								</div>
								<input type="email" class="form-control" placeholder="Email" name="email" required>
								<span class="error invalid-feedback">
									이메일 형식을 맞춰서 작성해주세요.
								</span>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fas fa-solid fa-key"></i>
									</span>
								</div>
								<input type="password" class="form-control" placeholder="password" name="pass" required>
								<span class="error invalid-feedback">
									비밀번호는 영문 소문자, 대문자, 숫자, 특수문자가 최소 1개씩 입력되어야 합니다.
								</span>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fas fa-solid fa-check"></i>
									</span>
								</div>
								<input type="password" class="form-control" name="passCheck" placeholder="check password" required>
								<span class="error invalid-feedback">
									입력하신 비밀번호와 일치하지 않습니다.
								</span>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fab fa-brands fa-kickstarter-k"></i>
									</span>
								</div>
								<input type="text" class="form-control" placeholder="nickname" name="nick" required>
								<span class="error invalid-feedback">
									닉네임은 특수문자를 제외한 3-13 자리로 입력해주세요.
								</span>
								<span class="input-group-append">
									<button type="button" class="btn btn-info btn-flat" id="nickCheckBtn">중복확인</button>
								</span>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fas fa-solid fa-signature"></i>
									</span>
								</div>
								<input type="text" class="form-control" placeholder="name" name="name" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fas fa-solid fa-calendar-check"></i>
									</span>
								</div>
								<input type="date" class="form-control" placeholder="birth" name="bir" required>
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i
										class="fas fa-solid fa-venus-mars"></i>
									</span>
								</div>
								<select class="form-control" name="gender" required>
									<option value="male">남자</option>
									<option value="female">여자</option>
								</select>
							</div>
							<div class="input-group input-group-sm">
								<input type="text" class="form-control"> <span
									class="input-group-append">
									<button type="submit" id="submitBtn" class="btn btn-info btn-flat">Go!</button>
								</span>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<%@ include file="footer.jsp" %>