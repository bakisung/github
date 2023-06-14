package kr.or.dw.staff.dao;

import java.util.List;
import java.util.Map;

import kr.or.dw.vo.DateVO;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StaffVO;
import kr.or.dw.vo.StudentVO;

public interface IStaffDao {

	/**
	 * 교직원 로그인 메서드
	 * @param staff_id(교직원 아이디)
	 * @return staffVO 객체
	 */
	public StaffVO staffLogin(String staff_id);

	public String getStaffName(String staff_id);

	/**
	 * 아이디 이메일 체크 후 이메일로 인증코드 전송하는 메서드
	 * @param staffVo
	 * @return
	 */
	public int idEmailCheck(StaffVO staffVo);

	/**
	 * 모든 교수들을 불러오는 메서드
	 * @param paramMap 
	 * @return
	 */
	public List<StaffVO> getAllProfessorList(Map<String, Object> paramMap);

	/**
	 * 
	 * @return
	 */
	public List<StaffVO> getDept();

	/**
	 * 교수 추가
	 * @return
	 */
	public List<StaffVO> professorInsert(StaffVO staVo);
	
	/**
	 * 교수 삭제하는 메서드
	 * @param id
	 */
	public int professorDelete(String id);

	/**
	 * 교수님의 정보를 가져오는 메서드
	 * @param sta_id
	 * @return
	 */
	public StaffVO getstaffInfo(String sta_id);

	/**
	 * 교수님의 정보를 수정하는 메서드
	 * @param staVo
	 */
	public int professorUpdate(StaffVO staVo);

	/**
	 * 교수의 레코드를 가져오는 메서드
	 * @param search
	 * @return
	 */
	public int selectProfessorCount();

	/**
	 * 교수의 비밀번호 변경하는 메서드
	 * @param staffVo
	 * @return
	 */
	public int passwordUpdat(StaffVO staffVo);

	/**
	 * 교수의 내정보를 수정하는 메서드
	 * @param staffVo
	 * @return
	 */
	public int staffInfoUpdate(StaffVO staffVo);

	public List<DateVO> getDatelist();

	public int insertDate(DateVO dateVo);

	public DateVO getDate(DateVO yearTerm);

	public int existDate(DateVO dateVo);

	public int updateDate(DateVO dateVo);

}
