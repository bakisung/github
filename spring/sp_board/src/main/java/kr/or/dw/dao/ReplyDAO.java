package kr.or.dw.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import kr.or.dw.vo.ReplyVO;

@Mapper
public interface ReplyDAO {

	void insertReply(ReplyVO reply) throws SQLException;

	List<ReplyVO> selectPageReplyList(int bno, RowBounds rowBounds) throws SQLException;

	int countReply(int bno) throws SQLException;

	void deleteReply(int rno) throws SQLException;

}
