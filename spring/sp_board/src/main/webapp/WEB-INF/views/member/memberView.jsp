<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<body>
	<div class="card-body" style="text-align:center;">
		<div class="row">
			<div class="col-sm-12">	
				<h1 style="background-color: red; color: white;">회원 상세 페이지 입니다.</h1>
				<hr>
				<p>아이디 : ${memberView.id}</p><hr>
				<p>비밀번호 : ${memberView.pwd}</p><hr>
				<p>이메일 : ${memberView.email}</p><hr>
				<div>
					<h5>사진</h5>
					<div id="pictureView" style="border: 1px solid red; width: 100px; height: 100px; margin:0 auto;">
					
					</div>
				</div><hr>
				<p>활성화 : ${memberView.enabled}</p><hr>
				<p>생성일 : ${memberView.regdate}</p><hr>
				<p>전화번호 : ${memberView.phone}</p><hr>
				<p>이름 : ${memberView.name}</p><hr>
				<p>레지스터가뭐여 : ${memberView.register}</p><hr>
				<p>주소 : ${memberView.address}</p><hr>
				<p>권한 : ${memberView.authority}</p><hr>
				<div>
					<button type="button" class="btn btn-primary">수정</button>
					<button type="button" class="btn btn-danger">삭제</button>
				</div>
			</div>
		</div>
	</div>
</body>