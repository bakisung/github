package kr.or.dw.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import kr.or.dw.command.SearchCriteria;
import kr.or.dw.vo.MemberVO;

public interface MemberService {
	
	// 로그인
	void login(String id, String pwd, HttpSession session) throws SQLException;
	
	List<MemberVO> selectAllMemberList() throws SQLException;

	MemberVO selectMemberById(String id) throws SQLException;
	
	void regist(MemberVO member) throws SQLException;

	void modify(MemberVO member) throws SQLException;

	void remove(String id) throws SQLException;

	void disabled(String id) throws SQLException;

	void enabled(String id) throws SQLException;

	Map<String, Object> selectSearchMemberList(SearchCriteria cri) throws SQLException;
	
}
