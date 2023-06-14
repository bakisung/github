<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="kr.or.dw.vo.LectureVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%
	String stu_id = (String) session.getAttribute("stu_id");
%>
<script>
	$(function() {
		$('select[name=year]').change(
				function() { //년도 선택하면 해당 년도의 강의만 보이는 함수
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
		
		$(document).on('click', '#planDownBtn', function(){
			let plan_path = $(this).prop('name');
			console.log(plan_path);
			location.href="<%=request.getContextPath()%>/lecture/downloadLecturePlan.do?plan_path=" + plan_path;
			
		})
		$(document).on('click', '#assignListBtn', function(){
			let lec_code = $(this).prop('name');
			console.log(plan_path);
			location.href="<%=request.getContextPath()%>/lecture/lectureAssignList.do?lec_code=" + lec_code;
			
		})
		
		$(document).on('click', '#stuDeleteBtn', function(){
			let stu_id = "<%=stu_id%>";
			let lec_code = $(this).prop('name');
			if(confirm("수강취소 하시겠습니까?")){
				location.href="<%=request.getContextPath()%>/lecture/deleteStudentLecture.do?stu_id=" + stu_id + "&lec_code=" + lec_code;
			}
			console.log(stu_id);
			console.log(lec_code);
		})
		
		$(document).on('click', '#lecEvalBtn', function(){
			let lec_code = $(this).prop('name');
			location.href="<%=request.getContextPath()%>/lecture/lectureEvaluatioin.do?lec_code=" + lec_code;
		})
		
	})
</script>
<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">수강 강의</h3>
					<div class="d-flex flex-row-reverse bd-highlight d-grid gap-2" style="height: 2em; display:inline;">
						<select id="year" name="year" style="margin-left: auto;">
							<option name="year" value="all">전체보기</option>
							<%
							List<LectureVO> lecList = (List) request.getAttribute("lecList"); //학생이 수강한 년도만 보이게
							Set<Integer> yearList = new HashSet<>();
							for (LectureVO vo : lecList) {
								yearList.add(vo.getLec_year());
							}
							
							for (int year : yearList) {
							%>
							<option name="year" value="<%=year%>"><%=year%>년
							</option>
							<%
							}
							%>
						</select>
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
												강의계획서
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												수강취소
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												강의평가
											</th>
										</tr>
									</thead>
									<%
										
										String disabled = "";
										for (LectureVO vo : lecList) {
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
										<tr class="odd" type="var" name="<%=vo.getLec_year()%>"
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
												<input type="button" value="다운로드" <%=disabled %> id="planDownBtn" name="<%=vo.getPlan_path()%>">
											</td>
											<td>
											<input type="button" value="수강취소" id="stuDeleteBtn" name="<%=vo.getLec_code()%>">
											</td>
											<td>
											<input type="button" value="강의평가" id="lecEvalBtn" name="<%=vo.getLec_code()%>">
											</td>
										</tr>
									</tbody>
									<% } %>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../footer.jsp"%>