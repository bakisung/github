<%@page import="kr.or.dw.board.vo.ReplyVO"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="kr.or.dw.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../user/header.jsp" %>

<%
	BoardVO boardVo = (BoardVO)request.getAttribute("boardVo");
	List<ReplyVO> replyList = (List<ReplyVO>)request.getAttribute("replyList");
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	if(boardVo.getPic_path() != null){
		src = "/profilePath/" + boardVo.getPic_path();
	}
%>

<script>
	$(function(){
		
		function replyTemplate(reply){
			let replySrc = "/profilePath/default/defaultProfile.jpg";
			
			if(reply.pic_path != null || reply.pic_path != ""){
				replySrc = "/profilePath/" + reply.pic_path
			};
			
// 			let deleteBtn = '<i class="fas fa-times"></i>';
			
<%-- 			if("<%=vo.getNick()%>" != reply.nick){ --%>
// 				deleteBtn = '';
// 			};
			
			$('#re_container').prepend(
				'<div class="row">'
			   +'	<div class="col-md-4">'
			   +'		<div class="user-block">'
			   +'			<img class="img-circle img-bordered-sm" src="' + replySrc + '" alt="user image">'
			   +'				<span class="username">' 
			   +'				<a href="#">' + reply.nick + '</a>'
			   +'					<a href="#" class="float-right btn-tool">'
			   +'						<i class="fas fa-times"></i>'
			   +'					</a>'
			   +'				</span>'
			   +'			<span class="description">' + reply.re_wdt + '</span>'
			   +'		</div>'
			   +'	</div>'
			   +'	<div class="col-md-8">' + reply.re_content + '</div>'
			   +'</div><hr style="margin: 0">'
			);
			
		};
		
		function replyUpdateTemplate(target, update_re_no, update_re_content){
			
			$(target).after(
				 '<form id="re_update_form">'
				+	'<div class="form-group d-flex">'
				+		'<input type="hidden" name="update_re_no" value="' + update_re_no + '">'
				+		'<input type="text" name="update_re_content" value="' + update_re_content + '">'
				+		'<a class="btn btn-default btn-sm" href="#">취소</a>'
				+		'<input type="submit" hidden>'
				+	'</div>'
				+'</form>'
			)
		}
		
		// 댓글 등록
		$('#re_form').on('submit', function(e){
			e.preventDefault();
			
			let re_content = $('#re_form').find('input').val();
			let bd_no = "<%=boardVo.getBd_no()%>";
			
			$.ajax({
				url : "<%=request.getContextPath()%>/board/reply.do",
				dataType : "json",
				method : "post",
				data : {
					cmd : "insert",
					bd_no : bd_no,
					re_content : re_content
				},
				success : function(res){
					
					replyTemplate(res.reply);
				},
				error : function(){
					
				}
			});
		});
		
		// 댓글 수정
		$(document).on('click', '.reply-update-btn', function(e){
			let target = $(this).closest('div .row').find('.reply-update');
			let updateReplyNo = $(this).parents('.icon-block').find('input[type=hidden]').val();
			let bd_no = "<%=boardVo.getBd_no()%>";
			let updateReplyContent = $(target).text();
			replyUpdateTemplate(target, updateReplyNo, updateReplyContent);
			$(target).hide();
			
			$('#re_update_form').on('submit', function(e){
				e.preventDefault();
				let re_update_form = $(this);
				let update_content = re_update_form[0].update_re_content.value;
				
				$.ajax({
					url : "<%=request.getContextPath()%>/board/reply.do",
					type : "post",
					dataType : "json",
					data : {
						cmd : "update",
						re_no : updateReplyNo,
						re_content : update_content,
						bd_no : bd_no
					},
					success : function(res){
						if(res.result == 1){
							$(target).text(update_content);
							re_update_form.remove();
							$(target).show();
						}
					},
					error : function(err){
						alert(err.status);
					}
				});
			});
		});
		
		// 댓글 삭제
		$(document).on('click', '.reply-delete-btn', function(e){
			if(confirm("삭제하시겠습니까?")){
				let deleteReplyNo = $(this).parents('.icon-block').find('input[type=hidden]').val();
				let target = $(this).closest('div .row');
				$.ajax({
					url : "<%=request.getContextPath()%>/board/reply.do",
					type : "post",
					dataType : "json",
					data : {
						cmd : "delete",
						re_no : deleteReplyNo,
						bd_no : "<%=boardVo.getBd_no()%>"
					},
					success : function(res){
						if(res.result == 1){
							$(target).remove();
						}
					},
					error : function(err){
						alert(err.status);
					}
				});
			}
		});
	});
</script>

<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="card card-primary card-outline">
					<div class="card-header">
						<h3><%= boardVo.getBd_title() %></h3>
					</div>

					<div class="card-body p-0">
						<div class="mailbox-read-info">
							<div class="image">
								<img style="width: 5%;" src="<%=src%>" class="img-circle elevation-2">
								<%= boardVo.getNick() %>
							</div>
							<h6>
								<span class="mailbox-read-time float-right"><%= boardVo.getBd_wdt() %></span>
							</h6>
						</div>

						<div class="mailbox-read-message">
							<p><%= boardVo.getBd_content() %></p>
						</div>

					</div>

					<div class="card-footer">
						<div class="float-right">
						<% if ( vo != null && boardVo.getUser_no() == vo.getUser_no() ) { %>
							<a type="button" class="btn btn-default btn-sm" href="<%= request.getContextPath()%>/board/deleteContent.do?bd_no=<%=boardVo.getBd_no()%>">
								<i class="far fa-trash-alt"></i> 삭제
							</a>
							<a type="button" class="btn btn-default btn-sm" href="<%= request.getContextPath()%>/board/boardInsert.do?bd_no=<%=boardVo.getBd_no()%>">
								<i class="fas fa-pen"></i> 수정
							</a>
						<% } %>
							<a type="button" class="btn btn-default btn-sm" href="<%= request.getContextPath()%>/board/boardMain.do">
								<i class="fas fa-reply"></i> 목록
							</a>
						</div>
						<hr>
						<p>
							<a href="#" class="link-black text-sm mr-2"><i
								class="fas fa-share mr-1"></i> Share</a> <a href="#"
								class="link-black text-sm"><i class="far fa-thumbs-up mr-1"></i>
								Like</a> <span class="float-right"> <a href="#"
								class="link-black text-sm"> <i class="far fa-comments mr-1"></i>
									Comments (5)
							</a>
							</span>
						</p>
						<form id="re_form">
							<input class="form-control form-control-sm" type="text" placeholder="Type a comment">
							<button type="submit" hidden></button>
						</form>
					</div>
				</div>
				<div class="card" id="re_container">
				<% 	
					for(ReplyVO replyVo : replyList) {
					String hidden = "hidden";
						if(vo != null && vo.getNick().equals(replyVo.getNick())) {
							hidden = "";
						};
				%>
					<div class="row">
						<div class="col-md-4 d-flex">
							<div class="user-block col-md-8">
								<img class="img-circle img-bordered-sm" src="<%= replyVo.getPic_path() == null ? "/profilePath/default/defaultProfile.jpg" : "/profilePath/" + replyVo.getPic_path() %>" alt="user image"> 
								<span class="username">
									<a href="#"><%= replyVo.getNick() %></a>
								</span>
								<span class="description"><%= replyVo.getRe_wdt() %></span>
							</div>
							<div class="icon-block col-md-4 align-self-center">
								<input type="hidden" value="<%=replyVo.getRe_no()%>">
								<a href="#" class="float-right btn-tool reply-delete-btn">
									<i class="fas fa-times" <%=hidden %>></i>
 								</a>
								<a href="#" class="float-right btn-tool reply-update-btn">
									<i class="fas fa-pen" <%=hidden %>></i>
 								</a>
							</div>
						</div>
						<div class="col-md-8 align-self-center">
							<div class="reply-update"><%= replyVo.getRe_content() %></div>
						</div>
					</div><hr style="margin: 0">
				<% } %>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</div>

<%@ include file="../user/footer.jsp" %>