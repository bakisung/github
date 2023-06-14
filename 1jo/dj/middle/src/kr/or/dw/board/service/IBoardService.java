package kr.or.dw.board.service;

import java.util.List;
import java.util.Map;

import kr.or.dw.vo.BoardVO;
import kr.or.dw.vo.ReplyVO;

public interface IBoardService {

	/**
	 * 공지사항 게시판 전체 레코드 수를 가져오는 메서드
	 * @param search 
	 * @return 전체 레코드 수
	 */
	int selectBoardCount(String search);

	/**
	 * 공지사항 게시판 목록을 가져오는 메서드
	 * @param paramMap rownum 의 시작과 끝값이 있는 map
	 * @return 게시판 목록 list
	 */
	List<BoardVO> selectBoardList(Map<String, Object> paramMap);
	
	/**
	 * 공지사항 보는 메서드
	 * @param bd_no
	 * @return
	 */
	BoardVO selectBulletinBoardView(int bd_no);
	
	/**
	 * 공지사항 삭제 메서드
	 * @param bd_no
	 * @return
	 */
	int deleteBulletinContent(int bd_no);
	
	/**
	 * 공지사항 내용 수정
	 * @param boardVo
	 * @return
	 */
	int updateBulletinContent(BoardVO boardVo);
	
	/**
	 * 공지사항 글 작성
	 * @param boardVo
	 * @return
	 */
	int insertBulletinContent(BoardVO boardVo);

	/**
	 * 문의 게시판 전체 레코드 수를 가져오는 메서드
	 * @param search 
	 * @return 전체 레코드 수
	 */
	int selectStuBoardCount(String search);

	/**
	 * 문의 게시판 목록을 가져오는 메서드
	 * @param paramMap rownum 의 시작과 끝값이 있는 map
	 * @return 게시판 목록 list
	 */
	List<BoardVO> selectStuBoardList(Map<String, Object> paramMap);
	
	/**
	 * 문의게시판 보는 메서드
	 * @param bd_no
	 * @return
	 */
	BoardVO selectStuBoardView(int bd_no);
	
	/**
	 * 문의게시판 삭제 메서드
	 * @param bd_no
	 * @return
	 */
	int deleteStuContent(int bd_no);
	
	/**
	 * 문의게시판 내용 수정
	 * @param boardVo
	 * @return
	 */
	int updateStuContent(BoardVO boardVo);
	
	/**
	 * 문의게시판 글 작성
	 * @param boardVo
	 * @return
	 */
	int insertStuContent(BoardVO boardVo);

	/**
	 * 댓글 관리자의 정보를 가저오는 메서드
	 * @param bd_no 
	 * @return
	 */
	ReplyVO selectStaffInfo(int bd_no);
	
	/**
	 * 댓글 추가하는 메서드
	 * @param reVo
	 * @return
	 */
	int stuBoardInsert(ReplyVO reVo);

	/**
	 * 댓글을 수정하는 메서드
	 * @param reVo
	 */
	int stuBoardReplyUpdate(ReplyVO reVo);


	
}