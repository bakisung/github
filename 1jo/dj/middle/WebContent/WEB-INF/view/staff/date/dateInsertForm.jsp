<%@page import="kr.or.dw.vo.DateVO"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.dw.vo.AssignVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<title>일정등록</title>
<body>
<%
	String lec_start = "";
	String lec_end = "";
	String reg_start = "";
	String reg_end = "";
	if(request.getAttribute("dateVo") != null){
		DateVO dateVo = (DateVO)request.getAttribute("dateVo");
		lec_start = dateVo.getLec_start().split(" ")[0];
		lec_end = dateVo.getLec_end().split(" ")[0];
		reg_start = dateVo.getReg_start().split(" ")[0];
		reg_end = dateVo.getReg_end().split(" ")[0];
%>
	<script>
		$(function(){
			$('#year').prop('value', <%=dateVo.getYear()%>);
			$('#term').val('<%=dateVo.getTerm()%>').prop('selected',true);
		})
	</script>		
<%
	}
%>
	<div class="col-md-7 col-lg-8" style="margin: 0 auto;">
        <h4 class="mb-3">일정등록</h4>
        <form class="needs-validation" id="insertDateForm" method="post" action="<%=request.getContextPath()%>/staff/dateinsert.do">
          <div class="row g-3">
            <div class="col-12">
              <label class="form-label">년도</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="year" name="year" placeholder="YYYY">
              </div>
            </div>
            <div class="col-12">
              <label class="form-label">학기</label>
              <div class="input-group has-validation">
               <select class="form-select" id="term" name="term" required>
                <option value="">선택</option>
                <option id="term" name="term" value="1">1학기</option>
                <option id="term" name="term" value="2">2학기</option>
              </select>
              </div>
            </div>
          
		
	        
			<div class="col-12">
	          <label class="form-label">개강일</label>
	          <div class="input-group has-validation">
	            <input type="date" class="form-control" name="lec_start" id="lec_start" value="<%=lec_start %>" required>
	          	<div class="invalid-feedback">
	              	개강일을 선택해주세요.
	            </div>
	          </div>
	        </div>
			<div class="col-12">
	          <label class="form-label">종강일</label>
	          <div class="input-group has-validation">
	            <input type="date" class="form-control" name="lec_end" id="lec_end" value="<%=lec_end %>" required>
	          	<div class="invalid-feedback">
	              	종강일을 선택해주세요.
	            </div>
	          </div>
	        </div>
			<div class="col-12">
	          <label class="form-label">수강신청 시작일</label>
	          <div class="input-group has-validation">
	            <input type="date" class="form-control" name="reg_start" id="reg_start" value="<%=reg_start %>" required>
	          	<div class="invalid-feedback">
	              	수강신청 시작일을 선택해주세요.
	            </div>
	          </div>
	        </div>
			<div class="col-12">
	          <label class="form-label">수강신청 마감일</label>
	          <div class="input-group has-validation">
	            <input type="date" class="form-control" name="reg_end" id="reg_end" value="<%=reg_end %>" required>
	          	<div class="invalid-feedback">
	              	수강신청 마감일을 선택해주세요.
	            </div>
	          </div>
	        </div>

          <button class="w-100 btn btn-primary btn-lg" type="submit">등록</button>
          </div>
        </form>
      </div>
</body>
<%@ include file="../footer.jsp" %>