package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.vo.BoardVO;

public interface BoardService {

	List<BoardVO> selectBoardList() throws SQLException;
	
	void registBoard(BoardVO boardVO) throws SQLException;

	BoardVO selectBoardDetail(String board_no) throws SQLException;

}
