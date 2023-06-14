package kr.or.dw.assign.dao;

import java.util.List;

import kr.or.dw.vo.AssignVO;

public interface IAssignDao {

	/**
	 * 해당 강의의 과제물을 모두 가져오는 메서드
	 * @param lec_code
	 * @return
	 */
	public List<AssignVO> getLectureAssignList(String lec_code);
	
	/**
	 * 교수과제등록메서드
	 * @param assignVo
	 * @return
	 */
	public int insertAssign(AssignVO assignVo);
	
	/**
	 * 과제 제출한 학생 목록 가져오는 메서드
	 * @param assign_no
	 * @return
	 */
	public List<AssignVO> getSubStudentList(int assign_no);
	
	/**
	 * 학생의 과제 목록 가져오기
	 * @param stu_id
	 * @return
	 */
	public List<AssignVO> getStuAssignList(String stu_id);
	
	/**
	 * 과제 조회 메서드
	 * @param assign_no
	 * @return
	 */
	public AssignVO viewAssign(int assign_no);

	/**
	 * 과제 수정 메서드
	 * @param assignVo
	 * @return
	 */
	public int updateAssign(AssignVO assignVo);

	/**
	 * 과제 지우기
	 * @param assign_no
	 * @return
	 */
	public int deleteAssign(int assign_no);

	/**
	 * 과제 제출 메서드
	 * @param assign
	 * @return
	 */
	public int submitAssignFile(AssignVO assignVo);

	/**
	 * 학생 제출한 과제 이름 가져오기 메서드
	 * @param stuAssign
	 * @return
	 */
	public AssignVO getStuAssignFile(AssignVO stuAssign);

	public int existAssignFile(AssignVO assignVo);
	
	/**
	 * 해당 과제 번호의 모든 제출 과제 경로를 가져오는 메서드
	 * @param assign_no
	 * @return
	 */
	public List<String> getAllAssignPath(int assign_no);

}
