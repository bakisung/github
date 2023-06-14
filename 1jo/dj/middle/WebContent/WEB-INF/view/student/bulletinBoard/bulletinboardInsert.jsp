<%@page import="kr.or.dw.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%
	BoardVO boardVo = null;
	if(request.getAttribute("boardVo") != null){
		boardVo = (BoardVO) request.getAttribute("boardVo");
	}
%>


<h3 class="card-title">글작성</h3>
<form method="post" action="<%=request.getContextPath()%>/board/bulletinContentInsert.do">
	<%
	if(boardVo != null){
	%>
		<input type="hidden" name="bd_no" value="<%=boardVo.getBd_no()%>">
	<%
	}
	%>
	<div class="col-md-7 col-lg-7" style="margin: 0 auto;">
		<div class="col">
	        <div class="card mb-4 rounded-3 shadow-sm">
	        
		          <div class="card-header py-3">
					<div class="col-12">
			          <div class="input-group has-validation">
			            <input type="text" class="form-control" id="inputName" name="bd_title" placeholder="제목을 입력해주세요." value="<%=boardVo != null ? boardVo.getBd_title() : ""%>" required>
			          	<div class="invalid-feedback">
			              제목을 입력해주세요.
			            </div>
			          </div>
			        </div>
		          </div>
		          <div class="card-body">
		          
				<div class="mailbox-read-message" style="margin: 1em;">
					<div class="col-12">
			          <div class="input-group has-validation">
			            <textarea class="form-control" rows="9.9" id="inputDescription" name="bd_content" placeholder="내용을 입력해주세요." required><%=boardVo != null ? boardVo.getBd_content() : ""%></textarea>
			          	<div class="invalid-feedback">
			              내용을 입력해주세요.
			            </div>
			          </div>
			        </div>
				</div>
				<br>
				<hr>
				<div style="text-align: center">
					<button onclick="history.go(-1)" style="float: right; width: 4em;" class="btn btn-danger">
						취소
					</button>
	            	<button type="submit" style="float: right; width: 4em; margin-right:0.5em;" class="btn btn-primary">
	            		<%=boardVo != null ? "수정" : "등록" %>
					</button> 
				</div>
			</div>
			</div>
		</div>
	</div>
</form>
<br>
<hr>

<%@ include file="../footer.jsp"%>