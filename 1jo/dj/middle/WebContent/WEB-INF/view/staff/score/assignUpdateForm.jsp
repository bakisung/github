<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.dw.vo.AssignVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<title>과제수정</title>
<body>
<%
AssignVO assignVo = (AssignVO) request.getAttribute("assignVo");
DateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd");

Date startDate = assignVo.getAssign_start();
Date endDate = assignVo.getAssign_end();
String start = fomatter.format(startDate);
String end = fomatter.format(endDate);

%>

	
	<div class="col-md-7 col-lg-8" style="margin: 0 auto;">
        <h4 class="mb-3">과제 수정</h4>
        <form class="needs-validation" id="insertAssignForm" method="post" action="<%=request.getContextPath()%>/assign/assignUpdate.do">
        <input type="hidden" name="assign_no" value="<%=assignVo.getAssign_no()%>">
          <div class="row g-3">
            <div class="col-12">
              <label class="form-label">강의코드</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="lec_code" name="lec_code" value="<%=assignVo.getLec_code() %>"readonly>
              </div>
            </div>
            <div class="col-12">
              <label class="form-label">과제명</label>
              <div class="input-group has-validation">
                <input type="text" class="form-control" id="assign_name" name="assign_name" value="<%=assignVo.getAssign_name() %>" placeholder="과제명을 입력해주세요." required>
              	<div class="invalid-feedback">
                  	과제명을 입력해주세요.
                </div>
              </div>
            </div>
            
			<div class="col-12">
	          <label class="form-label">과제 시작일</label>
	          <div class="input-group has-validation">
	            <input type="date" class="form-control" name="assign_start" value="<%=start%>" required>
	          	<div class="invalid-feedback">
	              	과제 시작일을 선택해주세요.
	            </div>
	          </div>
	        </div>
	        
			<div class="col-12">
	          <label class="form-label">과제 마감일</label>
	          <div class="input-group has-validation">
	            <input type="date" class="form-control" name="assign_end" value="<%=end%>" required>
	          	<div class="invalid-feedback">
	              	과제 마감일을 선택해주세요.
	            </div>
	          </div>
	        </div>
	        
<!--             <div class="col-12"> -->
<!--               <label class="form-label">과제내용</label> -->
<%--               <input style="height : 300px;" type="text" class="form-control" id="assign_content" name="assign_content" value="<%=assign_content %>" required> --%>
<!--               <div class="invalid-feedback"> -->
<!--                	 과제 내용을 입력해주세요. -->
<!--               </div> -->
<!--             </div> -->
            
            <div class="col-12">
<!--               <label class="form-label">과제내용</label> -->
              	과제내용<br>
              <textarea name="assign_content" form="insertAssignForm" rows="10" style="width :100%;"><%=assignVo.getAssign_content()%></textarea>
              <div class="invalid-feedback">
               	 과제 내용을 입력해주세요.
              </div>
            </div>
            

          <button class="w-100 btn btn-primary btn-lg" type="submit">수정</button>
          </div>
        </form>
      </div>
</body>
<%@ include file="../footer.jsp" %>