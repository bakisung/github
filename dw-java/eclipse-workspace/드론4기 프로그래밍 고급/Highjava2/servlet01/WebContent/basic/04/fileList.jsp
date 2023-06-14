<%@page import="java.util.List"%>
<%@page import="kr.or.dw.basic.upload.UploadDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet File Upload/Download</title>
</head>
<body>
	<h2>업로드된 파일 목록</h2>
	<table border="1">
		<tr>
			<th>파일명</th><th>파일크기</th><th>업로드상태</th><th>비고</th>
		</tr>
		<%
			List<UploadDetail> uploadDetails = (List<UploadDetail>)request.getAttribute("uploadFileList");
			if(uploadDetails != null && uploadDetails.size() > 0){
				for(int i = 0; i < uploadDetails.size(); i++){
		%>
			<tr>
				<td><%= uploadDetails.get(i).getFileName() %></td>
				<td><%= uploadDetails.get(i).getFileSize() %></td>
				<td><%= uploadDetails.get(i).getUploadStatus() %></td>
				<td><a href="<%= request.getContextPath()%>/FileDownloadServlet.do?fileName=<%=uploadDetails.get(i).getFileName()%>">DownLoad</a></td>
			</tr>
		<% 
				}
			}
		%>
	</table>
	<hr>
	<a href="<%= request.getContextPath() %>/basic/04/fileUploadTest.jsp">파일 업로드 문서로 가기</a>
</body>
</html>