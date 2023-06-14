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

public class InsertBulletinContentAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String bd_title = req.getParameter("bd_title");
		String bd_content = req.getParameter("bd_content");
		
		HttpSession session = req.getSession();
		String staff_id = (String)session.getAttribute("staff_id");
		
		System.out.println(staff_id);
		BoardVO boardVo = new BoardVO();
		boardVo.setBd_title(bd_title);
		boardVo.setBd_content(bd_content);
		boardVo.setStaff_id(staff_id);
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int bd_no = 0;
		int result = 0;
		if(req.getParameter("bd_no") != null) {
			bd_no = Integer.parseInt(req.getParameter("bd_no"));
			
			boardVo.setBd_no(bd_no);
			
			result = service.updateBulletinContent(boardVo);
			
		}else {
			
			bd_no = service.insertBulletinContent(boardVo);
			if(bd_no == 0) {
				result = 0;
			}else {
				result = 1;
			}
		}
		
		req.setAttribute("titleName", "게시판");
		
		return "/board/bulletinBoardView.do?bd_no=" + bd_no;
	}

}
