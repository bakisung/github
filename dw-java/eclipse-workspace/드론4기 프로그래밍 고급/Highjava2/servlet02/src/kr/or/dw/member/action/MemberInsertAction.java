package kr.or.dw.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.member.service.IMemberService;
import kr.or.dw.member.service.MemberServiceImpl;
import kr.or.dw.vo.MemberVO;
import kr.or.dw.web.IAction;

public class MemberInsertAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IMemberService service = MemberServiceImpl.getInstance();
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String addr = req.getParameter("addr");
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(id);
		memVo.setMem_name(name);
		memVo.setMem_tel(tel);
		memVo.setMem_addr(addr);
		
		int result = service.insertMember(memVo);
		
		return "/member/memberList.do";
	}

}
