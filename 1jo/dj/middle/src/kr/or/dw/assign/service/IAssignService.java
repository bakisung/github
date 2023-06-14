package kr.or.dw.assign.service;

import java.util.List;

import kr.or.dw.vo.AssignVO;

public interface IAssignService {
	
	/**
	 * 해당 강의의 과제목록을 불러오는 메서드
	 * @param lec_code
	 * @return
	 */
	List<AssignVO> getLectureAssignList(String lec_code);

	/**
	 * 교수 과제등록 메서드
	 * @param assignVo
	 * @return
	 */
	int insertAssign(AssignVO assignVo);
	
	/**
	 * 과제 제출한 학생들 목록 가져오는 메서드
	 * @param assign_no
	 * @return
	 */
	List<AssignVO> getSubStudentList(int assign_no);
	
	/**
	 * 학생의 과제 목록 가져오기
	 * @param stu_id
	 * @return
	 */
	List<AssignVO> getStuAssignList(String stu_id);
	
	/**
	 * 과제 조회
	 * @param assign_no
	 * @return
	 */
	AssignVO viewAssign(int assign_no);
	
	/**
	 * 과제 수정
	 * @param assignVo
	 * @return
	 */
	int updateAssign(AssignVO assignVo);
	
	/**
	 * 과제 지우기
	 * @param assign_no
	 * @return
	 */
	int deleteAssign(int assign_no);

	/**
	 * 과제 제출 메서드
	 * @param assignVo
	 * @return
	 */
	int submitAssignFile(AssignVO assignVo);

	/**
	 * 학생 과제 파일 이름 가져오기
	 * @param stuAssign
	 * @return
	 */
	AssignVO getStuAssignFile(AssignVO stuAssign);

	int existAssignFile(AssignVO assignVo);

	/**
	 * 해당 과제번호의 모든 과제물 경로 가져오는 메서드
	 * @param assign_no
	 * @return
	 */
	List<String> getAllAssignPath(int assign_no);



}
