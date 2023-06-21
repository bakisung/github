package kr.or.dw.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.dw.dao.MemberDAO;
import kr.or.dw.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void login(String id, String pwd, HttpSession session) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		
		if(pwd.equals(member.getPwd())) {
			System.out.println("[로그인 성공!!!] 회원의 정보를 세션에 저장합니다.");
			session.setAttribute("loginUser", member);
			session.setMaxInactiveInterval(5 * 60);
		}
	}

	@Override
	public List<MemberVO> selectAllMemberList() throws SQLException {
		List<MemberVO> memberList = memberDAO.selectAllMemberList();
		return memberList;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		memberDAO.insertMember(member);
	}

	@Override
	public void modify(MemberVO member) throws SQLException {
		memberDAO.updateMember(member);
	}

	@Override
	public void remove(String id) throws SQLException {
		memberDAO.deleteMember(id);
	}

	@Override
	public void disabled(String id) throws SQLException {
		memberDAO.disabledMember(id);
	}

	@Override
	public void enabled(String id) throws SQLException {
		memberDAO.enabledMember(id);
	}

}
