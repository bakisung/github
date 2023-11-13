package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> selectBoardList() throws SQLException {
		
		List<BoardVO> boardList = null;
		boardList = boardDAO.selectBoardList();
		
		return boardList;
	
	}

	@Override
	public void registBoard(BoardVO boardVO) throws SQLException {
		
		System.out.println("현재 위치 : BoardServiceImpl\n" + "boardDAO.insertBoard(boardVO) 실행합니다.");
		boardDAO.insertBoard(boardVO);
		System.out.println("현재 위치 : BoardServiceImpl\n" + "boardDAO.insertBoard(boardVO) 실행 완료되었습니다.");
	
	}

	@Override
	public BoardVO selectBoardDetail(String board_no) throws SQLException {
		System.out.println("서비스 진입");
		System.out.println("BoardVO.getBoard_no : " + board_no);
		
		BoardVO board = boardDAO.selectBoardDetail(board_no);
		
		return board;
	}

}
