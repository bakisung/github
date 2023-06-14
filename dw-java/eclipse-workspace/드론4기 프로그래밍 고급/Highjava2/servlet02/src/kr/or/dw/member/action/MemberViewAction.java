package kr.or.dw.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.member.service.IMemberService;
import kr.or.dw.member.service.MemberServiceImpl;
import kr.or.dw.vo.MemberVO;
import kr.or.dw.web.IAction;

public class MemberViewAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IMemberService service = MemberServiceImpl.getInstance();
		
		String mem_id = req.getParameter("mem_id");
		
		MemberVO memVo = service.getMember(mem_id);
		
		req.setAttribute("memDtl", memVo);
		
		return "/member/memberView.jsp";
	}

}
