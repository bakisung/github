<%@page import="java.text.DateFormat"%>
<%@page import="kr.or.dw.vo.DateVO"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="kr.or.dw.vo.LectureVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

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
		
		$('#dateAddBtn').on('click', function(){
			location.href="<%=request.getContextPath()%>/staff/dateInsertForm.do"
		})

		
	})
</script>
<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">일정 목록</h3>
					<div class="d-flex flex-row-reverse bd-highlight d-grid gap-2" style="height: 2em; display:inline;">
<!-- 						<select id="year" name="year" style="margin-left: auto;"> -->
<!-- 							<option name="year" value="all">전체보기</option> -->
<%-- 							<% --%>
<!-- // 							List<DateVO> dateList = (List) request.getAttribute("lecList"); //학생이 수강한 년도만 보이게 -->
<!-- // 							Set<Integer> yearList = new HashSet<>(); -->
<!-- // 							for (DateVO vo : dateList) { -->
<!-- // 								yearList.add(vo.getYear()); -->
<!-- // 							} -->
							
<!-- // 							for (int year : yearList) { -->
<%-- 							%> --%>
<%-- 							<option name="year" value="<%=year%>"><%=year%>년 --%>
<!-- 							</option> -->
<%-- 							<% --%>
<!-- // 							} -->
<%-- 							%> --%>
<!-- 						</select> -->
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
												년도
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Browser: activate to sort column ascending">
												학기
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Platform(s): activate to sort column ascending">
												개강일
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="Engine version: activate to sort column ascending">
												종강일
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												수강신청 시작일
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												수강신청 마감일
											</th>
											<th class="sorting" tabindex="0" aria-controls="example2"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending">
												수정
											</th>
										</tr>
									</thead>
									<tbody>
									<%

										if(request.getAttribute("dateList") != null){
										List<DateVO> dateList = (List)request.getAttribute("dateList");
										String disabled = "";
										for (DateVO vo : dateList) {
											
									%>
										<tr class="odd" type="var" name="<%=vo.getYear()%>"
											style="text-align: center; height: 30px;">
											<td><%=vo.getYear()%></td>
											<td><%=vo.getTerm()%>학기</td>
											<td><%=vo.getLec_start().split(" ")[0]%></td>
											<td><%=vo.getLec_end().split(" ")[0]%></td>
											<td><%=vo.getReg_start().split(" ")[0]%></td>
											<td><%=vo.getReg_end().split(" ")[0]%></td>
											<td>
												<input type="button" value="수정" onclick="location.href='<%=request.getContextPath()%>/staff/dateInsertForm.do?year=<%=vo.getYear()%>&term=<%=vo.getTerm()%>'">
											</td>
										</tr>
									<% }} %>
									</tbody>
								</table>
							</div>
						</div>
						<div style="float: right;"> 
							<input type="button" class="btn btn-primary col-md-2" style="width:4em;" id="dateAddBtn" value="추가">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../footer.jsp"%>