package kr.or.dw.board.service;

import java.util.List;
import java.util.Map;

import kr.or.dw.board.dao.BoardDaoImpl;
import kr.or.dw.board.dao.IBoardDao;
import kr.or.dw.vo.BoardVO;
import kr.or.dw.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService{

	private IBoardDao dao;
	private static BoardServiceImpl service;
	
	public static BoardServiceImpl getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	//생성자
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}

	@Override
	public int selectBoardCount(String search) {
		return dao.selectBoardCount(search);
	}

	@Override
	public List<BoardVO> selectBoardList(Map<String, Object> paramMap) {
		return dao.selectBoardList(paramMap);
	}

	@Override
	public BoardVO selectBulletinBoardView(int bd_no) {
		return dao.selectBulletinBoeadView(bd_no);
	}

	@Override
	public int deleteBulletinContent(int bd_no) {
		return dao.deleteBulletinContent(bd_no);
	}

	@Override
	public int updateBulletinContent(BoardVO boardVo) {
		return dao.updateBulletinContent(boardVo);
	}

	@Override
	public int insertBulletinContent(BoardVO boardVo) {
		return dao.insertBulletinContent(boardVo);
	}

	@Override
	public int selectStuBoardCount(String search) {
		return dao.selectStuBoardCount(search);
	}

	@Override
	public List<BoardVO> selectStuBoardList(Map<String, Object> paramMap) {
		return dao.selectStuBoardList(paramMap);
	}

	@Override
	public BoardVO selectStuBoardView(int bd_no) {
		return dao.selectStuBoardView(bd_no);
	}

	@Override
	public int deleteStuContent(int bd_no) {
		return dao.deleteStuContent(bd_no);
	}

	@Override
	public int updateStuContent(BoardVO boardVo) {
		return dao.updateStuContent(boardVo);
	}

	@Override
	public int insertStuContent(BoardVO boardVo) {
		return dao.insertStuContent(boardVo);
	}


	@Override
	public int stuBoardInsert(ReplyVO reVo) {
		return dao.stuBoardInsert(reVo);
	}

	@Override
	public ReplyVO selectStaffInfo(int bd_no) {
		return dao.selectStaffInfo(bd_no);
	}

	@Override
	public int stuBoardReplyUpdate(ReplyVO reVo) {
		return dao.stuBoardReplyUpdate(reVo);
	}


}