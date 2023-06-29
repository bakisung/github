package kr.or.dw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import kr.or.dw.command.SearchCriteria;
import kr.or.dw.vo.PdsVO;

@Mapper
public interface PdsDAO {
	
	int insertPds(PdsVO pds) throws SQLException;

	List<PdsVO> selectSearchPdsList(SearchCriteria cri, RowBounds rowBounds) throws SQLException;

	int selectSearchPdsListCount(SearchCriteria cri) throws SQLException;

	PdsVO selectPdsByPno(int pno) throws SQLException;

	void increaseViewCnt(int pno) throws SQLException;

	void updatePds(PdsVO pds) throws SQLException;

	void deletePds(int pno) throws SQLException;
}
