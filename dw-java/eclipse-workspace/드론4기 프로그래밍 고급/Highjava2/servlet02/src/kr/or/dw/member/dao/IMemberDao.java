package kr.or.dw.member.dao;

import java.util.List;

import kr.or.dw.vo.MemberVO;

/**
 * @author admin
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하고 
 * Service에 전달하는 Dao의 interface
 */
public interface IMemberDao {
	
	/**
	 * 전체 회원 정보를 DB에서 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return 회원정보(MemberVO)가 저장될 List 객체
	 */
	public List<MemberVO> getAllMember();

	/**
	 * 회원을 등록할 때 ID의 중복 확인을 하는 메서드
	 * @param mem_id(회원ID)
	 * @return 회원ID를 조건으로 한 SELECT COUNT() 값
	 */
	public int getMemberCount(String mem_id);

	/**
	 * 회원의 정보를 등록하는 메서드
	 * @param memVo(MemberVO 객체)
	 * @return INSERT 대상 수
	 */
	public int insertMember(MemberVO memVo);

	/**
	 * 회원의 상세 정보를 조회하는 메서드
	 * @param mem_id(회원ID)
	 * @return MemberVO(회원 객체)
	 */
	public MemberVO getMember(String mem_id);

	/**
	 * 회원의 상세 정보를 수정하는 메서드
	 * @param memVo(회원객체)
	 */
	public int updateMember(MemberVO memVo);

	/**
	 * 회원 정보를 삭제하는 메서드
	 * @param mem_id(회원ID)
	 */
	public int deleteMember(String mem_id);
	
}
