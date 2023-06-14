package kr.or.dw.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.board.service.BoardServiceImpl;
import kr.or.dw.board.service.IBoardService;
import kr.or.dw.vo.BoardVO;
import kr.or.dw.vo.ReplyVO;
import kr.or.dw.web.IAction;

public class StuBoardViewAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int bd_no = 0;
		bd_no = Integer.parseInt(req.getParameter("bd_no"));
//		String sta_id = (String) session.getAttribute("staff_id");
		String auth_cd = (String) session.getAttribute("auth_cd");
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		BoardVO boardVo = null;
		ReplyVO reVo = null;
		boardVo = boardService.selectStuBoardView(bd_no);
		reVo = boardService.selectStaffInfo(bd_no);
		
		req.setAttribute("boardVo", boardVo);
		req.setAttribute("reVo", reVo);
		
		req.setAttribute("titleName", "게시판");

		if(auth_cd.equals("S")) {
			return "/student/stuBoard/stuboardView.jsp";
		}else {
			return "/staff/stuBoard/stuboardView.jsp";
		}
	}

}
