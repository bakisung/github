<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %>

<style>
	#carouselExampleInterval {
		margin-top: 150px;
		margin-bottom: 50px;
	}
</style>

	<!-- Main Start -->
	<main>
		
		<section class="py-5 text-center container">

			<div class="row justify-content-center">
			
				<div class="col-4"></div>
				
				<div id="carouselExampleInterval" class="carousel slide col-4" data-bs-ride="carousel">
					<form>
					
						<a class="pe-sm-3" href="index.html">
							<span class="text-primary flex-shrink-0 me-2">
								<svg version="1.1" width="35" height="32" viewBox="0 0 36 33" xmlns="http://www.w3.org/2000/svg">
									<path fill="currentColor" d="M35.6,29c-1.1,3.4-5.4,4.4-7.9,1.9c-2.3-2.2-6.1-3.7-9.4-3.7c-3.1,0-7.5,1.8-10,4.1c-2.2,2-5.8,1.5-7.3-1.1c-1-1.8-1.2-4.1,0-6.2l0.6-1.1l0,0c0.6-0.7,4.4-5.2,12.5-5.7c0.5,1.8,2,3.1,3.9,3.1c2.2,0,4.1-1.9,4.1-4.2s-1.8-4.2-4.1-4.2c-2,0-3.6,1.4-4,3.3H7.7c-0.8,0-1.3-0.9-0.9-1.6l5.6-9.8c2.5-4.5,8.8-4.5,11.3,0L35.1,24C36,25.7,36.1,27.5,35.6,29z"></path>
								</svg>
							</span>
						</a>
							<h1 class="h3 mb-3 fw-normal">Please sign in</h1>
					
						<div class="form-floating" style="margin-bottom: 0.5em;">
							<input type="text" class="form-control" id="username" name="username" placeholder="name@example.com">
							<label for="floatingInput">아이디를 입력해주세요.</label>
						</div>
						
						<div class="form-floating">
							<input type="password" class="form-control" id="password" name="password" placeholder="Password">
							<label for="floatingPassword">비밀번호를 입력해주세요.</label>
						</div>
						
						<div class="form-check text-start my-3">
							<input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
							<label class="form-check-label" for="flexCheckDefault">
								Remember me
							</label>
						</div>
						
						<button class="btn btn-primary w-100 py-2" type="button" id="signBtn">Sign in</button>
						<p class="mt-5 mb-3 text-body-secondary">© 2017–2023</p>
					
					</form>
				</div>
				
				<div class="col-4"></div>
			
			</div>
			
		</section>
		
	</main>
	<!-- Main End -->
	
<script>

	$(document).ready(function () {
			
			$('#signBtn').on('click', function() {
				alert('버튼 클릭 이벤트 발생');
			
				var data = {
					id: $("#username").val(),
					password: $("#password").val()
				};
				
				$.ajax({
					
					type: 'post',
					url: '<%=request.getContextPath()%>/common/member.do',
					data: JSON.stringify(data),
					contentType: 'application/json; charset=utf-8',
					dataType: 'json',
					success: function () {
						console.log("로그인 성공");
					},
					error: function () {
						console.log("로그인 실패");
					}
					
				});
				
			});
	
	});

</script>

<%@ include file="../include/footer.jsp" %>
