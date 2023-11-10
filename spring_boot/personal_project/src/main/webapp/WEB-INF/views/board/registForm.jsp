<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %>

<!-- Main Start -->
<main>
    <section class="py-5 text-center container" style="margin-top: 3em;">
        <div class="row">
            <div class="col-md-12">
                <form id="regist">
                    <div class="card card-outline card-info">
                        <div class="card-header">
                            <input class="card-title" id="title" name="title" style="display: inline; float: left; margin: 0.2em;">
                            <div class="col-md" style="float: right;">
                                <button type="submit" class="btn btn-success" id="registFormBtn">등록</button>
                                <button type="button" class="btn btn-danger" id="deleteBtn">취소</button>
                            </div>
                        </div>
                        <div class="card-body">
                            <textarea id="content" name="content" placeholder="내용을 입력하세요" style="width:100%; height:200px;"></textarea>
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
    });
</script>

<!-- 
2023.11.10 ajax 전송이 안되는 현상

클라이언트 측 코드 수정:
dataType: 'json'을 명시했으므로, 서버에서 전송한 데이터가 올바른 JSON 형식이 아니면 parsererror가 발생합니다.
클라이언트 측에서는 dataType을 명시적으로 처리하는 대신에 contentType을 사용할 수 있습니다. dataType을 삭제하고, contentType을 다음과 같이 수정해보세요:
 -->
