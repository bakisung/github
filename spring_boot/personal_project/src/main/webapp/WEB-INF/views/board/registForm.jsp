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
                                <button class="btn btn-danger" id="deleteBtn">삭제</button>
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
                url: '<%=request.getContextPath()%>/board/regist',
                data: data,
                contentType: 'application/json; charset=UTF-8',
                success: function (data) {
                    alert('게시글이 등록되었습니다.');
                    window.location.href = "<%=request.getContextPath()%>/board/main";
                },
                error: function (error) {
                	console.log('에러 메세지 : ', error);
                    alert('게시글 등록에 실패했습니다. 다시 시도해주세요.');
                }
            });
        });
    });
</script>
