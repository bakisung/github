<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
window.onload = function(){
	SmartEditor_summernote($('#content'));
	
	// 파일 삭제 버튼
	$('div.fileInput a[name="attachedFile"] > button').on('click', function() {
		let parent = $(this).parent('a[name="attachedFile"]');
		if (!confirm(parent.attr("attach-fileName") + " 파일을 삭제하시겠습니까?")) return false;
		
		let ano = parent.attr('attach-no');
		$(this).parents('li.attach-item').remove();
		
		let input = $('<input>').attr({
										'type' : 'hidden',
										'name' : 'deleteFtile',
										'value' : ano
		});
		$('form[role="form"]').prepend(input);
		
		return false;	// 버블링에 의해 작동되는 다운로드를 막기 위해 사용.
	})
	
	// 파일 추가 버튼
	$('#addFileBtn').on('click', function(){
		let attachedFile = $('a[name="attachedFile"]').length;
		let inputFile = $('input[name="uploadFile"]').length;
		let attachCount = attachedFile + inputFile; 
		
		if(attachCount >= 5){
			alert("파일 추가는 5개 까지만 가능합니다.");
			return;
		}
		
		let input = $('<input>').attr({
										"type" : "file",
										"name" : "uploadFile"
									}).css("display", "inline");
		let div = $('<div>').addClass("inputRow");
		div.append(input).append("<button style='border:0; outline:0;' class='badge bg-red' type='button' id='cancelBtn'>X</button>");
		div.appendTo('.fileInput');
	});
	
	// 파일 용량 체크
	$('.fileInput').on('change', 'input[type="file"]', function() {
		if (this.files[0].size > 1024*1024*40) {
			alert("파일 용량이 40MB를 초과하였습니다.");
			this.value="";
			$(this.focus());
			return;
		}
	})
	
	$('#modifyBtn').on('click', function() {
		let form = $('form[role="form"]');
		
		let files = $('input[name="uploadFile"]');
		for(let file of files){
			console.log(file.name + " : " + file.value);
			if(file.value == ""){
				alert("파일을 선택하세요.");
				file.focus();
				file.click();
				return;
			}
		}
		
		if($('#title').val() == ""){
			alert("제목은 필수입니다.");
			return;
		}
		
		if($('#content').length > 1000){
			alert("글자수가 1000자를 초과할 수 없습니다.");
			return;
		}
		
		form.submit();
	});
	
	$('#cancelBtn').on('click', function(){
		history.go(-1);
	});
	
}
</script>