<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %>

<!-- SummerNote -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

<!-- Main Start -->
<main>

    <section class="py-5 text-center container" style="margin-top: 3em;">
        <div class="row">
            <div class="col-md-12" style="max-width: 80%">
                <form id="regist">
                    <div class="card card-outline card-info">
                        <div class="card-header">
                            <input class="card-title" id="title" name="title" style="display: inline; float: left; margin: 0.2em;">
                            <div class="col-md" style="float: right;">
                                <button type="submit" class="btn btn-success" id="registFormBtn">등록</button>
                                <button type="button" class="btn btn-danger" id="deleteBtn">취소</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <textarea class="summernote" id="content" name="content"></textarea>
                        </div>
                        <div class="form-group">
									<div class="card-header">
										<h5 style="display:inline; line-height:40px;">첨부파일 : </h5>
										<button class="btn btn-xs btn-primary" type="button" id="addFileBtn">ADD FILE</button>
									</div>
									<div class="card-footer fileInput">
									
									</div>
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

        $('#content').summernote({
        	height: 300,                 // set editor height
			minHeight: null,             // set minimum height of editor
			maxHeight: null,             // set maximum height of editor
			focus: true  ,
            disableResizeEditor: true,
            callbacks: {
                onImageUpload: function(files, editor, welEditable) {
                    for (let i = files.length - 1; i > -1; i--) {
                        if (files[i].size > 1024 * 1024 * 5) {
                            alert("이미지는 5MB 미만이어야 합니다.");
                            return;
                        }
                    }

                    // 파일 서버로 보내기
                    for (let i = files.length - 1; i >= 0; i--) {
                        sendFile(files[i], this);
                    }
                },
                onMediaDelete: function(target) {
                    if (confirm("삭제하시겠습니까?")) {
                        deleteFile(target[0].src);
                    }
                }
            }
        });
    });
</script>
