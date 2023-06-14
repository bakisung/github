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
				location.href = "<%=request.getContextPath()%>/board/deleteBulletinContent.do?bd_no=<%=boardVo.getBd_no()%>";
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
            <h4 class="my-0 fw-normal" style="display:inline;"><%=boardVo.getBd_title()%></h4>
            <span class="mailbox-read-time float-right" style="float: right; vertical-align: middle;">&emsp;&emsp;작성일 : <%=fomatter.format(boardVo.getBd_wdt())%>&emsp;</span>
            <p style="float: right; margin: auto" >작성자 : 관리자</p>
          </div>
          <div class="card-body">
            <!-- content -->
		<div class="mailbox-read-message" style="margin: 1em;">
			<textarea class="click" readonly style="overflow: hidden;" onkeyup="autoResize(this)" onkeydown="autoResize(this)"><%=boardVo.getBd_content()%></textarea>
		</div>
			<br>
			<hr>
            <div style="text-align: center">
            <%
				if (((String)session.getAttribute("auth_cd")).equals("A")) {
			%>
            	<button type="button" style="float: right; width: 4em;" class="btn btn-danger" id="contentDelBtn">
            		삭제
				</button> 
				<button type="button" style="float: right; width: 4em; margin-right:0.5em;" class="btn btn-primary" onclick="location.href='<%=request.getContextPath()%>/board/bulletinContentInsertForm.do?bd_no=<%=boardVo.getBd_no()%>'">
					수정
				</button>
			<%
				}
			%>
            	<button type="button" class="btn btn-outline-dark" style="width: 6em; float: left;" onclick="location.href='<%=request.getContextPath()%>/board/bulletinBoardList.do'">
            		목록
           		</button>
			</div>
        </div>
      </div>
	</div>
</div>

<%@ include file="../footer.jsp"%>