<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="content-wrapper">
	
	<jsp:include page="/WEB-INF/views/content_header.jsp">
		<jsp:param value="회원관리" name="subject" />
		<jsp:param value="수정하기" name="item" />
	</jsp:include>
	
	<section class="content register-page">
		<div class="register-box">
			<!-- 콘텐츠 -->
			<div class="card">
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="modify.do" method="post" enctype="multipart/form-data">
						<!-- 프로필 사진 선택 부분 -->
						<div class="form-group row">
							<input type="hidden" name="oldPicture" value="${member.picture }">
							<input type="file" id="inputFile" name="picture" style="display:none;" onchange="imageChange_go();">
							<div class="input-group col-md-12">
								<div class="col-md-12" style="test-align: center;">
									<div id="pictureView" style="border: 1px solid green; height: 180px; width: 140px; margin:0 auto; margin-bottom: 5px;"></div>
									<div class="input-group input-group-sm">
										<label for="inputFile" class="btn btn-warning btn-sm btn-flat input-group-addon">사진변경</label>
										<input id="inputFileName" class="form-control" type="text" name="" disabled>
										<input id="picture" class="form-control" type="hidden" name="uploadPicture">
									</div>
								</div>
							</div>
						</div>
						<div class="form-group row">
							<label for="id" class="col-sm-3" style="font-size: 0.9em;">
								<span style="color: red; font-weight:bold;">*</span>아이디
							</label>
							<div class="col-sm-9 input-group input-group-sm">
								<input name="id" type="text" id="id" class="form-control" value="${member.id }"	readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="pwd" class="col-sm-3" style="font-size: 0.9em;">
								<span style="color: red; font-weight:bold;">*</span>패스워드
							</label>
							<div class="col-sm-9 input-group-sm">
								<input name="pwd" type="password" id="pwd" class="form-control" value="${member.pwd }" placeholder="20자 영문,숫자,특수문자 조합">
							</div>
						</div>
						<div class="form-group row">
							<label for="name" class="col-sm-3" style="font-size: 0.9em;">
								<span style="color: red; font-weight:bold;">*</span>이 름 
							</label>
							<div class="col-sm-9 input-group-sm">
								<input name="name" type="text" id="name" class="form-control" value="${member.name }" placeholder="이름을 입력하세요">
							</div>
						</div>
						<div class="form-group row">
							<label for="authority" class="col-sm-3" style="font-size: 0.9em;">권 한</label>
							<div class="col-sm-9 input-group-sm">
								<select name="authority" class="form-control" style="font-size: 0.9em;">
									<option value="ROLE_USER" ${member.authority eq 'ROLE_USER' ? 'selected' : ''}>사용자</option>
									<option value="ROLE_MANAGER" ${member.authority eq 'ROLE_MANAGER' ? 'selected' : ''}>운영자</option>
									<option value="ROLE_ADMIN" ${member.authority eq 'ROLE_ADMIN' ? 'selected' : ''}>관리자</option>
								</select>
							</div>
						</div>
						<div class="form-group row">
							<label for="email" class="col-sm-3" style="font-size: 0.9em;">이메일</label>
							<div class="col-sm-9 input-group-sm">
								<input name="email" type="text" id="email" class="form-control" value="${member.email }" placeholder="example@naver.com">
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-sm-3" style="font-size: 0.9em;">전화번호</label>
							<div class="col-sm-9">
								<input name="phone" type="text" class="form-control"
									value="${member.phone.substring(0,3) }-${member.phone.substring(3,7)}-${member.phone.substring(7)}">
							</div>
						</div>
						
						<div class="card-footer">
							<div class="row">
								<div class="col-sm-6">
									<button type="button" id="modifyBtn" class="btn btn-info">수정하기</button>
								</div>
								<div class="col-sm-6">
									<button type="button" id="cancelBtn" class="btn btn-danger float-right">&nbsp;&nbsp;&nbsp;취&nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</div>
<%@ include file="modify_js.jsp" %>



