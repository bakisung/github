<%@page import="kr.or.dw.vo.StaffVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<script>
	$(function(){
		$('#staffInfoUpdateBtn').on('click', function(){
			location.href="<%=request.getContextPath()%>/staff/staffInfoUpdateForm.do";
		});
		$('#passUpdateBtn').on('click', function(){
			location.href="<%=request.getContextPath()%>/staff/staffPasswordUpdateForm.do";
		});
	})
</script>
<style>
.div-center {
	margin: 0 auto;
	margin-top: 3em;
}

.text-size-up {
	font-size: large;
}

input + input {
	margin-left: 0.5em;
}
</style>
<% StaffVO staff = (StaffVO) request.getAttribute("staffVo"); %>
<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div class="col-8 text-center div-center text-size-up">
				<div class="table-responsive">
					<table class="table">
						<tbody style="border-top: solid 1px #dee2e6">
							<tr>
								<th style="width: 50%">ID</th>
								<td><%=staff.getStaff_id()%></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><%=staff.getStaff_name()%></td>
							</tr>
							<tr>
								<th>성별</th>
								<td><%=staff.getStaff_gender()%></td>
							</tr>
							<tr>
								<th>주민번호</th>
								<td><%=staff.getStaff_resnum()%></td>
							</tr>
							<tr>
								<th>우편번호</th>
								<td><%=staff.getStaff_zipcode()%></td>
							</tr>
							<tr>
								<th>주소</th>
								<td><%=staff.getStaff_addr()%></td>
							</tr>
							<tr>
								<th>상세주소</th>
								<td><%=staff.getStaff_detailaddr()%></td>
							</tr>
							<tr>
								<th>학과명</th>
								<td><%=staff.getDept_name()%></td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td><%=staff.getStaff_tel()%></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><%=staff.getStaff_email()%></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div style="argin: 0 auto; padding: 0.5em;">
					<div>
						<input class="btn btn-primary" type="button" id="staffInfoUpdateBtn" value="내 정보 수정">
						<input class="btn btn-danger" type="button" id="passUpdateBtn" value="비밀번호 변경">
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="../footer.jsp"%>