package kr.or.dw.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.board.service.BoardServiceImpl;
import kr.or.dw.board.service.IBoardService;
import kr.or.dw.vo.BoardVO;
import kr.or.dw.web.IAction;

public class BulletinBoardViewAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int bd_no = 0;
		bd_no = Integer.parseInt(req.getParameter("bd_no"));
		
		IBoardService boardService = BoardServiceImpl.getInstance();
		BoardVO boardVo = null;
		
		boardVo = boardService.selectBulletinBoardView(bd_no);

		
		req.setAttribute("boardVo", boardVo);

		HttpSession session = req.getSession();
		String auth_cd = (String) session.getAttribute("auth_cd");
		
		req.setAttribute("titleName", "게시판");
		
		if(auth_cd.equals("S")) {
			return "/student/bulletinBoard/bulletinboardView.jsp";
		}else {
			return "/staff/bulletinBoard/bulletinboardView.jsp";
		}
	}

}
