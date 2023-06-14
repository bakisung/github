package kr.or.dw.student.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.dw.util.BuildSqlMapClient;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StudentVO;

public class StudentDaoImpl implements IStudentDao{
	
private static StudentDaoImpl dao;
	
	private SqlMapClient smc; 	//ibatis 용 SqlMapClient 객체 변수 선언
	
	private StudentDaoImpl() {
		smc = BuildSqlMapClient.getSqlMapClient();
	}
	
	public static StudentDaoImpl getInstance() {
		if(dao == null) {
			dao = new StudentDaoImpl();
		}
		return dao;
	}

	@Override
	public StudentVO stuLogin(String stu_id) {
		StudentVO vo = null;
		try {
			vo = (StudentVO) smc.queryForObject("student.studentLogin", stu_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return vo;
	}

	@Override
	public List<StudentVO> getAllStudentInfo(Map<String, Object> paramMap) {
		
		List<StudentVO> stuInfo = null;
		
		try {
			stuInfo = (List) smc.queryForList("student.studentAllInfo", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stuInfo;
	}

	@Override
	public StudentVO studentInfo(String stu_id) {
		StudentVO stuVo = new StudentVO();
		try {
			stuVo = (StudentVO) smc.queryForObject("student.studentInfo", stu_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stuVo;
	}

	@Override
	public int studentInfoUpdate(StudentVO stuVo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("student.stuInfoUpdate", stuVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return cnt;
	}

	@Override
	public int passwordUpdate(StudentVO stuVo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("student.passwordUpdate", stuVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int idEmailCheck(StudentVO stuVo) {
		int result = 0;
		try {
			result = (int) smc.queryForObject("student.idEmailCheck", stuVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<StudentVO> studentInsert(StudentVO stuVo) {
		List<StudentVO> cnt = null;
		
		try {
			cnt = (List) smc.insert("student.studentInsert", stuVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<StudentVO> getDept() {
		List<StudentVO> stuVo = null;
		
		try {
			stuVo = (List) smc.queryForList("student.getDept");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return stuVo;
	}

	@Override
	public int studentDelete(String id) {
		int cnt = 0;
		try {
			cnt = smc.delete("student.studentDelete", id);
		} catch (SQLException e) {
			e.printStackTrace();
        }
		return cnt;
	}

	@Override
	public int studentUpdate(StudentVO stuVo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("student.studentUpdate", stuVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int selectStuCount() {
		int totalCount = 0;
		
		try {
			totalCount = (int) smc.queryForObject("student.selectStuCount");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return totalCount;
	}

	@Override
	public String getStudentName(String stu_id) {
		String stu_name = null;
		try {
			stu_name = (String) smc.queryForObject("student.getStudentName", stu_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stu_name;
	}
}
