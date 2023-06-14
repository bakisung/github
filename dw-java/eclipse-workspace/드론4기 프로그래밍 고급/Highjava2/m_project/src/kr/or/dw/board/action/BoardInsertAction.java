package kr.or.dw.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.board.service.BoardServiceImpl;
import kr.or.dw.board.service.IBoardService;
import kr.or.dw.board.vo.BoardVO;
import kr.or.dw.web.IAction;

public class BoardInsertAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		if( req.getParameter("bd_no") != null ) {
			int bd_no = Integer.parseInt(req.getParameter("bd_no"));
			IBoardService service = BoardServiceImpl.getInstance();
			BoardVO boardVo = service.selectBoardView(bd_no);
			req.setAttribute("boardVo", boardVo);
		}
		
		return "/board/boardInsert.jsp";
	}

}
