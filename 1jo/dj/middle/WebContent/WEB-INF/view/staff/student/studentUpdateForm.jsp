<%@page import="java.util.List"%>
<%@page import="kr.or.dw.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<title>학생정보 수정 페이지 입니다.</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
<%
	StudentVO stuVo = (StudentVO)request.getAttribute("stuVo");
%>
<%
	List<StudentVO> stuList = (List)request.getAttribute("dept");
%>
<script>
	$(function(){
		$('#saveBtn').on('click', function(){
			$('#studentUpdateForm').submit();
		});
		$("#resetBtn").on('click', function(){
			location.href="<%=request.getContextPath()%>/staff/studentCRUD.do"
		});
		
		$('select[name=stu_gender]').val('<%=stuVo.getStu_gender()%>').prop('selected', true);
		$('select[name=dept_code]').val('<%=stuVo.getDept_code()%>').prop('selected', true);
	})
</script>

<div class="col-md-7 col-lg-8" style="margin: 0 auto;"><br>
	<h2 class="mb-3" style="text-align: center;">학생 수정</h2>
	<form class="needs-validation" id="studentUpdateForm" method="post" action="<%=request.getContextPath()%>/staff/studentUpdate.do">
	  <div class="row g-3" >
		<div class="col-12">
          <label class="studentUpdateForm">ID</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" value="<%=stuVo.getStu_id()%>" name="stu_id" placeholder="아이디를 입력해주세요." readonly required>
          	<div class="invalid-feedback">
              아이디를 입력해주세요.
            </div>
          </div>
        </div>
		
		<div class="col-12">
          <label class="studentUpdateForm">이름</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" name="stu_name" value="<%=stuVo.getStu_name()%>" placeholder="이름을 입력해주세요." required>
          	<div class="invalid-feedback">
              이름을 입력해주세요.
            </div>
          </div>
        </div>
        
        <div class="col-md-12">
          <label for="studentUpdateForm" class="form-label">성별</label>
          <select class="form-select" name="stu_gender" required>
            <option value="">선택</option>
            <option value="Male">남성</option>
			<option value="Female">여성</option>
          </select>
          <div class="invalid-feedback">
            성별을 선택해주세요.
          </div>
        </div>
		
		<div class="col-12">
          <label class="studentUpdateForm">주민등록번호</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" name="stu_resnum" value="<%=stuVo.getStu_resnum()%>" placeholder="주민등록번호를 입력해주세요." required>
          	<div class="invalid-feedback">
              주민등록번호를 입력해주세요.
            </div>
          </div>
        </div>
		
		<div class="col-12">
          <label class="studentUpdateForm">우편번호</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" id="stu_zipcode" name="stu_zipcode" value="<%=stuVo.getStu_zipcode()%>" placeholder="우편번호를 입력해주세요." readonly onclick="findAddr()" required>
          	<div class="invalid-feedback">
              우편번호를 입력해주세요.
            </div>
          </div>
        </div>
		
		<div class="col-12">
          <label class="studentUpdateForm">주소</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" id="stu_addr" name="stu_addr" value="<%=stuVo.getStu_addr()%>" placeholder="주소를 입력해주세요." readonly required>
          	<div class="invalid-feedback">
              주소를 입력해주세요.
            </div>
          </div>
        </div>
        
        <div class="col-12">
          <label class="studentUpdateForm">상세주소</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" name="stu_detailaddr" value="<%=stuVo.getStu_detailaddr()%>" placeholder="상세주소를 입력해주세요." required>
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
		
		<div class="col-md-12">
			<label for="studentUpdateForm" class="form-label">학과</label>
			<select class="form-select" name="dept_code" required>
				<option value="">선택</option>
				<% for(StudentVO vo : stuList){ %>
					<option value="<%=vo.getDept_code()%>"><%=vo.getDept_code()%> <%=vo.getDept_name()%></option>
				<% 	 }	 %>
			</select>
           	<div class="invalid-feedback">
             학과를 선택해주세요.
           	</div>
		</div>
		
		<div class="col-12">
          <label class="staffInsertForm">전화번호</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" name="stu_tel" value="<%=stuVo.getStu_tel()%>" placeholder="전화번호를 입력해주세요." required>
          	<div class="invalid-feedback">
              전화번호를 입력해주세요.
            </div>
          </div>
        </div>
		
		<div class="col-12">
          <label class="staffInsertForm">이메일</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" name="stu_email" value="<%=stuVo.getStu_email()%>" placeholder="이메일을 입력해주세요." required>
          	<div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>
        </div>
        
        <div class="col-12">
          <label class="staffInsertForm">상태</label>
          <div class="input-group has-validation">
            <input type="text" class="form-control" name="stu_state" value="<%=stuVo.getStu_state()%>" placeholder="ex) 휴학 재학" required>
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