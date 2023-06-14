<%@page import="kr.or.dw.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../user/header.jsp" %>

<%
	BoardVO boardVo = null;
	if(request.getAttribute("boardVo") != null){
		boardVo = (BoardVO)request.getAttribute("boardVo");
	}
%>

<!-- Main content -->
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="card card-primary">
					<div class="card-header">
						<h3 class="card-title">글작성</h3>
						<div class="card-tools">
							<button type="button" class="btn btn-tool"
								data-card-widget="collapse" title="Collapse">
								<i class="fas fa-minus"></i>
							</button>
						</div>
					</div>
					<form method="post" action="<%=request.getContextPath()%>/board/contentInsert.do">
						<% if(boardVo != null){ %>
						<input type="hidden" name="bd_no" value="<%=boardVo.getBd_no()%>">
						<% } %>
						<div class="card-body">
							<div class="form-group">
								<label for="inputName">제목</label> 
								<input type="text" id="inputName" name="title" class="form-control" required value="<%=boardVo != null ? boardVo.getBd_title() : ""%>">
							</div>
							<div class="form-group">
								<label for="inputDescription">내용</label>
								<textarea id="inputDescription" name="content" class="form-control" rows="4"><%=boardVo != null ? boardVo.getBd_content() : ""%></textarea>
							</div>
							<div>
								<button type="submit" class="btn btn-success btn-sm"><%= boardVo != null ? "수정" : "등록" %></button>
								<button class="btn btn-default btn-sm" onclick="history.go(-1)">취소</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</div>
	
<%@ include file="../user/footer.jsp" %>