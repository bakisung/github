package kr.or.dw.board.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.dw.board.service.BoardServiceImpl;
import kr.or.dw.board.service.IBoardService;
import kr.or.dw.vo.ReplyVO;
import kr.or.dw.web.IAction;

public class StuBoardReplyUpdateAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IBoardService boardService = BoardServiceImpl.getInstance();
		ReplyVO reVo = new ReplyVO();
		BeanUtils bean = new BeanUtils();
		
		try {
			bean.populate(reVo, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		boardService.stuBoardReplyUpdate(reVo);
		
		req.setAttribute("titleName", "게시판");
		
		return null;
	}

}
