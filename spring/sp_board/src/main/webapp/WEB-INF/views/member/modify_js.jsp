<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	
window.onload = function(){
	let imageURL = "getPicture.do?picture=${member.picture}";	// 이미지명 가지고 와서 셋팅
	$('div#pictureView').css({
								'background-image' : 'url(' + imageURL + ')',
								'background-repeat' : 'no-repeat',
								'background-position' : 'center',
								'background-size' : 'cover',
							});
	$('#modifyBtn').on('click', function(){
		$('form[role="form"]').submit();
	});
	$('#cancelBtn').on('click', function(){
		history.go(-1);
	});
	
}

function imageChange_go(){
		let inputImage = $('input#inputFile')[0];
		preViewPicture(inputImage, $('div#pictureView'));
		$('input[name="uploadPicture"]').val(inputImage.files[0].name);
};
	
</script>