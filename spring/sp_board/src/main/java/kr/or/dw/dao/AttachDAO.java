package kr.or.dw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.dw.vo.AttachVO;

@Mapper
public interface AttachDAO {
	void insertAttach(AttachVO attach) throws SQLException;

	List<AttachVO> selectAttachByPno(int pno) throws SQLException;

	AttachVO selectAttachByAno(int ano) throws SQLException;

	void deleteAttach(int ano) throws SQLException;

	void deleteAllAttach(int pno) throws SQLException;
}
