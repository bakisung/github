<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/nav.jsp" %>

<!-- Main Start -->
<main>
    <section class="py-5 text-center container" style="margin-top: 3em;">
        <div class="row">
            <div class="col-md-12" style="max-width: 80%">
                <form id="modifyForm">
                    <div class="card card-outline card-info">
                    	
                    	<input type="hidden" name="board_no" value="${board.board_no }">
                        <div class="card-header" style="display: flex; justify-content: space-between; align-items: center;">
						    <h4 style="margin: 0;">${board.title}</h4>
						    <div class="col-md" style="text-align: right;">
						        <button type="submit" class="btn btn-success" id="modifyFormBtn">수정</button>
						        <button type="button" class="btn btn-danger" id="returnBtn">돌아가기</button>
						    </div>
						</div>
						
						<div class="note-toolbar" role="toolbar" style="background-color: white;">
						    <div class="note-btn-group note-fontname" style="display: flex; justify-content: space-around;">
						        <div>작성자: ${board.writer}</div>
						        <div>작성일: ${board.regdate}</div>
						        <div>좋아요: ${board.like_count}</div>
						        <div>조회수: ${board.view_count}</div>
						    </div>
						</div>

                        <div class="card-body" style="min-height: 400px;">
                        	${board.content }
                        </div>
                        
						<div class="card-footer">
							<h5 style="display:inline;">첨부파일 : </h5>
							<button class="btn btn-xs btn-primary" type="button" id="addFileBtn">ADD FILE</button>
						</div>
						<div class="card-footer fileInput">
							<p>파일 위치입니다.</p>
						</div>
						
                        <div class="card-footer">
                            Visit <a href="https://github.com/summernote/summernote/">Summernote</a> documentation for more examples and information about the plugin.
                        </div>
                        
                    </div>
                </form>
            </div>
        </div>
    </section>
</main>
<!-- Main End -->

<%@ include file="../include/footer.jsp" %>

<script>
    $(document).ready(function() {
    	
    	// 게시글 등록
        $('#regist').on('submit', function (e) {
            e.preventDefault(); // 기본 제출 동작을 방지합니다.

            var title = $('#title').val();
            var content = $('#content').val();

            var data = JSON.stringify({ title: title, content: content });

            $.ajax({
                type: 'POST',
                url: '<%=request.getContextPath()%>/board',
                data: data,
                contentType: 'application/json; charset=UTF-8',
                success: function (data) {
                    console.log('성공 메세지 : ', data);
                    alert('게시글이 등록되었습니다.');
                    window.location.href = "<%=request.getContextPath()%>/board";
                },
                error: function (error) {
                    console.log('에러 메세지 : ', error);
                    alert('게시글 등록에 실패했습니다. 다시 시도해주세요.');
                }
            });
        });
    	
    	// 게시글 목록으로 돌아가기
    	$('#returnBtn').on('click', function () {
    		history.go(-1);
		})
		
		//게시글 수정 페이지로 이동
		$('#modifyFormBtn').on('click', function () {
			let form_object = $('form[id=modifyForm]');
			var board_no = $('input[name="board_no"]').val();
			
			form_object.attr({
				'action' : '/board/' + board_no + '/edit',
				'method' : 'get'
			});
		});
   		
    });
</script>
