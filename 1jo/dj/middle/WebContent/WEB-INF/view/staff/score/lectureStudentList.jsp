<%@page import="kr.or.dw.vo.LectureVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<title>강의수강 학생 리스트</title>
<%
	String lec_code = request.getParameter("lec_code");
%>

<script>
	$(function(){
		
		$('#cancelBtn').on('click', function(){
			location.href="<%=request.getContextPath()%>/lecture/lectureScoreList.do";
		})
		$('#scoreInsertBtn').on('click', function(){
			let lec_code = "<%=lec_code%>";
			location.href="<%=request.getContextPath()%>/lecture/lectureStudentScoreInsert.do?lec_code=" + lec_code;
		})
	})
</script>



<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">수강생 목록</h3>
					<div class="d-flex flex-row-reverse bd-highlight d-grid gap-2" style="height: 2em; display:inline;">
						<input type="button" id="cancelBtn" class="btn btn-secondary" value="뒤로가기" style="height: 35px;">
						<input type="button" id="scoreInsertBtn" class="btn btn-secondary" value="성적입력" style="height: 35px;">
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
												aria-label="Engine version: activate to sort column ascending">
												성별
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Engine version: activate to sort column ascending">
												전화번호
											</th>
										
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												관리
											</th>
										</tr>
									</thead>
										<%
										List<StudentVO> stuList = (List<StudentVO>)request.getAttribute("stuList");
										String stu_grade = "";
										for(StudentVO stu : stuList){
											
										%>
									<tbody>
										<input type="hidden" name="lec_code" value="<%=lec_code%>">
										<tr class="odd" type="var" id="<%=stu.getStu_id()%>" style="text-align: center; height: 30px;">
											<td><%=stu.getStu_id() %></td>
												<input type="hidden" name="stu_id" id="stu_id" value="<%=stu.getStu_id()%>">
											<td><%=stu.getStu_name() %></td>
											<td><%=stu.getDept_name() %></td>
											<td><%=stu.getStu_gender() %></td>
											<td><%=stu.getStu_tel()%></td>
											<td><input type="button" value="학생 삭제하기" id="stuDeleteBtn" onclick="location.href='<%=request.getContextPath()%>/lecture/deleteStudentLecture.do?stu_id=<%=stu.getStu_id() %>&lec_code=<%=lec_code %>'"></td>
										</tr>
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