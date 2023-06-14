<%@page import="kr.or.dw.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<script>
	$(function(){
		$('#stuInfoUpdateBtn').on('click', function(){
			location.href="<%=request.getContextPath()%>/student/updateInfo.do";
		});
		$('#passUpdateBtn').on('click', function(){
			location.href="<%=request.getContextPath()%>/student/studentPasswordUpdate.do";
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
<% StudentVO stu = (StudentVO) request.getAttribute("stuVo"); %>
<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<div class="col-8 text-center div-center text-size-up">
				<div class="table-responsive">
					<table class="table">
						<tbody style="border-top: solid 1px #dee2e6;">
							<tr>
								<th style="width: 50%">학번</th>
								<td><%=stu.getStu_id()%></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><%=stu.getStu_name()%></td>
							</tr>
							<tr>
								<th>성별</th>
								<td><%=stu.getStu_gender()%></td>
							</tr>
							<tr>
								<th>주민번호</th>
								<td><%=stu.getStu_resnum()%></td>
							</tr>
							<tr>
								<th>우편번호</th>
								<td><%=stu.getStu_zipcode()%></td>
							</tr>
							<tr>
								<th>주소</th>
								<td><%=stu.getStu_addr()%></td>
							</tr>
							<tr>
								<th>상세주소</th>
								<td><%=stu.getStu_detailaddr()%></td>
							</tr>
							<tr>
								<th>학과명</th>
								<td><%=stu.getDept_name()%></td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td><%=stu.getStu_tel()%></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><%=stu.getStu_email()%></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div style="argin: 0 auto; padding: 0.5em;">
					<div>
						<input class="btn btn-primary" type="button" id="stuInfoUpdateBtn" value="내 정보 수정">
						<input class="btn btn-danger" type="button" id="passUpdateBtn" value="비밀번호 변경">
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@ include file="../footer.jsp"%>