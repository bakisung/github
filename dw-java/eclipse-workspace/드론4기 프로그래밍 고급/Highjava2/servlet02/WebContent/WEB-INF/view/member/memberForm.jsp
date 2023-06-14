<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력 폼</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
<script>
	$(function(){
		$('#resetBtn').on('click', function(){
			location.href = "<%= request.getContextPath()%>/member/memberList.do";
		});
		
		let chkFlag = false;	// 중복확인을 했는지 확인하는 변수
		
		$('#check').on('click', function(){
			let memId = $('#mem_id').val();
			if(memId == ""){
				alert("아이디를 입력하세요.");
				$('#mem_id').focus;
				return;
			};
			
			$.ajax({
				url : "<%= request.getContextPath()%>/member/memberIdCheck.do",
				method : "post",
				data : {"mem_id" : memId},
				dataType : "json",
				success : function(res){
					if(res == "OK"){	// 중복되지 않을 때
						$('#idChkResult').html("사용가능ID").css("color", "green");
						chkFlag = true;
					}else{	// 중복될 때
						$('#idChkResult').html("ID중복 - 사용불가").css("color", "red");
						chkFlag = false;
					}
				},
				error : function(){
					
				}
			});
		});
		
		// ID를 입력하는 input 의 값이 변경될 때
		$('#mem_id').on('change', function(){
			chkFlag = false;
		});
		
		// 저장버튼 클릭 ==> form의 submit 될 때
		$('#saveBtn').on('click', function(){
			if(chkFlag){
				$('#memberInsertForm').submit();
			}else{
				alert("ID 중복확인을 해주세요.");
			}
		});
	})
</script>
</head>
<body>
	<h2>회원 정보 입력 폼</h2>
	<form id="memberInsertForm" method="post" action="<%= request.getContextPath()%>/member/memberInsert.do">
		<table border="1">
			<tr>
				<td>회원ID</td>
				<td>
					<input type="text" name="id" id="mem_id">
					<input type="button" value="중복확인" id="check">
					<br><span id="idChkResult"></span>
				</td>
			</tr>
			<tr>
				<td>회원이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel"></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><input type="text" name="addr"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="저장" id="saveBtn">
					<input type="button" value="취소" id="resetBtn">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>