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
   		
    	// 서머노트
	    $('.summernote').summernote({
	        // 에디터 높이
	        height: 400,
	        // 에디터 한글 설정
	        lang: "ko-KR",
	        // 에디터에 커서 이동 (input창의 autofocus라고 생각)
	        focus : true,
	        toolbar: [
	            // 글꼴 설정
	            ['fontname', ['fontname']],
	            // 글자 크기 설정
	            ['fontsize', ['fontsize']],
	            // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
	            ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
	            // 글자색
	            ['color', ['forecolor','color']],
	            // 표만들기
	            ['table', ['table']],
	            // 글머리 기호, 번호매기기, 문단정렬
	            ['para', ['ul', 'ol', 'paragraph']],
	            // 줄간격
	            ['height', ['height']],
	            // 코드보기, 확대해서보기, 도움말
	            ['view', ['codeview','fullscreen', 'help']]
	        ],
	        // 추가한 글꼴
	        fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
	        // 추가한 폰트사이즈
	        fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
	    });
    	
	 	// 수정을 취소한다.
    	$('#canselBtn').on('click', function () {
    		history.go(-1);
		})
    
    });
</script>
