<%@page import="kr.or.dw.vo.StaffVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<title>교직원정보 수정 페이지 입니다.</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
<%
	StaffVO staVo = (StaffVO)request.getAttribute("staVo");
%>
<%
	List<StaffVO> staList = (List)request.getAttribute("dept");
%>
<script>
	$(function(){
		$('#saveBtn').on('click', function(){
			$('#professorUpdateForm').submit();
			alert('변경이 완료되었습니다.');
		});
		$("#resetBtn").on('click', function(){
			location.href="<%=request.getContextPath()%>/staff/professorCRUD.do";
		});
		
		$('select[name=staff_gender]').val('<%=staVo.getStaff_gender()%>').prop('selected', true);
		$('select[name=dept_code]').val('<%=staVo.getDept_code()%>').prop('selected', true);
	})
	
</script>


<div class="col-md-7 col-lg-8" style="margin: 0 auto;"><br>
	<h2 class="mb-3" style="text-align: center;">교직원 수정</h2>
	<form class="needs-validation" id="professorUpdateForm" method="post" action="<%=request.getContextPath()%>/staff/professorUpdate.do">
		<div class="row g-3" >
			
			<div class="col-12">
				<label class="professorUpdateForm">ID</label>
	          	<div class="input-group has-validation">
		            <input type="text" class="form-control" value="<%=staVo.getStaff_id()%>" name="staff_id" placeholder="아이디를 입력해주세요." readonly required>
		          	<div class="invalid-feedback">
		              아이디를 입력해주세요.
		            </div>
	          	</div>
	        </div>

			<div class="col-12">
		         <label class="professorUpdateForm">이름</label>
		         <div class="input-group has-validation">
		           	<input type="text" class="form-control" name="staff_name" value="<%=staVo.getStaff_name()%>" placeholder="이름을 입력해주세요." required>
	         		<div class="invalid-feedback">		
		             이름을 입력해주세요.
	           		</div>
		         </div>
	       </div>

			<div class="col-md-12">
	          <label for="professorUpdateForm" class="form-label">성별</label>
	          <select class="form-select" name="staff_gender" required>
	            <option value="">선택</option>
	            <option value="Male">남성</option>
				<option value="Female">여성</option>
	          </select>
	          <div class="invalid-feedback">
	            성별을 선택해주세요.
	          </div>
	        </div>

			<div class="col-12">
	          <label class="professorUpdateForm">주민등록번호</label>
	          <div class="input-group has-validation">
	            <input type="text" class="form-control" name="staff_resnum" value="<%=staVo.getStaff_resnum()%>" placeholder="주민등록번호를 입력해주세요." required>
	          	<div class="invalid-feedback">
	              주민등록번호를 입력해주세요.
	            </div>
	          </div>
	        </div>

			<div class="col-12">
	          <label class="professorUpdateForm">우편번호</label>
	          <div class="input-group has-validation">
	            <input type="text" class="form-control" id="sta_zipcode" name="staff_zipcode" value="<%=staVo.getStaff_zipcode()%>" placeholder="우편번호를 입력해주세요." readonly onclick="findAddr()" required>
	          	<div class="invalid-feedback">
	              우편번호를 입력해주세요.
	            </div>
	          </div>
	        </div>

			<div class="col-12">
	          <label class="professorUpdateForm">주소</label>
	          <div class="input-group has-validation">
	            <input type="text" class="form-control" id="sta_addr" name="staff_addr" value="<%=staVo.getStaff_addr()%>" placeholder="주소를 입력해주세요." readonly required>
	          	<div class="invalid-feedback">
	              주소를 입력해주세요.
	            </div>
	          </div>
	        </div>
			
			<div class="col-12">
	          <label class="professorUpdateForm">상세주소</label>
	          <div class="input-group has-validation">
	            <input type="text" class="form-control" name="staff_detailaddr" value="<%=staVo.getStaff_detailaddr()%>" placeholder="상세주소를 입력해주세요." required>
	          	<div class="invalid-feedback">
	              상세주소를 입력해주세요.
	            </div>
	          </div>
	        </div>
	
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
			            document.getElementById('sta_zipcode').value = data.zonecode;
			            if(roadAddr !== ''){
			                document.getElementById("sta_addr").value = roadAddr;
			            } 
			            else if(jibunAddr !== ''){
			                document.getElementById("sta_addr").value = jibunAddr;
			            }
			        }
			    }).open();
			}
			</script>
			
			<div class="col-md-12">
				<label for="professorUpdateForm" class="form-label">학과</label>
				<select class="form-select" name="dept_code" required>
					<option value="">선택</option>
					<% for(StaffVO vo : staList){ %>
						<option value="<%=vo.getDept_code()%>"><%=vo.getDept_code()%> <%=vo.getDept_name()%></option>
					<% 	 }	 %>
				</select>
	           	<div class="invalid-feedback">
	             학과를 선택해주세요.
	           	</div>
			</div>
			
			
			<div class="col-12">
	          <label class="professorUpdateForm">전화번호</label>
	          <div class="input-group has-validation">
	            <input type="text" class="form-control" name="staff_tel" value="<%=staVo.getStaff_tel()%>" placeholder="전화번호를 입력해주세요." required>
	          	<div class="invalid-feedback">
	              전화번호를 입력해주세요.
	            </div>
	          </div>
	        </div>
	        
	        <div class="col-12">
	          <label class="staffInsertForm">이메일</label>
	          <div class="input-group has-validation">
	            <input type="text" class="form-control" name="staff_email" value="<%=staVo.getStaff_email()%>" placeholder="이메일을 입력해주세요." required>
	          	<div class="invalid-feedback">
	              이메일을 입력해주세요.
	            </div>
	          </div>
	        </div>
	        
	        
	        <div class="col-12">
	          <label class="staffInsertForm">상태</label>
	          <div class="input-group has-validation">
	            <input type="text" class="form-control" name="staff_state" value="<%=staVo.getStaff_state()%>" placeholder="ex) 휴학 재학" required>
	          	<div class="invalid-feedback">
	              상태를 입력해주세요.
	            </div>
	          </div>
	        </div>
	        
	        <div style="text-align: center">
				<input type="button" class="btn btn-primary col-md-2" id="saveBtn" value="저장" style="margin-top: 1em;">
				<input type="button" class="btn btn-danger col-md-2" id="resetBtn" value="취소" style="margin-top: 1em;">
			</div>
	        </div>
		</form>
	</div>
	
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<%@ include file="../footer.jsp" %>