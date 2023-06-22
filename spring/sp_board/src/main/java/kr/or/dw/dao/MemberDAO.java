package kr.or.dw.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import kr.or.dw.command.SearchCriteria;
import kr.or.dw.vo.MemberVO;

@Mapper
public interface MemberDAO {

	// 회원정보 조회
	MemberVO selectMemberById(String id) throws SQLException;

	List<MemberVO> selectAllMemberList() throws SQLException;

	void insertMember(MemberVO member) throws SQLException;

	void updateMember(MemberVO member) throws SQLException;

	void deleteMember(String id) throws SQLException;

	void disabledMember(String id) throws SQLException;

	void enabledMember(String id) throws SQLException;

	List<MemberVO> selectSearchMemberList(SearchCriteria cri, RowBounds rowBounds) throws SQLException;

	int selectSearchMemberListCount(SearchCriteria cri) throws SQLException;

}
