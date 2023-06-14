<%@page import="kr.or.dw.util.PaginationUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="kr.or.dw.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../user/header.jsp" %>
<%
	List<BoardVO> boardList = (List<BoardVO>) request.getAttribute("boardList");
%>
<script>

</script>
<!-- Main content -->
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">게시판</h3>
						<div class="card-tools">
							<div class="input-group input-group-sm">
								<%
									if(vo != null) {
								%>
									<a class="btn btn-primary btn-sm" href="<%=request.getContextPath()%>/board/boardInsert.do">글작성</a>
								<%  } %>
								<input type="text" class="form-control" placeholder="Search Title">
								<div class="input-group-append">
									<div class="btn btn-primary">
										<i class="fas fa-search"></i>
									</div>
								</div>
							</div>
<!-- 							<button type="button" class="btn btn-tool" -->
<!-- 								data-card-widget="collapse" title="Collapse"> -->
<!-- 								<i class="fas fa-minus"></i> -->
<!-- 							</button> -->
<!-- 							<button type="button" class="btn btn-tool" -->
<!-- 								data-card-widget="remove" title="Remove"> -->
<!-- 								<i class="fas fa-times"></i> -->
<!-- 							</button> -->
						</div>
					</div>
					<div class="card-body p-0">
						<table class="table table-striped projects">
							<thead>
								<tr>
									<th style="width: 10%">글번호</th>
									<th style="">제목</th>
									<th style="width: 20%">작성자</th>
									<th style="width: 7%">조회수</th>
									<th style="width: 7%">공감수</th>
									<th style="width: 16%">작성일</th>
								</tr>
							</thead>
							<tbody>
							
							<%
							
							DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							
							for(BoardVO board : boardList){
								int bd_no = board.getBd_no();
								String bd_title = board.getBd_title();
								String bd_nick = board.getNick();
								String bd_picPath = "/profilePath/default/defaultProfile.jpg";
								
								if(board.getPic_path() != null){
									bd_picPath = "/profilePath/" + board.getPic_path();
								}
								
								int bd_hit = board.getBd_hit();
								int bd_like = board.getBd_like();
							%>
								<tr>
									<td><%= bd_no %></td>
									<td>
										<a href="<%= request.getContextPath() %>/board/boardView.do?bd_no=<%= bd_no %>"><%= bd_title %></a>
									</td>
									<td>
										<img alt="작성자 프로필사진" class="table-avatar" src="<%= bd_picPath %>"><%= bd_nick %>
									</td>
									<td><%= bd_hit %></td>
									<td><%= bd_like %></td>
									<td><%= formatter.format(board.getBd_wdt()) %></td>
								</tr>
							<% } %>
							</tbody>
						</table>
						<div class="container" style="margin-top: 20px;">
							<%
								PaginationUtil pagination = (PaginationUtil) request.getAttribute("pagingConfigMap");
							%>
							<%= pagination.getPaginationHtml(request, new String[] {"search"}) %>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</div>

<%@ include file="../user/footer.jsp" %>