package kr.or.dw.student.dao;

import java.util.List;
import java.util.Map;

import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StudentVO;

public interface IStudentDao {

	/**
	 * 학생 로그인 메서드
	 * @param stu_id(학생아이디)
	 * @return 위의 파라미터로 조회한 컬럼값
	 */
	public StudentVO stuLogin(String stu_id);

	/**
	 * 학생의 정보를 가져오는 메서드
	 * @param stu_id 
	 * @return
	 */
	public List<StudentVO> getAllStudentInfo(Map<String, Object> paramMap);

	/**
	 * 학생의 정보를 가져오는 메서드
	 * @param stu_id
	 * @return 
	 */
	public StudentVO studentInfo(String stu_id);

	/**
	 * 학생의 정보를 수정하는 메서드
	 * @param stuVo
	 * @return
	 */
	public int studentInfoUpdate(StudentVO stuVo);

	/**
	 * 패스워드를 업데이트하는 메서드입니다.
	 * @param stuVo
	 * @return
	 */
	public int passwordUpdate(StudentVO stuVo);

	/**
	 * 비밀번호 찾기때 아이디 이메일 일치하는지 확인하는 메서드
	 * @param stuVo
	 * @return
	 */
	public int idEmailCheck(StudentVO stuVo);

	/**
	 * 학생을 추가하는 메서드
	 * @param stuVo
	 */
	public List<StudentVO> studentInsert(StudentVO stuVo);

	/**
	 * 학과코드와 이름을 가져오는 메서드
	 * @return
	 */
	public List<StudentVO> getDept();

	/**
	 * 학생을 삭제하는 메서드
	 * @param stuVo
	 * @return
	 */
	public int studentDelete(String id);

	/**
	 * 학생의 정보를 수정하는 메서드
	 * @param stu_id
	 * @return
	 */
	public int studentUpdate(StudentVO stuVo);

	/**
	 * 전체 레코드를 가져오는 메서드
	 * @param search
	 * @return
	 */
	public int selectStuCount();

	/**
	 * 학생의 이름을 불러오는 메서드
	 * @param stu_id
	 * @return
	 */
	public String getStudentName(String stu_id);

	

}
