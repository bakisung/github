<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="min-height: 800px;">
	<jsp:include page="/WEB-INF/views/content_header.jsp">
		<jsp:param value="자유게시판" name="subject"/>
		<jsp:param value="수정" name="item"/>
	</jsp:include>
	
	<section class="content container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-12" style="max-width: 950px;">
				<div class="card card-outline card-info">
					<div class="card-header row">
						<h4 class="col-md-8">글수정</h4>
						<div class="col-md-4">
							<div class="float-right">
								<button type="button" class="btn btn-warning" id="modifyBtn">수 정</button>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<button type="button" class="btn btn-default" id="cancelBtn">취 소</button>
							</div>
						</div>
					</div>
					<div class="card-body pad">
						<form role="form" method="post" action="modify.do" name="modifyForm">
							<input type="hidden" name="bno" value="${board.bno}">
							<div class="form-group">
								<label for="title">제 목</label>
								<input type="text" id="title" name="title" class="form-control" placeholder="제목을 입력하세요." value="${board.title }">
							</div>
							<div class="form-group">
								<label for="writer">작성자</label>
								<input type="text" id="writer" name="writer" class="form-control" value="${board.writer }" readonly>
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea class="textarea" name="content" id="content" rows="10" 
										placeholder="1000자 내외로 작성하세요." style="display: block; width: 100%;">
											${board.content }
								</textarea>
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
		
		$('#modifyBtn').on('click', function() {
			let title = $('input[name="title"]');
			if (title.val() == '') {
				alert("제목은 필수입니다.");
				title.focus();
				return;
			};
			$('form[name="modifyForm"]').submit();
		});
		
		// 취소버튼 클릭
		$('#cancelBtn').on('click', function() {
			history.go(-1);
		});
	}
</script>

<%@ include file="/WEB-INF/views/common/summernote.jsp" %>