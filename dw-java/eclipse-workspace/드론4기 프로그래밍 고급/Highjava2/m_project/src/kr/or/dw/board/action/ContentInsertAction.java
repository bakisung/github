package kr.or.dw.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.board.service.BoardServiceImpl;
import kr.or.dw.board.service.IBoardService;
import kr.or.dw.board.vo.BoardVO;
import kr.or.dw.user.vo.UserVO;
import kr.or.dw.web.IAction;

public class ContentInsertAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		UserVO userVo = (UserVO) session.getAttribute("userVO");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVO boardVo = new BoardVO();
		boardVo.setBd_title(title);
		boardVo.setBd_content(content);
		boardVo.setUser_no(userVo.getUser_no());
		boardVo.setNick(userVo.getNick());
		
		IBoardService service = BoardServiceImpl.getInstance();
		int bd_no = 0;
		
		// 글 수정일 때
		if(req.getParameter("bd_no") != null) {
			bd_no = Integer.parseInt(req.getParameter("bd_no"));
			boardVo.setBd_no(bd_no);
			int result = service.updateContent(boardVo);
		}else {
			// 글 등록 일때
			bd_no = service.insertContent(boardVo);
		}
		
		return "/board/boardView.do?bd_no=" + bd_no;
	}
	
}
