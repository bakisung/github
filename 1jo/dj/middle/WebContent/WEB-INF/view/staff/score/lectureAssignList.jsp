<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="kr.or.dw.vo.AssignVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<title>과제 목록</title>
<%

	String lec_code = (String)request.getAttribute("lec_code");
	DateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd");
%>
<script type="text/javascript">
	$(function(){
		$('#insertAssignBtn').on('click', function(){
			let lec_code = "<%=lec_code%>";
			location.href="<%=request.getContextPath()%>/assign/insertAssignForm.do?lec_code=" + lec_code;
		})

		$('#backBtn').on('click', function(){
			let lec_code = "<%=lec_code%>";
			location.href="<%=request.getContextPath()%>/lecture/lectureScoreList.do?lec_code=" + lec_code;
		})
		
		
	})
</script>

<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">과제 목록</h3>
					<div class="d-flex flex-row-reverse bd-highlight d-grid gap-2" style="display:inline;">
						<input type="button" id="backBtn" class="btn btn-secondary" value="돌아가기" style="width: 7em; margin-right: 1.5em;">
						<input type="button" id="insertAssignBtn" class="btn btn-primary" value="과제 추가" style="width: 7em; margin-right: 0.5em;">
					</div>
				</div>
				
				<div class="card-body">
					<div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
						<div class="row">
							<div class="col-sm-12 col-md-6"></div>
							<div class="col-sm-12 col-md-6"></div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<table id="example2"
									class="table table-bordered table-hover dataTable dtr-inline"
									aria-describedby="example2_info">
									<thead style="text-align:center;">
										<tr>
											<th class="sorting sorting_asc" tabindex="0"
												aria-controls="example2" rowspan="1" colspan="1"
												aria-sort="ascending"
												aria-label="Rendering engine: activate to sort column descending">
												강의명
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Browser: activate to sort column ascending">
												과제명
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Browser: activate to sort column ascending">
												시작일
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Engine version: activate to sort column ascending">
												마감일
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												제출물 
											</th>
										</tr>
									</thead>
									<tbody>
									<%
									if(request.getAttribute("assignList") == null){
									%>
									<tr class="odd" type="var" name="" style="text-align: center; height: 30px;">
										<td colspan="5">과제가 없습니다.</td>
									</tr>	
									<%
									}else{
										List<AssignVO> assignList = (List)request.getAttribute("assignList");
										for(AssignVO vo : assignList){
									%>
										<tr class="odd" type="var" name="" style="text-align: center; height: 30px;">
											<td><%=vo.getLec_name() %></td>
											<td><a href="<%=request.getContextPath()%>/assign/viewAssign.do?assign_no=<%=vo.getAssign_no()%>"><%= vo.getAssign_name()%></a></td>
											<td><%=fomatter.format(vo.getAssign_start())%></td>
											<td><%=fomatter.format(vo.getAssign_end())%></td>
											<td>
												<input type="button" value="제출물 조회" onclick="location.href='<%=request.getContextPath()%>/assign/submitAssignList.do?assign_no=<%=vo.getAssign_no() %>&lec_code=<%=lec_code%>'">
											</td>

										</tr>		
									<% }} %>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>								

<%@ include file="../footer.jsp" %>