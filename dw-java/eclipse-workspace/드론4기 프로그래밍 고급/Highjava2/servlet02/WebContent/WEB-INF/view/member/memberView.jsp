<%@page import="kr.or.dw.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 상세 보기</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.5.1.js"></script>
<script>
	<%
		MemberVO memVo = (MemberVO)request.getAttribute("memDtl");
	%>
	$(function(){
		let changeFlag = false;
		let mem_name = "<%= memVo.getMem_name()%>";
		let mem_tel = "<%= memVo.getMem_tel()%>";
		let mem_addr = "<%= memVo.getMem_addr()%>";
		let oldValArr = [mem_name, mem_tel, mem_addr];
		
		$('#memberUpdateForm').on('propertychange keyup paste', function(){
			let inputArr = $(this).find('input[type=text]');
			for(let i = 0; i < inputArr.length; i++){
// 				console.log('inputArr의 ' + (i+1) + '번째 값 : ' + $(inputArr[i]).val());
// 				console.log('oldValArr의 ' + (i+1) + '번째 값 : ' + oldValArr[i]);
				if($(inputArr[i]).val() == oldValArr[i]){
					changeFlag = false;
				}else{
					changeFlag = true;
					break;
				};
			};
		});
		
		$('#listBtn').on('click', function(){
			location.href = "<%= request.getContextPath()%>/member/memberList.do";
		});
		
		$('#updateBtn').on('click', function(){
			if(changeFlag == true){
				$('#memberUpdateForm').submit();
			}else{
				alert("변경된 정보가 없습니다.");
			}
		});
		
		$('#deleteBtn').on('click', function(){
			location.href="<%= request.getContextPath()%>/member/memberDelete.do?mem_id=<%= memVo.getMem_id()%>";
		});
	})
</script>
</head>
<body>
	<h2>회원 정보 상세 보기</h2>
	<form id="memberUpdateForm" method="post" action="<%= request.getContextPath()%>/member/memberUpdate.do">
		<table border="1">
			<tr>
				<td>회원ID</td>
				<td><%= memVo.getMem_id() %></td>
				<input type="hidden" name="id" value="<%= memVo.getMem_id() %>">
			</tr>
			<tr>
				<td>회원이름</td>
				<td><input type="text" name="name" value="<%= memVo.getMem_name()%>"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" value="<%= memVo.getMem_tel()%>"></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><input type="text" name="addr" value="<%= memVo.getMem_addr()%>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="저장" id="updateBtn">
					<input type="button" value="삭제" id="deleteBtn">
					<input type="button" value="회원목록" id="listBtn">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>