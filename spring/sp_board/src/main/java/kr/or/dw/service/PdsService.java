package kr.or.dw.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.dw.command.SearchCriteria;
import kr.or.dw.vo.PdsVO;

public interface PdsService {
	
	void regist(PdsVO pds) throws SQLException;

	Map<String, Object> selectPdsList(SearchCriteria cri) throws SQLException;

	PdsVO selectPds(int pno, String from) throws SQLException;

	void modify(PdsVO pds) throws SQLException;

	void remove(int pno) throws SQLException;
	
}
