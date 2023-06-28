package kr.or.dw.service;

import java.sql.SQLException;

import kr.or.dw.vo.PdsVO;

public interface PdsSerivce {

	void regist(PdsVO pds) throws SQLException;
	
}
