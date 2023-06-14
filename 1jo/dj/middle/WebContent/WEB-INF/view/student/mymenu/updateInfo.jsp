<%@page import="kr.or.dw.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

	<%
		StudentVO stu = (StudentVO)request.getAttribute("stuVo");
		
	%>
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
<script>
	$(function(){
		let changeFlag = false;
		let stu_addr = "<%=stu.getStu_addr() %>";
		let stu_detailaddr = "<%=stu.getStu_detailaddr()%>";
		let stu_zipcode = "<%=stu.getStu_zipcode() %>";
		let stu_tel = "<%=stu.getStu_tel() %>";
		let ValArr = [stu_addr, stu_zipcode, stu_tel, stu_detailaddr];
		
		$('#studentInfoUpdateForm').on('propertychange keyup paste', function(){
			let inputArr = $(this).find('input[type=text]');
			for(let i = 0; i < inputArr.length; i++){
				if($(inputArr[i]).val() == ValArr[i]){
					changeFlag = false;
				}else{
					changeFlag = true;
					break;
				};
			};
		});
		
		$('#updateBtn').on('click', function(){
			if(changeFlag == true){
				$('#studentInfoUpdateForm').submit();
			}else{
				alert('변경된 정보가 없습니다.');
			};
		});
		$('#infoBtn').on('click', function(){
			location.href = "<%=request.getContextPath()%>/student/studentInfo.do";
		});
	})
</script>

<section class="content">
	<div class="card card-solid">
		<div class="card-body">
			<form method="post" id="studentInfoUpdateForm" action="<%=request.getContextPath()%>/student/studentInfoUpdate.do">
				<div class="col-8 text-center div-center text-size-up">
					<div class="table-responsive">
						<table class="table">
							<tbody style="border-top: solid 1px #dee2e6">
								<tr>
									<th style="width: 50%">학번</th>
									<td><%=stu.getStu_id()%></td>
									<input type="hidden" value="<%=stu.getStu_id()%>" name="stu_id">
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
									<td><input id="stu_zipcode" name="stu_zipcode" type="text" placeholder="우편번호" readonly onclick="findAddr()" value="<%=stu.getStu_zipcode() %>"></td>
								</tr>
								<tr>
									<th>주소</th>
									<td> <input id="stu_addr" name="stu_addr" type="text" placeholder="주소" value="<%= stu.getStu_addr() %>" readonly></td>
								</tr>
								<tr>
									<th>상세주소</th>
									<td><input type="text" placeholder="상세주소" name="stu_detailaddr" value="<%= stu.getStu_detailaddr() %>"></td>
								</tr>
						
								<script>
								function findAddr(){
									new daum.Postcode({
								        oncomplete: function(data) {
								        	
								        	console.log(data);
								        	
								            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
								            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
								            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
								            var roadAddr = data.roadAddress; // 도로명 주소 변수
								            var jibunAddr = data.jibunAddress; // 지번 주소 변수
								            // 우편번호와 주소 정보를 해당 필드에 넣는다.
								            document.getElementById('stu_zipcode').value = data.zonecode;
								            if(roadAddr !== ''){
								                document.getElementById("stu_addr").value = roadAddr;
								            } 
								            else if(jibunAddr !== ''){
								                document.getElementById("stu_addr").value = jibunAddr;
								            }
								        }
								    }).open();
								}
								</script>
								<tr>
									<th>학과명</th>
									<td><%=stu.getDept_name()%></td>
								</tr>
								<tr>
									<th>전화번호</th>
									<td><input type="text" name="stu_tel" value="<%=stu.getStu_tel() %>"></td>
								</tr>
								<tr>
									<th>이메일</th>
									<td><%=stu.getStu_email()%></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div>
						<div style="margin: 0 auto; padding: 1em;">
							<input class="btn btn-primary" type="button" id="updateBtn" value="저장하기">
							<input class="btn btn-danger" type="button" id="infoBtn" value="돌아가기">
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%@ include file="../footer.jsp"%>