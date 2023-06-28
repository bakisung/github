<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="min-height: 800px;">
	<jsp:include page="/WEB-INF/views/content_header.jsp">
		<jsp:param value="자료실" name="subject"/>
		<jsp:param value="등록" name="item"/>
	</jsp:include>
	
	<section class="content container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-9" style="max-width: 950px;">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title p-1">자료등록</h3>
					</div>
					<div class="card-body pad">
						<form enctype="multipart/form-data" role="form" method="post" action="regist.do" name="registForm">
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
								<textarea class="textarea" name="content" id="content" rows="10" 
									placeholder="1000자 내외로 작성하세요." style="display: block; width:100%;"></textarea>
							</div>
							<div class="form-group">
								<div class="card card-outline card-success">
									<div class="card-header">
										<h5 style="display:inline; line-height:40px;">첨부파일 : </h5>
										<button class="btn btn-xs btn-primary" type="button" id="addFileBtn">ADD FILE</button>
									</div>
									<div class="card-footer fileInput">
									
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="card-footer">
						<button type="button" class="btn btn-primary" id="registBtn">등 록</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-warning" id="cancelBtn">취 소</button>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>

<script>
window.onload = function(){
	SmartEditor_summernote($('#content'));
	
	Attach_action();
	
	// 등록버튼 클릭
	$('#registBtn').on('click', function(){
		let form = $('form[role="form"]');
		
		let files = $('input[name="uploadFile"]');
		for(let file of files){		/* <- 향상된 for 문의 한 종류이다 - files에 있는 녀석들을 하나씩 꺼내서 file에 담아준다. */
			console.log(file.name + " ; " + file.value);
			if (file.value == "") {
				alert("파일을 선택하세요.");
				file.focus();
				file.click();
				return;
			}
		}
		
		if($('#title').val() == ""){
			alert("제목은 필수입니다.");
			return;
		}
		
		if($('#content').length > 1000){
			alert("글자수가 1000자를 초과할 수 없습니다.");
			return;
		}
		
		form.submit();
	});
	
	// 취소버튼 클릭
	$('#cancelBtn').on('click', function(){
		window.opener.location.href="list.do"
		window.close();
	});
}
</script>

<%@ include file="/WEB-INF/views/common/summernote.jsp" %>
<%@ include file="attach_js.jsp" %>