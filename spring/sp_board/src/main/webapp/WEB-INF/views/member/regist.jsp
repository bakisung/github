<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="content-wrapper">
	
	<section class="content register-page">
		<div class="register-box">
			<!-- 콘텐츠 헤더 -->
			<div class="login-logo">
				<a href="<%=request.getContextPath()%>/member/registForm.do"><b>회원 등록</b></a>
			</div>
			
			<!-- 콘텐츠 -->
			<div class="card">
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="regist.do" method="post">
						<input type="hidden" name="picture">
						<!-- 프로필 사진 선택 부분 -->
						<div class="input-group mb-3">
							<div class="mailbox-attachments clearfix" style="text-align: center;">
								<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
								<div class="mailbox-attachment-info">
									<div class="input-group input-group-sm">
										<label for="inputFile" class="btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
										<input id="inputFileName" class="form-control" type="text" disabled>
										<span class="input-group-append-sm">
											<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>
										</span>
									</div>
								</div>
							</div>
							<br>
						</div>
						<div class="form-group row">
							<label for="id" class="col-sm-3" style="font-size: 0.9em;">
								<span style="color: red; font-weight:bold;">*</span>아이디
							</label>
							<div class="col-sm-9 input-group input-group-sm">
								<input name="id" type="text" id="id" class="form-control" placeholder="13자 영문자, 숫자 조합"
									onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g, &#39;&#39;)">
								<span class="input-group-append-sm">
									<button type="button" class="btn btn-info btn-sm btn-append" onclick="idCheck_go();">중복확인</button>
								</span>
							</div>
						</div>
						<div class="form-group row">
							<label for="pwd" class="col-sm-3" style="font-size: 0.9em;">
								<span style="color: red; font-weight:bold;">*</span>패스워드
							</label>
							<div class="col-sm-9 input-group-sm">
								<input name="pwd" type="password" id="pwd" class="form-control" placeholder="20자 영문,숫자,특수문자 조합">
							</div>
						</div>
						<div class="form-group row">
							<label for="name" class="col-sm-3" style="font-size: 0.9em;">
								<span style="color: red; font-weight:bold;">*</span>이 름 
							</label>
							<div class="col-sm-9 input-group-sm">
								<input name="name" type="text" id="name" class="form-control" placeholder="이름을 입력하세요">
							</div>
						</div>
						<div class="form-group row">
							<label for="authority" class="col-sm-3" style="font-size: 0.9em;">권 한</label>
							<div class="col-sm-9 input-group-sm">
								<select name="authority" class="form-control" style="font-size: 0.9em;">
									<option value="ROLE_USER">사용자</option>
									<option value="ROLE_MANAGER">운영자</option>
									<option value="ROLE_ADMIN">관리자</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="email" class="col-sm-3" style="font-size: 0.9em;">이메일</label>
							<div class="col-sm-9 input-group-sm">
								<input name="email" type="text" id="email" class="form-control" placeholder="example@naver.com">
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-sm-3" style="font-size: 0.9em;">전화번호</label>
							<div class="col-sm-9">
								<div class="input-group-sm">
									<input style="width: 30%;" name="phone" type="text" id="phone" class="form-control float-left">
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-&nbsp;</label>
									<input style="width: 30%;" name="phone" type="text" class="form-control float-left">
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-&nbsp;</label>
									<input style="width: 30%;" name="phone" type="text" class="form-control float-left">
								</div>
							</div>
						</div>
						
						<div class="card-footer">
							<div class="row">
								<div class="col-sm-6">
									<button type="button" id="registBtn" class="btn btn-info" onclick="submit_go();">가입하기</button>
								</div>
								<div class="col-sm-6">
									<button type="button" id="cancelBtn" class="btn btn-danger float-right" onclick="CloseWindow();">&nbsp;&nbsp;&nbsp;취&nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</div>
<%@ include file="regist_js.jsp" %>





