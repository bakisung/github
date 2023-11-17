<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp" %>

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
                                <button type="submit" class="btn btn-success" id="registBtn">등록</button>
                                <button type="button" class="btn btn-danger" id="cancelBtn">취소</button>
                            </div>
                        </div>

                        <textarea class="summernote" id="content" name="content"></textarea>

                        <div class="form-group">
                            <div class="card-footer">
                                <h5 style="display:inline; line-height:40px;">첨부파일 : </h5>
                                <button class="btn btn-xs btn-primary" type="button" id="addFileBtn">ADD FILE</button>
                            </div>
                            <div class="card-footer fileInput">
                                <!-- 파일 업로드 부분 -->
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

        // 서머노트 (참조 : https://sirobako.co.kr/detail/29)
        $('.summernote').summernote({
            height: 400,
            lang: "ko-KR",
            focus: true,
            toolbar: [
                ['fontname', ['fontname']],
                ['fontsize', ['fontsize']],
                ['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
                ['color', ['forecolor', 'color']],
                ['table', ['table']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['height', ['height']],
                ['insert', ['picture', 'link', 'video']],
                ['view', ['codeview', 'fullscreen', 'help']]
            ],
            fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '돋음체', '바탕체'],
            fontSizes: ['8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72'],
            callbacks: {
                onImageUpload: function (files, editor, welEditable) {
					// 파일 업로드
					for (var i = files.length - 1; i >= 0; i--) {
						var fileName = files[i].name;
						
						// 이미지 alt 속성 삽입을 위한 설정
						var caption = prompt('이미지 설명 : ', fileName);
						
						if (caption == '') {
							caption = '이미지';
						}
						
						uploadSummernoteImageFile(files[i], this, caption);
					}
				}	// onImageUpload 종료
            }	// callbacks 종료
            
            // 이미지 업로드 함수 ajax 활용
            function uploadSummernoteImageFile(file, el, caption() {
				data = new FormData();
				data.append('file', file);
				
				$.ajax({
					data: data,
					type: 'POST',
					url: 'uploadSummernoteImageFile',
					contentType: false,
					enctype: 'multipart/form-data',
					processData: false,
					success: function (data) {
						$(el).summernote('editor.insertImage', data.url, 
							function ($image){
								$image.attr('alt', caption)	// 캡션 정보를 이미지의 alt 속성에 설정
							}; 
						);		
					};	// success 종료
				};	// ajax 종료
			};	// function 종료
            
        });	// summernote 종료

        // 등록을 취소한다.
        $('#cancelBtn').on('click', function () {
            history.go(-1);
        })

        // 파일 추가 버튼
        $('#addFileBtn').on('click', function() {
            if ($('input[name="uploadFile"]').length >= 5) {
                alert("파일 추가는 5개까지만 가능합니다");
                return;
            }

            var input = $('<input>').attr({
                "type": "file",
                "name": "uploadFile"
            }).css("display", "inline");

            var div = $('<div>').addClass("inputRow");
            div.append(input).append("<button style='border:0; outline:0;' class='badge bg-red' type='button' class='cancelBtn'>X</button>")
            div.appendTo('.fileInput');
        });

        // 파일 삭제 버튼
        $('div.fileInput').on('click', '.cancelBtn', function(){
            $(this).parent('div.inputRow').remove();
        });

        $('.fileInput').on('change', 'input[type="file"]', function() {
            if (this.files[0].size > 1024*1024*40) {
                alert("파일 용량이 40MB를 초과하였습니다.");
                this.value = "";
                $(this.focus());
                return;
            }
        });
    });
</script>
