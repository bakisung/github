<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request 연습</title>
</head>
<body>
	<h2>Request 연습 form</h2>
	<hr>
	<form name="requestTestForm" action="/servlet01/requestTest.do">
		<table border='1'>
			<tr>
				<td>이름</td>
				<td><input type="text" size="10" name="userName"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<select name="job">
						<option value="a">무직</option>
						<option value="b">회사원</option>
						<option value="c">전문직</option>
						<option value="d">학생</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<input type="checkbox" name="hobby" value="travel">여행
					<input type="checkbox" name="hobby" value="game">게임
					<input type="checkbox" name="hobby" value="exercise">운동
					<input type="checkbox" name="hobby" value="hiking">등산
					<input type="checkbox" name="hobby" value="dev">개발
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;">
					<input type="submit" value="확인">
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>