package kr.or.dw.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.board.service.BoardServiceImpl;
import kr.or.dw.board.service.IBoardService;
import kr.or.dw.board.vo.ReplyVO;
import kr.or.dw.user.vo.UserVO;
import kr.or.dw.web.IAction;

public class ReplyAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		HttpSession session = req.getSession();
		UserVO userVo = (UserVO) session.getAttribute("userVO");
		
		int user_no = userVo.getUser_no();
		int bd_no = Integer.parseInt(req.getParameter("bd_no"));
		String re_content = req.getParameter("re_content");
		String nick = userVo.getNick();
		String cmd = req.getParameter("cmd");
		
		/*
		 * String cmd
		 * 댓글 관련 Action을 하나만 사용하기 위해서
		 * parameter 를 사용하여 로직을 구분한다.
		 * 
		 * "insert" : 댓글 등록
		 * "update" : 댓글 수정
		 * "delete" : 댓글 삭제
		 */
		
		if(cmd.equals("insert")) {
			ReplyVO replyVo = new ReplyVO();
			replyVo.setBd_no(bd_no);
			replyVo.setUser_no(user_no);
			replyVo.setNick(nick);
			replyVo.setRe_content(re_content);
			
			int re_no = service.insertReply(replyVo);
			ReplyVO resultReplyVo = service.selectReply(re_no);
			
			req.setAttribute("replyVo", resultReplyVo);
		}else if(cmd.equals("update")) {
			int re_no = Integer.parseInt(req.getParameter("re_no"));
			ReplyVO replyVo = new ReplyVO();
			replyVo.setRe_no(re_no);
			replyVo.setRe_content(re_content);
			
			int result = service.updateReply(replyVo);
			
			req.setAttribute("result", result);
		}else if(cmd.equals("delete")) {
			int re_no = Integer.parseInt(req.getParameter("re_no"));
			int result = service.deleteReply(re_no);
			
			req.setAttribute("result", result);
		}
		
		return "/board/reply_ajax.jsp";
	}

}
