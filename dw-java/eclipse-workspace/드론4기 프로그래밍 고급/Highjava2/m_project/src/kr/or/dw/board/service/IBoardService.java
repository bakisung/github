package kr.or.dw.board.service;

import java.util.List;
import java.util.Map;

import kr.or.dw.board.vo.BoardVO;
import kr.or.dw.board.vo.ReplyVO;

public interface IBoardService {

	List<BoardVO> selectBoardList(Map<String, Object> paramMap);

	int selectBoardCount();

	int insertContent(BoardVO boardVo);

	BoardVO selectBoardView(int bd_no);

	int updateContent(BoardVO boardVo);

	void deleteContent(int parseInt);

	int insertReply(ReplyVO replyVo);

	ReplyVO selectReply(int re_no);

	List<ReplyVO> selectReplyList(int bd_no);

	int updateReply(ReplyVO replyVo);

	int deleteReply(int re_no);

}
