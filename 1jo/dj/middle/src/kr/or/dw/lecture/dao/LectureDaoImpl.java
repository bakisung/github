package kr.or.dw.lecture.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.dw.util.BuildSqlMapClient;
import kr.or.dw.vo.EvaluationVO;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StudentVO;

public class LectureDaoImpl implements ILectureDao{
	
private static LectureDaoImpl dao;
	
	private SqlMapClient smc; 	//ibatis 용 SqlMapClient 객체 변수 선언
	
	private LectureDaoImpl() {
		smc = BuildSqlMapClient.getSqlMapClient();
	}
	
	public static LectureDaoImpl getInstance() {
		if(dao == null) {
			dao = new LectureDaoImpl();
		}
		return dao;
	}

	@Override
	public List<LectureVO> getAllLecture(String stu_id) {
		List<LectureVO> lecList = null;
		try {
			lecList = smc.queryForList("lecture.getAllLecture", stu_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecList;
	}

	@Override
	public int insertLecture(LectureVO lecVo) {
		int result = 0;
		String insert = "";
		try {
			insert = (String) smc.insert("lecture.insertLecture", lecVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(insert == null) {
			result = 1;
		}
		
		return result;
	}

	@Override
	public String getLecCode() {
		String lec_code = null;
		try {
			lec_code = (String) smc.queryForObject("lecture.selecteLecCode");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lec_code;
	}

	@Override
	public List<LectureVO> staffLecList(String staff_id) {
		List<LectureVO> lecList = null;
		try {
			lecList = smc.queryForList("lecture.staffLecList", staff_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lecList;
	}

	@Override
	public LectureVO selectLecture(String lec_code) {
		LectureVO lecVo = null;
		try {
			lecVo = (LectureVO) smc.queryForObject("lecture.selectLecture", lec_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lecVo;
	}

	@Override
	public int deleteLecture(String lec_code) {
		int deleteRes = 0;
		try {
			deleteRes = smc.delete("lecture.deleteLecture", lec_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteRes;
	}

	@Override
	public List<LectureVO> getLectureStudentList(String lec_code) {
		List<LectureVO> lecList = null;
		try {
			lecList = smc.queryForList("lecture.getLectureStudent", lec_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecList;
	}

	@Override
	public int updateScore(LectureVO lecVo) {
		int result = 0;
		try {
			result = smc.update("lecture.updateScore", lecVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updatePlanFile(LectureVO lecVo) {
		int result = 0;
		try {
			result = smc.update("lecture.updatePlanFile", lecVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public String getPlanPath(String lec_code) {
		String plan_path = null;
		try {
			plan_path = (String) smc.queryForObject("lecture.getPlanPath", lec_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plan_path;
	}

	@Override
	public List<LectureVO> getAllLectureRegister(Map<String, Object> paramMap) {
		List<LectureVO> lecList = null;
		try {
			lecList = smc.queryForList("lecture.getAllLectureRegister", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lecList;
	}

	@Override
	public int registerLecture(LectureVO lecVo) {
		String result = null;
		try {
			result = (String) smc.insert("lecture.regusterLecture", lecVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int cnt = 0;
		if(result == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteStudentLecture(LectureVO lecVo) {
		int result = 0;
		try {
			result = smc.delete("lecture.deleteStudentLecture", lecVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int getMaxPeo(String lec_code) {
		int max_peo = 1;
		try {
			max_peo = (int) smc.queryForObject("lecture.getMaxPeo", lec_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max_peo;
	}

	@Override
	public int getCurPeo(String lec_code) {
		int cur_peo = 0;
		try {
			cur_peo = (int) smc.queryForObject("lecture.getCurPeo", lec_code);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cur_peo;
	}

	@Override
	public List<StudentVO> getLectureStudentListForm(String lec_code) {
		List<StudentVO> stuList = null;
		try {
			stuList = smc.queryForList("lecture.lectureStuListForm", lec_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stuList;
	}

	@Override
	public String getStuDeptCode(String stu_id) {
		String stu_dept_code = null;
		try {
			stu_dept_code = (String) smc.queryForObject("lecture.getStuDeptCode", stu_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu_dept_code;
	}

	@Override
	public int insertEval(EvaluationVO evalVo) {
		int cnt = 0;
		String result = null;
		try {
			result = (String) smc.insert("eval.insertEval", evalVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public String getLecName(String lec_code) {
		String lec_name = null;
		try {
			lec_name = (String) smc.queryForObject("lecture.getLecName", lec_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lec_name;
	}

	@Override
	public EvaluationVO getEvalResult(EvaluationVO evalVo) {
		EvaluationVO eval = null;
		try {
			eval = (EvaluationVO) smc.queryForObject("eval.getEvalVo", evalVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return eval;
	}

	@Override
	public int updateEval(EvaluationVO evalVo) {
		int result = 0;
		try {
			result = smc.update("eval.updateEval", evalVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public EvaluationVO getEvalAvg(String lec_code) {
		EvaluationVO evalAvg = null;
		try {
			evalAvg = (EvaluationVO) smc.queryForObject("eval.getEvalAvg", lec_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return evalAvg;
	}

	@Override
	public List<String> getQue9List(String lec_code) {
		List<String> que9List = null;
		try {
			que9List = smc.queryForList("eval.getQue9List", lec_code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return que9List;
	}

	@Override
	public int getStuLecCnt(String stu_id) {
		int leccnt = 0;
		try {
			leccnt = (int) smc.queryForObject("lecture.getStuLecCnt", stu_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leccnt;
	}

	@Override
	public int getStuEvalCnt(String stu_id) {
		int evalcnt = 0;
		try {
			evalcnt = (int) smc.queryForObject("lecture.getStuEvalCnt", stu_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return evalcnt;
	}

	@Override
	public int selectLectureCount(Map<String, Object> paramMap) {
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("lecture.selectLectureCount", paramMap);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	
	
}
