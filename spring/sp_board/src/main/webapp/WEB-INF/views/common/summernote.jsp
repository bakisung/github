<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function SmartEditor_summernote(target){
		target.summernote({
			placeholder : '여기에 내용을 적으세요.',
			height : 250,
			disableResizeEditor : true,
			callbacks : {
				onImageUpload : function(files, editor, welEditable) {
					for (let i = files.length -1; i > -1; i--) {
						if (files[i].size > 1024 * 1024 * 5) {
							alert("이미지는 5MB 미만이어야 합니다.");
							return;
						};
					};
					
					// 파일 서버로 보내기
					for (let i = files.length -1; i >= 0; i--) {
						sendFile(files[i], this);
					}
				}
			}
		});
	};
	
	function sendFile(file, el){
		let form_data = new FormData();
		form_data.append("file", file);
		$.ajax({
			url : '<%=request.getContextPath()%>/uploadImg.do',
			type : 'post',
			data : form_data,
			contentType : false,	// 사진 파일 보낼때 꼭 입력해줘야한다.
			processData : false,	// 사진 파일 보낼때 꼭 입력해줘야한다.
			success : function(img_url) {
				alert(img_url);
			}
		});
	}
</script>