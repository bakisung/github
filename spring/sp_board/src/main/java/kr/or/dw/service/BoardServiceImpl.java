package kr.or.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.or.dw.dao.BoardDAO;
import kr.or.dw.vo.BoardVO;

public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> boardList() {
		
		List<BoardVO> boardList = BoardDAO.GetBoardList();
		
		return null;
	}

}
