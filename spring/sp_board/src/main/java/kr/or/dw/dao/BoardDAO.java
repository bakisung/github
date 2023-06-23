package kr.or.dw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import kr.or.dw.command.SearchCriteria;
import kr.or.dw.vo.BoardVO;

@Mapper		// Mapper는 DB로 바로 연결해주는 어노테이션이다.
public interface BoardDAO {

	List<BoardVO> selectSearchBoardList(SearchCriteria cri, RowBounds rowbounds) throws SQLException;

	int selectSearchBoardListCount(SearchCriteria cri) throws SQLException;
 
}
