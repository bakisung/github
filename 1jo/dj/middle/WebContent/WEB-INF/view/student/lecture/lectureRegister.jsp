<%@page import="kr.or.dw.util.PaginationUtil"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="kr.or.dw.vo.LectureVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script>
	$(function() {
		$('select[name=div]').change(
				function() { 
					for (let i = 0; i < $('tr[type=var]').length; i++) {
						if ($(this).val() == 'all') {
							$('tr[type=var]').css('display', '');
						} else if ($(this).val() == $($('tr[type=var]')[i])
								.attr('name')) {
							$($('tr[type=var]')[i]).css('display', '');
						} else {
							$($('tr[type=var]')[i]).css('display', 'none');
						}
					}

		});
		
		$(document).on('click', '#lectureRegBtn', function(){
			let lec_code = $(this).prop('name');
			console.log(lec_code);
			location.href="<%=request.getContextPath()%>/lecture/lectureRegister.do?lec_code=" + lec_code;
			
		})
		$(document).on('click', '#searchBtn', function(){
			let search = $('#search').val();
			location.href="<%=request.getContextPath()%>/lecture/lectureRegisterForm.do?search=" + search;
			
		})
		
		
	})
</script>
<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">수강 신청</h3>
						<input  id="search" name="search" type="text" placeholder="강의코드 검색" style="float:left;">
						
						<button type="button" id="searchBtn" style="float:left;">검색</button>
<!-- 					<div class="d-flex flex-row-reverse bd-highlight d-grid gap-2" style="height: 2em; display:inline;"> -->
<!-- 						<select id="div" name="div" style="margin-left: auto;"> -->
<!-- 							<option name="div" value="all">전체보기</option> -->
<!-- 							<option name="전공필수" value="전공필수">전공필수</option> -->
<!-- 							<option name="전공선택" value="전공선택">전공선택</option> -->
<!-- 							<option name="교양" value="교양">교양</option> -->
<!-- 							<option name="교직" value="교직">교직</option> -->
							
<!-- 						</select> -->
<!-- 					</div> -->
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
									<thead>
										<tr>
											<th class="sorting sorting_asc" tabindex="0"
												aria-controls="example2" rowspan="1" colspan="1"
												aria-sort="ascending"
												aria-label="Rendering engine: activate to sort column descending">
												강의코드
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Browser: activate to sort column ascending">
												강의명
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Platform(s): activate to sort column ascending">
												수강년도
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Engine version: activate to sort column ascending">
												수강학기
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												교수명
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												강의실
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												시간
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												구분
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												학점
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												수강신청
											</th>
										</tr>
									</thead>
									<% 
										
										String disabled = "";
										String reg_disabled = "";
										List <LectureVO> stuLecList = (List) request.getAttribute("stuLecList");
										List<LectureVO> lecList = (List) request.getAttribute("lecList");
										
										for (LectureVO vo : lecList) {
											for(LectureVO stuLecVo : stuLecList){
												if(vo.getLec_code().equals(stuLecVo.getLec_code())){
													reg_disabled = "disabled";
													break;
												}else{
													reg_disabled = "";
												}
											}
											String lec_time = "" + vo.getLec_time();
											if(vo.getPlan_path() == null || vo.getPlan_path().equals("")){
												disabled = "disabled";
											}else{
												disabled = "";
											}
											for (int i = 1; i < vo.getLec_hour(); i++) {
												lec_time += ", " + (vo.getLec_time() + i);
											}
									%>
									<tbody>
										<tr class="odd" type="var" name="<%=vo.getLec_div()%>"
											style="text-align: center; height: 30px;">
											<td class="dtr-control sorting_1" tabindex="0"><%=vo.getLec_code()%></td>
											<td><%=vo.getLec_name()%></td>
											<td><%=vo.getLec_year()%></td>
											<td><%=vo.getLec_term()%>학기</td>
											<td><%=vo.getStaff_name()%></td>
											<td><%=vo.getLec_loc()%></td>
											<td><%=vo.getLec_day()%><%=lec_time%>교시</td>
											<td><%=vo.getLec_div()%></td>
											<td><%=vo.getLec_credit()%></td>
											<td>
												<input type="button" value="수강신청" id="lectureRegBtn" name="<%=vo.getLec_code()%>" <%=reg_disabled %>>
											</td>
										</tr>
									</tbody>
									<% 
									} 
									%>
								</table>
								<br>
								<div style="display: flex; justify-content: center;">
								<%
									PaginationUtil pagination = (PaginationUtil) request.getAttribute("pagingConfigMap");
						 		%>
								<%= 
									pagination.getPaginationHtml(request,new String[] {"search"}) 
								%>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../footer.jsp"%>