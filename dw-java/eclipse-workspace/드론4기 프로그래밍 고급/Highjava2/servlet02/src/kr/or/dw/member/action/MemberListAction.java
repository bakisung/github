package kr.or.dw.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.member.service.IMemberService;
import kr.or.dw.member.service.MemberServiceImpl;
import kr.or.dw.vo.MemberVO;
import kr.or.dw.web.IAction;

public class MemberListAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String view = "";
		IMemberService memService = MemberServiceImpl.getInstance();
		List<MemberVO> memList = memService.getAllMember();
		
		req.setAttribute("memList", memList);
		view = "/member/memberList.jsp";
		
		HttpSession session = req.getSession();
		MemberVO testUser = new MemberVO();
		testUser.setMem_id("admin");
		testUser.setMem_name("관리자");
		testUser.setMem_tel("0707-4865-4195");
		testUser.setMem_addr("XXXXX");
		testUser.setMem_auth("B");
		session.setAttribute("testUser", testUser);
		
		return view;
	}
	
}
