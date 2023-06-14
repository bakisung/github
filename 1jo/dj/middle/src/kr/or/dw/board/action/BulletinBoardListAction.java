package kr.or.dw.board.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.board.service.BoardServiceImpl;
import kr.or.dw.board.service.IBoardService;
import kr.or.dw.util.PaginationUtil;
import kr.or.dw.vo.BoardVO;
import kr.or.dw.web.IAction;

public class BulletinBoardListAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		//페이징처리
		Map<String, Integer> pagingConfigMap = null;
		PaginationUtil pagination = new PaginationUtil();
		String pageParam = req.getParameter("page");	//사용자가 선택한 페이지번호
		int page = (pageParam == null ? 1 : Integer.parseInt(pageParam));
		// 추가
		String search = "";
		if(req.getParameter("search") == null) {
			search = "%%";
		}else {
			search = "%" + req.getParameter("search") + "%";
		}
		
		
		
		int totalCount = service.selectBoardCount(search);
		
		pagination.setConfig(page, 10, 10, totalCount);
		pagingConfigMap = pagination.getConfig();
		
		//ibatis에서 받을 parameterMap을 만든다.
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", pagingConfigMap.get("start"));
		paramMap.put("end", pagingConfigMap.get("end"));
		//추가
		paramMap.put("search", search);
		
		//게시판 목록을 가져온다.
		List<BoardVO> boardList = service.selectBoardList(paramMap);
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("pagingConfigMap", pagination);
		HttpSession session = req.getSession();
		String auth_cd = (String) session.getAttribute("auth_cd");
		
		req.setAttribute("titleName", "게시판");
		
		if(auth_cd.equals("S")) {
			return "/student/bulletinBoard/bulletinboard.jsp";
		}else {
			return "/staff/bulletinBoard/bulletinboard.jsp";
		}
	}

}
