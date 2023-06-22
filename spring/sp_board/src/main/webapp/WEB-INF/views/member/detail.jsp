<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div>

	<section class="content register-page">
		<div class="register-box" style="min-width: 450px;">
			<!-- 콘텐츠 헤더 -->
			<div class="login-logo">
				<p><b>회원 상세 보기</b></p>
			</div>
			
			<!-- 콘텐츠 -->
			<div class="card">
				<div class="register-card-body">
					<form role="form" class="form-horizontal" method="post">
						<!-- 프로필 사진 선택 부분 -->
						<div class="row">
							<div class="mailbox-attachments clearfix col-md-12" style="text-align: center;">
								<div id="pictureView" style="border: 1px solid green; height: 180px; width: 140px; margin: 0 auto;"></div>
							</div>
						</div>
						<br>
						<div class="form-group row">
							<label for="id" class="col-sm-3 control-label text-right" style="position: relative; top: 6px;">아이디</label>
							<div class="col-sm-9">
								<input name="id" type="text" id="id" class="form-control" value="${member.id }" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="pwd" class="col-sm-3 control-label text-right" style="position: relative; top: 6px;">비밀번호</label>
							<div class="col-sm-9">
								<input name="pwd" type="text" id="pwd" class="form-control" value="${member.pwd }" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="name" class="col-sm-3 control-label text-right" style="position: relative; top: 6px;">이  름</label>
							<div class="col-sm-9">
								<input name="name" type="text" id="name" class="form-control" value="${member.name }" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="email" class="col-sm-3 control-label text-right" style="position: relative; top: 6px;">이메일</label>
							<div class="col-sm-9">
								<input name="email" type="text" id="email" class="form-control" value="${member.email }" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-sm-3 control-label text-right" style="position: relative; top: 6px;">전화번호</label>
							<div class="col-sm-9">
								<input name="phone" type="text" id="phone" class="form-control" value="${member.phone }" readonly>
							</div>
						</div>
						
						<div class="card-footer">
							<div class="row">
								<sec:authorize access="hasRole('ROLE_ADMIN')">
									<div class="col-sm-3 text-center">
										<button type="button" id="modifyBtn" class="btn btn-warning">수 정</button>
									</div>
									<div class="col-sm-3 text-center">
										<button type="button" id="deleteBtn" class="btn btn-danger">삭 제</button>
									</div>
									<div class="col-sm-3 text-center">
										<button type="button" id="stopBtn" class="btn btn-info">${member.enabled == 1 ? '비활성화' : '활성화' }</button>
									</div>
								</sec:authorize>
								<div class="col-sm-3 text-center">
									<button type="button" id="listBtn" class="btn btn-primary" onclick="CloseWindow();">닫 기</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>

</div>

<%@ include file="detail_js.jsp" %>