<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="min-height: 800px;">
	<jsp:include page="/WEB-INF/views/content_header.jsp">
		<jsp:param value="자유게시판" name="subject"/>
		<jsp:param value="등록" name="item"/>
	</jsp:include>
	
	<section class="content container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-9" style="max-width: 950px;">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title p-1">글등록</h3>
						<div class="card-tools">
							<button type="button" class="btn btn-primary" id="registBtn">등 록</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-warning" id="cancelBtn">취 소</button>
						</div>
					</div>
					<div class="card-body pad">
						<form role="form" method="post" action="regist.do" name="registForm">
							<div class="form-group">
								<label for="title">제 목</label>
								<input type="text" id="title" name="title" class="form-control" placeholder="제목을 입력하세요.">
							</div>
							<div class="form-group">
								<label for="writer">작성자</label>
								<input type="text" id="writer" name="writer" class="form-control" value="${loginUser.id }" readonly>
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea class="textarea" name="content" id="content" rows="10" placeholder="1000자 내외로 작성하세요." style="display: block; width: 100%"></textarea>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<script>
	window.onload = function(){
		SmartEditor_summernote($('#content'));
		
		// 등록버튼 클릭
		$('#registBtn').on('click', function() {
			let form = $('form[role="form"]');
			
			if($('#title').val() == "") {
				alert("제목을 입력하시게..");
				return;
			}
			
			if($('#content').length > 1000){
				alert("글자수가 100자를 초과할 수 없습니다.");
				return;
			}
			
			form.submit();
		});
		
		// 취소버튼 클릭
		$('#cancelBtn').on('click', function() {
			window.opener.location.href="list.do" 	// 윈도우 창을 띄운 부모 페이지를 list.do로 향하게 한다.
			window.close();							// 윈도우 창을 닫는다.
		});
	}
</script>

<%@ include file="/WEB-INF/views/common/summernote.jsp" %>