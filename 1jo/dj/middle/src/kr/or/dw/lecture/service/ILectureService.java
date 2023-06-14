package kr.or.dw.lecture.service;

import java.util.List;
import java.util.Map;

import kr.or.dw.vo.EvaluationVO;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StudentVO;

public interface ILectureService {

	/**
	 * 학생 강의 목록을 가져오는 메서드
	 * @param id(학생 아이디)
	 * @return	강의목록이 저장될 LecVO 리스트
	 */
	List<LectureVO> getAllLecture(String id);

	/**
	 * 강의등록 메서드
	 * @param lecVo(강의객체)
	 * @return
	 */
	int insertLecture(LectureVO lecVo);

	/**
	 * lec_code 가져오는 메서드
	 * @return
	 */
	String getLecCode();

	/**
	 * 교수 강의 목록 가져오는 메서드
	 * @param staff_id (교수아이디)
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
	 * 강의 수정할때 원래 있던 강의 삭제하는 메서드
	 * @param lec_code
	 * @return
	 */
	int deleteLecture(String lec_code);

	/**
	 * 강의듣는 학생들 리스트 성적입력부분
	 * @param lec_code
	 * @return
	 */
	List<LectureVO> getLectureStudentList(String lec_code);

	/**
	 * 점수입력하는 메서드
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
	
	/**
	 * 수정하기 전에 강의계획안 따로 뺴놓는 메서드 
	 * @param lec_code
	 * @return
	 */
	String getPlanPath(String lec_code);

	/**
	 * 현재 년도, 학기에 맞는 강의 리스트 가져오기
	 * @param paramMap
	 * @return
	 */
	List<LectureVO> getAllLectureRegister(Map<String, Object> paramMap);

	/**
	 * 수강신청
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
	
	/**
	 * 강의듣는 학생 리스트
	 * @param lec_code
	 * @return
	 */
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
