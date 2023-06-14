<%@page import="kr.or.dw.vo.LectureVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<title>성적입력</title>
<%
	String lec_code = request.getParameter("lec_code");
%>

<script>
	$(function(){
		$('input[type=number]').on('change', function(){
			let sum = 0;
			for(let i = 0; i < $(this).parents('tr').find('input[type=number]').length; i++){
				sum += +$(this).parents('tr').find('input[type=number]').eq(i).val();
				console.log(sum);
			}
			$(this).parents('tr').find('input[name=stu_score]').attr('value', sum);
		});
		
		$('#cancelBtn').on('click', function(){
			let lec_code = "<%=lec_code%>";
			console.log(lec_code);
			location.href="<%=request.getContextPath()%>/lecture/lectureStudentList.do?lec_code=" + lec_code;
		})
	})
</script>



<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">성적입력</h3>
					<div class="d-flex flex-row-reverse bd-highlight d-grid gap-2" style="height: 2em; display:inline;">
						<input type="button" id="cancelBtn" class="btn btn-secondary" value="뒤로가기" style="height: 35px;">
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
												학번
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Browser: activate to sort column ascending">
												이름
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Engine version: activate to sort column ascending">
												과
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												중간
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												기말
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												과제
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												출석
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												가산점
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												합계
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												등급
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												저장
											</th>
							
										</tr>
									</thead>
										<%
										List<LectureVO> stuList = (List<LectureVO>)request.getAttribute("stuList");
										String stu_grade = "";
										for(LectureVO stu : stuList){
											if(!stu.getStu_grade().equals("null")){
										%>
										<script>
												$(function(){
													let stu_grade = '<%=stu.getStu_grade()%>';
													$('#<%=stu.getStu_id()%>').find('.stu_grade').val(stu_grade).prop('selected', true);
												})
										</script>					
											<%
												}
											%>
									<tbody>
										<form id="scoreInsert" method="post" action="<%=request.getContextPath()%>/lecture/scoreUpdate.do">
										<input type="hidden" name="lec_code" value="<%=lec_code%>">
											<tr class="odd" type="var" id="<%=stu.getStu_id()%>" style="text-align: center; height: 30px;">
												<td><%=stu.getStu_id() %></td>
													<input type="hidden" name="stu_id" id="stu_id" value="<%=stu.getStu_id()%>">
												<td><%=stu.getStu_name() %></td>
												<td><%=stu.getDept_name() %></td>
												<td><input id="middle" style="width: 40px;" type="number" min="0"></td>
												<td><input id="final" style="width: 40px;" type="number" min="0"></td>
												<td><input id="assign" style="width: 40px;" type="number" min="0"></td>
												<td><input id="attend" style="width: 40px;" type="number" min="0"></td>
												<td><input id="point" style="width: 40px;" type="number" min="0"></td>
												<td><input id="<%=stu.getStu_id() %>" name="stu_score" style="width: 40px;" type="text" value="<%=stu.getStu_score() %>" readonly></td>
												<td>
													<select class='stu_grade' id="<%=stu.getStu_grade()%>" name="stu_grade" style="height: 30px">
														<option value="P">P</option>
														<option value="NP">NP</option>
														<option value="A+">A+</option>
														<option value="A">A</option>
														<option value="B+">B+</option>
														<option value="B">B</option>
														<option value="C+">C+</option>
														<option value="C">C</option>
														<option value="D+">D+</option>
														<option value="D">D</option>
														<option value="F">F</option>
													</select>
												</td>
												<td><input type="submit" value="저장하기" id="updateBtn"></td>
											</tr>
										</form>
										<%
										}
										%>
									</tbody>
								</table>
<!-- 								<input type="button" value="뒤로가기" id="cancelBtn"> -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
						

<%@ include file="../footer.jsp" %>