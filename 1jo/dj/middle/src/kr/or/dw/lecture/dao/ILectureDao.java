package kr.or.dw.lecture.dao;

import java.util.List;
import java.util.Map;

import kr.or.dw.vo.EvaluationVO;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StudentVO;

public interface ILectureDao {
	
	/**
	 * 모든 강의 목록을 가져오는 메서드
	 * @param id(학생 아이디)
	 * @return	강의목록이 저장될 LecVO 리스트
	 */
	List<LectureVO> getAllLecture(String id);

	
	int insertLecture(LectureVO lecVo);

	/**
	 * lec_code 가져오는 메서드
	 * @return
	 */
	String getLecCode();

	/**
	 * 교수 강의 목록 가져오는 메서드
	 * @param staff_id
	 * @return
	 */
	List<LectureVO> staffLecList(String staff_id);

	/**
	 * 강의코드로 강의정보 가져오는 메서드
	 * @param lec_code
	 * @return
	 */
	LectureVO selectLecture(String lec_code);

	/**
	 * 강의 수정할 때 원래 있던 강의 삭제하는 메서드
	 * @param lec_code
	 * @return
	 */
	int deleteLecture(String lec_code);

	/**
	 * 강의 듣는 학생 리스트 가져오는 메서드
	 * @param lec_code
	 * @return
	 */
	List<LectureVO> getLectureStudentList(String lec_code);

	/**
	 * 점수입력 메서드
	 * @param lecVo
	 * @return
	 */
	int updateScore(LectureVO lecVo);

	/**
	 * 강의계획안 업로드 메서드
	 * @param lecVo
	 * @return
	 */
	int updatePlanFile(LectureVO lecVo);


	String getPlanPath(String lec_code);


	List<LectureVO> getAllLectureRegister(Map<String, Object> paramMap);

	/**
	 * 수강신청 메서드
	 * @param lecVo
	 * @return
	 */
	int registerLecture(LectureVO lecVo);

	/**
	 * 강의에서 학생 삭제하는 메서드
	 * @param lecVo
	 * @return
	 */
	int deleteStudentLecture(LectureVO lecVo);
	
	/**
	 * 강의의 최대 수강인원 구하는 메서드
	 * @param lec_code
	 * @return
	 */
	int getMaxPeo(String lec_code);
	
	/**
	 * 강의의 현재 수강인원 구하는 메서드
	 * @param lec_code
	 * @return
	 */
	int getCurPeo(String lec_code);


	List<StudentVO> getLectureStudentListForm(String lec_code);

	/**
	 * 학생의 학과코드 가져오는 메서드
	 * @param stu_id
	 * @return
	 */
	String getStuDeptCode(String stu_id);

	/**
	 * 강의평가
	 * @param evalVo
	 * @return
	 */
	int insertEval(EvaluationVO evalVo);


	String getLecName(String lec_code);


	EvaluationVO getEvalResult(EvaluationVO evalVo);


	int updateEval(EvaluationVO evalVo);


	EvaluationVO getEvalAvg(String lec_code);


	List<String> getQue9List(String lec_code);


	int getStuLecCnt(String stu_id);


	int getStuEvalCnt(String stu_id);


	int selectLectureCount(Map<String, Object> paramMap);

}
