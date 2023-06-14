<%@page import="java.util.Date"%>
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
	DateFormat fomatter2 = new SimpleDateFormat("yyyyMMdd");
%>
<script type="text/javascript">
	$(function(){
		
		$('select[name=sub]').change(
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
		
	})
</script>

<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">과제 목록</h3>
					<div class="d-flex flex-row-reverse bd-highlight d-grid gap-2" style="height: 2em; display:inline;">
						<select id="sub" name="sub" style="margin-left: auto;">
							<option name="sub" value="all">전체보기</option>
							<option name="sub" value="제출전">제출전</option>
							<option name="sub" value="제출완료">제출완료</option>
							<option name="sub" value="제출기간 초과">제출기간 초과</option>
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
												aria-label="Engine version: activate to sort column ascending">
												제출상태
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
										String subState = "제출전";
										List<AssignVO> assignList = (List)request.getAttribute("assignList");
										Date todayd = new Date();
										
										for(AssignVO vo : assignList){
											int today = Integer.parseInt(fomatter2.format(todayd));
											int start = Integer.parseInt(fomatter2.format(vo.getAssign_start()));
											int end = Integer.parseInt(fomatter2.format(vo.getAssign_end()));
											
										
											if(vo.getAssign_path() != null && !"".equals(vo.getAssign_path())){
												subState = "제출완료";
											}else if(today <= end){
												subState = "제출전";
											}else{
												subState = "제출기간 초과";
											}
									%>
										<tr class="odd" type="var" name="<%=subState %>" style="text-align: center; height: 30px;">
											<td><%=vo.getLec_name() %></td>
											<td><a href="<%=request.getContextPath()%>/assign/viewAssign.do?assign_no=<%=vo.getAssign_no()%>"><%= vo.getAssign_name()%></a></td>
											<td><%=fomatter.format(vo.getAssign_start())%></td>
											<td><%=fomatter.format(vo.getAssign_end())%></td>
											<td id="subState"><%=subState %></td>
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