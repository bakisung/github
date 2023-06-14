<%@page import="java.util.Date"%>
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
	AssignVO stuAssignVo = null;
	String stu_assignFile = "";
	if(request.getAttribute("stuAssignVo") != null){
		stuAssignVo = (AssignVO) request.getAttribute("stuAssignVo");
		stu_assignFile = stuAssignVo.getAssign_path().split("/")[1];
	}

	
	DateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat fomatter2 = new SimpleDateFormat("yyyyMMdd");

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

	input[type=file]::file-selector-button {
	  width: 100px;
	  height: 30px;
	  background: #fff;
	  border: 1px solid rgb(77,77,77);
	  border-radius: 10px;
	  cursor: pointer;
	  &:hover {
	    background: rgb(77,77,77);
	    color: #fff;
	  }
	}
</style>

<script>
	$(document).on('change', '#assignfile', function(){
		$(this).parent().find('#saveAssignBtn').css('display', '');
		
		$(document).on('click', '#saveAssignBtn', function(){
			let formData = new FormData($('#assign_form')[0]);
			
			$.ajax({
				url : "<%=request.getContextPath()%>/assign/assignFileSubmit.do",
				processData : false,
				contentType : false,
				data : formData,
				dataType : "json",
				method : "post",
				success : function(res){
					console.log(res);
					alert('과제가 제출되었습니다.');
					location.href="<%=request.getContextPath()%>/assign/assignList.do";
				},
				error : function(){
					
				}
			});
			$(this).css('display', 'none');
		});
		
	})
		$(document).on('click', '#assignUpdateBtn', function(){
			$('#assignfile').css('display', '');
			$('#assignFileName').css('display', 'none');
			$(this).css('display', 'none');
		});
	$(function(){
	let test2 = $('.click');
		let sch2 = test2.prop('scrollHeight');
		test2.css('height', sch2);		
	})
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
			<form id="assign_form" method="post" enctype="multipart/form-data">
						&nbsp;&nbsp;<span style="font-size: 1.2em;">과제제출</span>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="hidden" name="assign_no" value="<%=assignVo.getAssign_no()%>">
								<%
									Date todayd = new Date();
									String display = "";
									int today = Integer.parseInt(fomatter2.format(todayd));
									int start = Integer.parseInt(fomatter2.format(assignVo.getAssign_start()));
									int end = Integer.parseInt(fomatter2.format(assignVo.getAssign_end()));
									if(today >= start && today <= end){
										if(!stu_assignFile.equals("")){
											display = "none";
											
									%>
									
									<a href="<%=request.getContextPath() %>/assign/subAssignDown.do?assign_path=<%=stuAssignVo.getAssign_path() %>" id="assignFileName"><%=stu_assignFile %></a>
									<input type="button" class="btn btn-primary" id="assignUpdateBtn" value="수정하기" style="float: right;">
									<%
											}
									%>
									
								
								<input type="file" id="assignfile" name="assignfile" style="display : <%=display %>;">
								<input type="button" class="btn btn-primary" id="saveAssignBtn" value="제출하기" style="display : <%=display %>; float: right;">
										
								<%
									}else{
								%>
								과제 제출기간이 아닙니다.	
										
								<%
									}
								%>
	        </form>
			<hr>
            <div style="text-align: center">
            	
            	<button type="button" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/assign/assignList.do'">
            		목록
           		</button>
			</div>
        </div>
      </div>
	</div>
</div>

<%@ include file="../footer.jsp"%>