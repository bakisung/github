package kr.or.dw.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import kr.or.dw.vo.PdsVO;

@Mapper
public interface PdsDAO {
	int insertPds(PdsVO pds) throws SQLException;
}
