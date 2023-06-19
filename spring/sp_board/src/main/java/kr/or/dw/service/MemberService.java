package kr.or.dw.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import kr.or.dw.vo.MemberVO;
import kr.or.dw.vo.MenuVO;

public interface MemberService {
	
	// 로그인
	void login(String id, String pwd, HttpSession session) throws SQLException;
	
	// 회원 목록 조회
	List<MemberVO> MemberList() throws SQLException;

	MemberVO selectMemberById(String id) throws SQLException;
}
