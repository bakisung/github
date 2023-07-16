package kr.or.dw.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public interface MemberService {
	
	// 로그인
	void login(String id, String password, HttpSession session) throws SQLException;
	
}
