<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="kr.or.dw.vo.AssignVO"%>
<%@page import="kr.or.dw.vo.LectureVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<title>과제 제출물 리스트</title>
<%
	int assign_no = (int)request.getAttribute("assign_no");
	DateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd");
	List<AssignVO> stuList = (List<AssignVO>)request.getAttribute("stuAssignList");

	String lec_code = (String)request.getAttribute("lec_code");
// 	String assignList = (String)request.getAttribute("assignList");
	
	LectureVO vo = new LectureVO();
%>
<script>
$(function(){
	$('#backBtn').on('click', function(){
		let lec_code = "<%=lec_code%>";
		location.href="<%=request.getContextPath()%>/assign/lectureAssignList.do?lec_code="+lec_code;
	});
})
</script>


<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">과제 제출 수강생 목록</h3>
					<div class="d-flex flex-row-reverse bd-highlight d-grid gap-2" style="display:inline;">
						<input type="button" id="backBtn" class="btn btn-secondary" value="돌아가기" style="width: 7em; margin-right: 1.5em;">
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
												제출일
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												제출물
											</th>
										</tr>
									</thead>
										<%
										String stu_grade = "";
										for(AssignVO stu : stuList){
											
										%>
									<tbody>
										<tr class="odd" type="var" id="<%=stu.getStu_id()%>" style="text-align: center; height: 30px;">
											<td><%=stu.getStu_id() %></td>
												<input type="hidden" name="stu_id" id="stu_id" value="<%=stu.getStu_id()%>">
											<td><%=stu.getStu_name() %></td>
											<td><%=stu.getDept_name() %></td>
											<td><%=fomatter.format(stu.getAssign_subdate()) %></td>
											<td><input type="button" value="다운로드" id="subAssignDownBtn" onclick="location.href='<%=request.getContextPath()%>/assign/subAssignDown.do?assign_path=<%=stu.getAssign_path()%>'"></td>
										</tr>
										<%
										}
										%>
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