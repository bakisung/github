<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String nick = (String)request.getAttribute("userNick");
	if(nick == null) {	// 사용 가능
%>
	{"chk" : "사용 가능한 닉네임입니다."}
	
<%  }else{ %>	<!-- 사용 불가능 -->

	{"chk" : "중복된 닉네임입니다. 다른 닉네임을 입력해 주세요!"}
	
<%	} %>