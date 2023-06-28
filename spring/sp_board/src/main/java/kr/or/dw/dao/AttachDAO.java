package kr.or.dw.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import kr.or.dw.vo.AttachVO;

@Mapper
public interface AttachDAO {
	void insertAttach(AttachVO attach) throws SQLException;
}
