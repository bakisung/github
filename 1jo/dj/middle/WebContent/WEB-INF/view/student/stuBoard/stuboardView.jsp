<%@page import="kr.or.dw.vo.ReplyVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.dw.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>    
<%
	BoardVO boardVo = (BoardVO) request.getAttribute("boardVo");

	DateFormat fomatter = new SimpleDateFormat("yyyy-MM-dd");

%>

<script>
	$(function(){
		$('#contentDelBtn').on('click', function(){
			if(confirm("정말 삭제하시겠습니까?") == true){
				location.href = "<%=request.getContextPath()%>/board/deleteStuContent.do?bd_no=<%=boardVo.getBd_no()%>";
				};
		});
		$('#re_contentView').show();
		$('#re_contentUpdateForm').on('click', function(){
			$('#re_contentUpdate').show();
			$('#re_contentView').hide();
			$('#re_contentUpdateForm').hide();
			$('#re_contentSave').show();
			$('#re_contentReset').show();
		});
		
		let test2 = $('.click');
		let sch2 = test2.prop('scrollHeight');
		test2.css('height', sch2);

		let test = $('.click2');
		let sch = test.prop('scrollHeight');
		test.css('height', sch);
	});
	
	function autoResize(textarea) {
		  textarea.style.height = 'auto';
		  console.log(textarea.scrollHeight)
		  textarea.style.height = textarea.scrollHeight + 'px';
	}
</script>

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

	.click2:focus {
		outline: none;
	}
	
	.click2 {
		border: white;
		resize: none; 
		width: 100%;
		height: 100%;
	}
</style>
	
<div class="col-md-7 col-lg-7" style="margin: 0 auto;">
	<div class="col">
		<div class="card mb-4 rounded-3 shadow-sm">
			<div class="card-header py-3">
				<h4 class="my-0 fw-normal" style="display:inline;"><%=boardVo.getBd_title()%></h4>
	            <span class="mailbox-read-time float-right" style="float: right; vertical-align: middle;">&emsp;&emsp;작성일 : <%=fomatter.format(boardVo.getBd_wdt())%>&emsp;</span>
	            <p style="float: right; margin: auto" >작성자 : <%=boardVo.getStu_name() %></p>
			</div>
			<div class="card-body">
		            <!-- content -->
				<div class="mailbox-read-message" style="margin: 1em;">
					<textarea class="click" readonly style="overflow: hidden;" onkeyup="autoResize(this)" onkeydown="autoResize(this)"><%=boardVo.getBd_content()%></textarea>
				</div>
				<br>
				<hr>
					<% 
					ReplyVO reVo = null;
					if(request.getAttribute("reVo") != null){
					    reVo = (ReplyVO)request.getAttribute("reVo");
					}
						if(reVo != null){ 
					%>
							<!-- 관리자 답변 -->
					<div class="card mb-4 rounded-3 shadow-sm">
						<div class="py-3">
							<p class="my-0 fw-normal" style="display:inline; margin-left:20px;">관리자 답변입니다.</p>
				            <span class="mailbox-read-time float-right" style="float: right; vertical-align: middle;">&emsp;&emsp;작성일 : <%=reVo.getRe_wdt().split(" ")[0]%>&emsp;</span>
							<hr>
						</div>
						<div class="card-body" style="margin-top:-1em">
				            <!-- content -->
							<div class="mailbox-read-message" style="text-align:left; vertical-align:top">
								<textarea id="re_contentView" class="click2" style="display:none;" readonly>><%=reVo.getRe_content()%></textarea>
								<textarea id="re_contentUpdate" class="form-control" style="display:none; overflow:hidden;" onkeyup="autoResize(this)" onkeydown="autoResize(this)"><%=reVo.getRe_content()%></textarea>
							</div>
						</div>
					</div>
					<%} %>
				<div style="text-align: center">
					<%
						if (((String)session.getAttribute("stu_id")).equals(boardVo.getStu_id())) {
					%>
						<button type="button" style="float: right; width: 4em;" class="btn btn-danger" id="contentDelBtn">
		            		삭제
						</button> 
						<button type="button" style="float: right; width: 4em; margin-right:0.5em;" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/board/stuContentInsertForm.do?bd_no=<%=boardVo.getBd_no()%>'">
							수정
						</button>
					<%
						}
					%>
						<button type="button" class="btn btn-outline-dark" style="width: 6em; float: left;" onclick="location.href='<%=request.getContextPath()%>/board/stuBoardList.do'">
		            		목록
		           		</button>
					</div>
			</div>
		</div>
	</div>
</div>
					
<%@ include file="../footer.jsp"%>