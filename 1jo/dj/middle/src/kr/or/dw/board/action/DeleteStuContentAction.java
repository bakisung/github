package kr.or.dw.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.board.service.BoardServiceImpl;
import kr.or.dw.board.service.IBoardService;
import kr.or.dw.web.IAction;

public class DeleteStuContentAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int bd_no = Integer.parseInt(req.getParameter("bd_no"));
		IBoardService service = BoardServiceImpl.getInstance();
		
		int result = 0;
		result = service.deleteStuContent(bd_no);
		
		req.setAttribute("titleName", "게시판");
		
		
		return "/board/stuBoardList.do";
	}

}
