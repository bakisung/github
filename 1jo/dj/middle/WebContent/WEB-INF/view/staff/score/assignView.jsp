<%@page import="kr.or.dw.vo.AssignVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.dw.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>    
<%
	AssignVO assignVo = (AssignVO) request.getAttribute("assignVo");

	DateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd");

%>

<style>
	.click:focus {
		outline: none;
	}
	
	.click {
		border: white;
		resize: none; 
		width: 100%;
		height: 100%;
	}
</style>

<script>
	$(function(){
		$('#contentDelBtn').on('click', function(){
			if(confirm("정말 삭제하시겠습니까?") == true){
				location.href = "<%=request.getContextPath()%>/assign/deleteAssign.do?assign_no=<%=assignVo.getAssign_no()%>&lec_code=<%=assignVo.getLec_code()%>";
				};
		});
		let test2 = $('.click');
		let sch2 = test2.prop('scrollHeight');
		test2.css('height', sch2);
	});
	
	function autoResize(textarea) {
		  textarea.style.height = 'auto';
		  console.log(textarea.scrollHeight)
		  textarea.style.height = textarea.scrollHeight + 'px';
	}
</script>

<div class="col-md-7 col-lg-7" style="margin: 0 auto;">
	<div class="col">
        <div class="card mb-4 rounded-3 shadow-sm">
          <div class="card-header py-3">
            <h4 class="my-0 fw-normal" style="display:inline;"><%=assignVo.getAssign_name()%></h4>
            <span class="mailbox-read-time float-right" style="float: right; vertical-align: middle;">&emsp;&emsp;제출 기간 : <%=fomatter.format(assignVo.getAssign_start())%> ~ <%=fomatter.format(assignVo.getAssign_end())%>&emsp;&emsp;</span>
            
          </div>
          <div class="card-body">
            <!-- content -->
		<div class="mailbox-read-message" style="margin: 1em;">
			<textarea class="click" readonly style="overflow: hidden;" onkeyup="autoResize(this)" onkeydown="autoResize(this)"><%=assignVo.getAssign_content()%></textarea>
		</div>
			<br>
			<hr>
            <div style="text-align: center">
            	<button type="button" class="btn btn-primary" style="float:left; width:5em" onclick="location.href='<%=request.getContextPath()%>/assign/lectureAssignList.do?lec_code=<%=assignVo.getLec_code()%>'">
            		목록
           		</button>
            	<button type="button" class="btn btn-danger" style="float:right; width:5em" id="contentDelBtn">
            		삭제
				</button> 
				<button type="button" class="btn btn-success" style="float:right; width:5em; margin-right:0.5em;" onclick="location.href='<%=request.getContextPath()%>/assign/updateAssignForm.do?assign_no=<%=assignVo.getAssign_no()%>'">
					수정
				</button>
			</div>
        </div>
      </div>
	</div>
</div>

<%@ include file="../footer.jsp"%>