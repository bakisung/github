package kr.or.dw.student.service;

import java.util.List;
import java.util.Map;

import kr.or.dw.student.dao.IStudentDao;
import kr.or.dw.student.dao.StudentDaoImpl;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StudentVO;

public class StudentServiceImpl implements IStudentService{

	private IStudentDao dao;
	private static StudentServiceImpl service;
	
	public static StudentServiceImpl getInstance() {
		if(service == null) {
			service = new StudentServiceImpl();
		}
		return service;
	}
	
	//생성자
	private StudentServiceImpl() {
		dao = StudentDaoImpl.getInstance();
	}

	@Override
	public StudentVO stuLogin(String stu_id) {
		return dao.stuLogin(stu_id);
	}

	@Override
	public List<StudentVO> getAllStudentInfo(Map<String, Object> paramMap) {
		return dao.getAllStudentInfo(paramMap);
	}

	@Override
	public StudentVO stdentInfo(String stu_id) {
		return dao.studentInfo(stu_id);
	}

	@Override
	public int StudentInfoUpdate(StudentVO stuVo) {
		return dao.studentInfoUpdate(stuVo);
	}

	@Override
	public int passwordUpdate(StudentVO stuVo) {
		return dao.passwordUpdate(stuVo);
	}

	@Override
	public int idEmailCheck(StudentVO stuVo) {
		return dao.idEmailCheck(stuVo);
	}

	@Override
	public List<StudentVO> studentInsert(StudentVO stuVo) {
		return dao.studentInsert(stuVo);
	}

	@Override
	public List<StudentVO> getDept() {
		return dao.getDept();
	}


	public int studentDelete(String id) {
		return dao.studentDelete(id);
	}

	@Override
	public int studentUpdate(StudentVO stuVo) {
		return dao.studentUpdate(stuVo);
	}

	@Override
	public int selectStuCount() {
		return dao.selectStuCount();
	}

	@Override
	public String getStudentName(String stu_id) {
		return dao.getStudentName(stu_id);
	}

}
