package kr.or.dw.staff.service;

import kr.or.dw.staff.dao.StaffDaoImpl;
import kr.or.dw.vo.DateVO;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StaffVO;
import kr.or.dw.vo.StudentVO;

import java.util.List;
import java.util.Map;

import kr.or.dw.staff.dao.IStaffDao;

public class StaffServiceImpl implements IStaffService{
	private IStaffDao dao;
	private static StaffServiceImpl service;
	
	public static StaffServiceImpl getInstance() {
		if(service == null) {
			service = new StaffServiceImpl();
		}
		return service;
	}
	
	//생성자
	private StaffServiceImpl() {
		dao = StaffDaoImpl.getInstance();
	}

	@Override
	public StaffVO staffLogin(String staff_id) {
		
		return dao.staffLogin(staff_id);
	}

	@Override
	public String getStaffName(String staff_id) {
		return dao.getStaffName(staff_id);
	}

	@Override
	public int idEmailCheck(StaffVO staffVo) {
		return dao.idEmailCheck(staffVo);
	}

	@Override
	public List<StaffVO> getAllProfessorList(Map<String, Object> paramMap) {
		return dao.getAllProfessorList(paramMap);
	}

	@Override
	public List<StaffVO> getDept() {
		return dao.getDept();
	}

	@Override
	public List<StaffVO> professorInsert(StaffVO staVo) {
		return dao.professorInsert(staVo);
	}

	@Override
	public int professorDelete(String id) {
		return dao.professorDelete(id);
	}

	@Override
	public StaffVO getstaffInfo(String staff_id) {
		return dao.getstaffInfo(staff_id);
	}

	@Override
	public int professorUpdate(StaffVO staVo) {
		return dao.professorUpdate(staVo);
	}

	@Override
	public int selectProfessorCount() {
		return dao.selectProfessorCount();
	}

	@Override
	public int passwordUpdate(StaffVO staffVo) {
		return dao.passwordUpdat(staffVo);
	}

	@Override
	public int staffInfoUpdate(StaffVO staffVo) {
		return dao.staffInfoUpdate(staffVo);
	}

	@Override
	public List<DateVO> getDateList() {
		return dao.getDatelist();
	}

	@Override
	public int insertDate(DateVO dateVo) {
		return dao.insertDate(dateVo);
	}

	@Override
	public DateVO getDate(DateVO yearTerm) {
		return dao.getDate(yearTerm);
	}

	@Override
	public int existDate(DateVO dateVo) {
		return dao.existDate(dateVo);
	}

	@Override
	public int updateDate(DateVO dateVo) {
		return dao.updateDate(dateVo);
	}

}
