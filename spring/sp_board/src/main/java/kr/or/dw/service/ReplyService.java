package kr.or.dw.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.dw.command.SearchCriteria;
import kr.or.dw.vo.ReplyVO;

public interface ReplyService {
	
	void registReply(ReplyVO reply) throws SQLException;

	Map<String, Object> selectReplyList(int bno, SearchCriteria cri) throws SQLException;

	void removeReply(int rno) throws SQLException;
	
}
