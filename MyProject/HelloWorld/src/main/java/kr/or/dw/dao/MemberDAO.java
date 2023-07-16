package kr.or.dw.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import kr.or.dw.vo.MemberVO;

@Mapper
public interface MemberDAO {

	MemberVO selectMemberId(String id) throws SQLException;
	
}
