<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div style="min-width: 420px; min-height: 800px; margin: 0 auto;">
	
	<jsp:include page="/WEB-INF/views/content_header.jsp">
		<jsp:param value="자유게시판" name="subject" />
		<jsp:param value="상세보기" name="item" />
	</jsp:include>
	
	<section class="content container-fluid">
		<div class="row">	<!-- row Start -->
			<div class="col-md-12">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title">상세보기</h3>
					</div>
					<div class="card-body">	<!-- card body Start -->
						<div class="form-group col-sm-12">
							<label for="title">제 목</label>
							<input type="text" class="form-control" id="title" value="${board.title }" readonly>
						</div>
						<div class="row">
							<div class="form-group col-sm-4">
								<label for="writer">작성자</label>
								<input type="text" class="form-control" id="writer" value="${board.writer }" readonly>
							</div>
							<div class="form-group col-sm-4">
								<label for="regdate">작성일</label>
								<input type="text" class="form-control" id="regdate" 
									value="<fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd" />" readonly>
							</div>
							<div class="form-group col-sm-4">
								<label for="viewcnt">조회수</label>
								<input type="text" class="form-control" id="viewcnt" value="${board.viewcnt }" readonly>
							</div>
						</div>
						<div class="form-group col-sm-12">
							<label for="content">내 용</label>
							<div id="content">${board.content }</div>
						</div>
					</div>	<!-- card body End -->
					<div class="card-footer">
						<button type="button" id="modifyBtn" class="btn btn-warning">MODIFY</button>
						<button type="button" id="removeBtn" class="btn btn-danger">REMOVE</button>
						<button type="button" id="listBtn" class="btn btn-primary">CLOSE</button>
					</div>	<!-- card footer End -->
				</div>
			</div>
		</div>	<!-- row End -->
		
		<div class="row">	<!-- reply component Start -->
			<div class="col-md-12">
				<div class="card card-info">
					<div class="card-body">	<!-- card body Start -->
						<div class="timeline"> <!-- timeline Start -->
							<div class="time-label" id="repliesDiv">
								<span class="bg-green">Replies List</span>
							</div>
						</div>	<!-- timeline End -->
						<div class="text-center">
							<ul id="pagination" class="pagination justify-content-center m-0">
							
							</ul>
						</div>
					</div>	<!-- card body End -->
					<div class="card-footer">
						<label for="newReplyWriter">작성자</label>
						<input class="form-control" type="hidden" id="newReplyWriter" readonly value="${loginUser.id }">
						<label for="newReplyText">Reply Text</label>
						<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
						<br>
						<button type="button" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	
</div>

<form role="form">
	<input type="hidden" name="bno" value="${board.bno }">
</form>

<script>
window.onload = function(){

	ShowReply();
	
	let formObj = $('form[role="form"]');

	$('button#modifyBtn').on('click', function(){
		formObj.attr({
			'action' : 'modifyForm.do',
			'method' : 'post' 
		});
		formObj.submit();
	});
	
	$('button#removeBtn').on('click', function(){
		if(confirm("정말 삭제하시겠습니까?")){
			formObj.attr({
				'action' : 'remove.do',
				'method' : 'post' 
			});
			formObj.submit();
		};
	});
	
	$('button#listBtn').on('click', function(){
		window.opener.location.reload(true);
		window.close();
	});
}
</script>

<%@ include file="reply_js.jsp" %>
