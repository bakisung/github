package kr.or.dw.board.service;

import java.util.List;
import java.util.Map;

import kr.or.dw.board.dao.BoardDaoImpl;
import kr.or.dw.board.dao.IBoardDao;
import kr.or.dw.board.vo.BoardVO;
import kr.or.dw.board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService{
	
	private IBoardDao dao;
	private static BoardServiceImpl service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}

	@Override
	public List<BoardVO> selectBoardList(Map<String, Object> paramMap) {
		return dao.selectBoardList(paramMap);
	}

	@Override
	public int selectBoardCount() {
		return dao.selectBoardCount();
	}

	@Override
	public int insertContent(BoardVO boardVo) {
		return dao.insertContent(boardVo);
	}

	@Override
	public BoardVO selectBoardView(int bd_no) {
		return dao.selectBoardView(bd_no);
	}

	@Override
	public int updateContent(BoardVO boardVo) {
		return dao.updateContent(boardVo);
	}

	@Override
	public void deleteContent(int bd_no) {
		dao.deleteContent(bd_no);
	}

	@Override
	public int insertReply(ReplyVO replyVo) {
		return dao.insertReply(replyVo);
	}

	@Override
	public ReplyVO selectReply(int re_no) {
		return dao.selectReply(re_no);
	}

	@Override
	public List<ReplyVO> selectReplyList(int bd_no) {
		return dao.selectReplyList(bd_no);
	}

	@Override
	public int updateReply(ReplyVO replyVo) {
		return dao.updateReply(replyVo);
	}

	@Override
	public int deleteReply(int re_no) {
		return dao.deleteReply(re_no);
	}
}
