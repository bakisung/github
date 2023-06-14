package kr.or.dw.lecture.service;

import java.util.List;
import java.util.Map;

import kr.or.dw.lecture.dao.ILectureDao;
import kr.or.dw.lecture.dao.LectureDaoImpl;
import kr.or.dw.vo.EvaluationVO;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StudentVO;

public class LectureServiceImpl implements ILectureService{

	// DAO 객체 변수 생성
		private ILectureDao dao;
		private static LectureServiceImpl service;
		
		public static LectureServiceImpl getInstance() {
			if(service == null) {
				service = new LectureServiceImpl();
			}
			return service;
		}
		
		//생성자
		private LectureServiceImpl() {
			dao = LectureDaoImpl.getInstance();
		}

		@Override
		public List<LectureVO> getAllLecture(String stu_id) {
			return dao.getAllLecture(stu_id);
		}

		@Override
		public int insertLecture(LectureVO lecVo) {
			return dao.insertLecture(lecVo);
		}

		@Override
		public String getLecCode() {
			return dao.getLecCode();
		}

		@Override
		public List<LectureVO> staffLecList(String staff_id) {
			return dao.staffLecList(staff_id);
		}

		@Override
		public LectureVO selectLecture(String lec_code) {
			return dao.selectLecture(lec_code);
		}

		@Override
		public int deleteLecture(String lec_code) {
			return dao.deleteLecture(lec_code);
		}

		@Override
		public List<LectureVO> getLectureStudentList(String lec_code) {
			return dao.getLectureStudentList(lec_code);
		}

		@Override
		public int updateScore(LectureVO lecVo) {
			return dao.updateScore(lecVo);
		}

		@Override
		public int updatePlanFile(LectureVO lecVo) {
			return dao.updatePlanFile(lecVo);
		}

		@Override
		public String getPlanPath(String lec_code) {
			return dao.getPlanPath(lec_code);
		}

		@Override
		public List<LectureVO> getAllLectureRegister(Map<String, Object> paramMap) {
			
			return dao.getAllLectureRegister(paramMap);
		}

		@Override
		public int registerLecture(LectureVO lecVo) {
			return dao.registerLecture(lecVo);
		}

		@Override
		public int deleteStudentLecture(LectureVO lecVo) {
			return dao.deleteStudentLecture(lecVo);
		}

		@Override
		public int getMaxPeo(String lec_code) {
			return dao.getMaxPeo(lec_code);
		}

		@Override
		public int getCurPeo(String lec_code) {
			return dao.getCurPeo(lec_code);
		}

		@Override
		public List<StudentVO> getLectureStudentListForm(String lec_code) {
			return dao.getLectureStudentListForm(lec_code);
		}

		@Override
		public String getStuDeptCode(String stu_id) {
			return dao.getStuDeptCode(stu_id);
		}

		@Override
		public int insertEval(EvaluationVO evalVo) {
			return dao.insertEval(evalVo);
		}

		@Override
		public String getLecName(String lec_code) {
			return dao.getLecName(lec_code);
		}

		@Override
		public EvaluationVO getEvalResult(EvaluationVO evalVo) {
			return dao.getEvalResult(evalVo);
		}

		@Override
		public int updateEval(EvaluationVO evalVo) {
			return dao.updateEval(evalVo);
		}

		@Override
		public EvaluationVO getEvalAvg(String lec_code) {
			return dao.getEvalAvg(lec_code);
		}

		@Override
		public List<String> getQue9List(String lec_code) {
			return dao.getQue9List(lec_code);
		}

		@Override
		public int getStuLecCnt(String stu_id) {
			return dao.getStuLecCnt(stu_id);
		}

		@Override
		public int getStuEvalCnt(String stu_id) {
			return dao.getStuEvalCnt(stu_id);
		}

		@Override
		public int selectLectureCount(Map<String, Object> paramMap) {
			return dao.selectLectureCount(paramMap);
		}
}
