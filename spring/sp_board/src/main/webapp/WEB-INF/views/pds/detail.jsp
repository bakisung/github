<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div style="min-width: 420px; min-height: 800px; margin: 0 auto;">
	
	<jsp:include page="/WEB-INF/views/content_header.jsp">
		<jsp:param value="자료실" name="subject" />
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
							<input type="text" class="form-control" id="title" value="${pds.title }" readonly>
						</div>
						<div class="row">
							<div class="form-group col-sm-4">
								<label for="writer">작성자</label>
								<input type="text" class="form-control" id="writer" value="${pds.writer }" readonly>
							</div>
							<div class="form-group col-sm-4">
								<label for="regdate">작성일</label>
								<input type="text" class="form-control" id="regdate" 
									value="<fmt:formatDate value="${pds.regdate }" pattern="yyyy-MM-dd" />" readonly>
							</div>
							<div class="form-group col-sm-4">
								<label for="viewcnt">조회수</label>
								<input type="text" class="form-control" id="viewcnt" value="${pds.viewcnt }" readonly>
							</div>
						</div>
						<div class="form-group col-sm-12">
							<label for="content">내 용</label>
							<div id="content">${pds.content }</div>
						</div>
						<div class="form-group col-sm-12">
							<div class="card card-outline card-success">
								<div class="card-header">
									<h3>첨부파일</h3>
								</div>
								<div class="card-footer">
									<div class="row">
									<c:forEach items="${pds.attachList }" var="attach">
										<div class="col-md-4 col-sm-4 col-xs-12" style="cursor: pointer;"
											onclick="location.href='<%=request.getContextPath()%>/pds/getFile.do?ano=${attach.ano }';">
											<div class="info-box">
												<span class="info-box-icon bg-yellow">
													<i class="fa fa-copy"></i>
												</span>
												<div class="info-box-content">
													<span class="info-box-text">
														<fmt:formatDate value="${attach.regdate }" pattern="yyyy-MM-dd"/>
													</span>
													<span class="info-box-number">${attach.fileName }</span>
												</div>
											</div>
										</div>
									</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>	<!-- card body End -->
					<div class="card-footer">
						<c:if test="${loginUser.id eq pds.writer }">
							<button type="button" id="modifyBtn" class="btn btn-warning">MODIFY</button>
							<button type="button" id="removeBtn" class="btn btn-danger">REMOVE</button>
						</c:if>
						<button type="button" id="listBtn" class="btn btn-primary" onclick="CloseWindow();">CLOSE</button>
					</div>	<!-- card footer End -->
				</div>
			</div>
		</div>	<!-- row End -->
	</section>
	
</div>

<form role="form">
	<input type="hidden" name="pno" value="${pds.pno }">
</form>

<script>
window.onload = function(){
	
	let formObj = $('form[role="form"]');

	$('button#modifyBtn').on('click', function(){
		formObj.attr({
			'action' : 'detail.do?from=modify',
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

