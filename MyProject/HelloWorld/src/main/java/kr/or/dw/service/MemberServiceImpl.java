package kr.or.dw.service;

import java.sql.SQLException;

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
	public void login(String id, String password, HttpSession session) throws SQLException {
		
		MemberVO member = memberDAO.selectMemberId(id);
		System.out.println(member);
		if (member != null && password.equals(member.getMember_password())) {
			System.out.println("로그인 성공\n회원의 정보를 세션에 저장합니다.");
			session.setAttribute("loginMember", member);
			session.setMaxInactiveInterval(5 * 600);
		} else {
			System.out.println("로그인 실패");
		}
		
	}

}
