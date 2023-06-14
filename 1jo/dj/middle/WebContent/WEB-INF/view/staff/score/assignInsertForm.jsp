<%@page import="java.util.Date"%>
<%@page import="kr.or.dw.vo.AssignVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<title>과제등록</title>
<body>

	<%
		String lec_code = request.getParameter("lec_code");
	%>
	<div class="col-md-7 col-lg-8" style="margin: 0 auto;">
        <h4 class="mb-3">과제 등록</h4>
        <form class="needs-validation" id="insertAssignForm" method="post" action="<%=request.getContextPath()%>/assign/assignInsert.do">
          <div class="row g-3">
            <div class="col-12">
              <label class="form-label">강의코드</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="lec_code" name="lec_code" value="<%=lec_code %>"readonly>
              </div>
            </div>
            <div class="col-12">
              <label class="form-label">과제명</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="assign_name" name="assign_name" placeholder="과제명을 입력해주세요." required>
              	<div class="invalid-feedback">
                  	과제명을 입력해주세요.
                </div>
              </div>
            </div>
            
			<div class="col-12">
	          <label class="form-label">과제 시작일</label>
	          <div class="input-group has-validation">
	            <input type="Date" class="form-control" name="assign_start"  required>
	          	<div class="invalid-feedback">
	              	과제 시작일을 선택해주세요.
	            </div>
	          </div>
	        </div>
	        
			<div class="col-12">
	          <label class="form-label">과제 마감일</label>
	          <div class="input-group has-validation">
	            <input type="Date" class="form-control" name="assign_end" required>
	          	<div class="invalid-feedback">
	              	과제 마감일을 선택해주세요.
	            </div>
	          </div>
	        </div>
	        
            <div class="col-12">
<!--               <label class="form-label">과제내용</label> -->
              	과제내용<br>
              <textarea name="assign_content" form="insertAssignForm" rows="10" style="width :100%;"></textarea>
              <div class="invalid-feedback">
               	 과제 내용을 입력해주세요.
              </div>
            </div>
            

          <button class="w-100 btn btn-primary btn-lg" type="submit">등록</button>
          </div>
        </form>
      </div>
</body>
<%@ include file="../footer.jsp" %>