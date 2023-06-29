package kr.or.dw.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.dw.command.SearchCriteria;
import kr.or.dw.vo.BoardVO;

public interface BoardService {
	Map<String, Object> selectBoardList(SearchCriteria cri) throws SQLException;

	void write(BoardVO board) throws SQLException;

	BoardVO selectBoard(int bno) throws SQLException;

	void modify(BoardVO board) throws SQLException;

	void remove(int bno) throws SQLException;
}
