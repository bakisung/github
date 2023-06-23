package kr.or.dw.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.dw.command.SearchCriteria;

public interface BoardService {
	Map<String, Object> selectBoardList(SearchCriteria cri) throws SQLException;
}
