package kr.or.dw.assign.service;

import java.util.List;

import kr.or.dw.assign.dao.AssignDaoImpl;
import kr.or.dw.assign.dao.IAssignDao;
import kr.or.dw.vo.AssignVO;

public class AssignServiceImpl implements IAssignService{

	private IAssignDao dao;
	private static AssignServiceImpl service;
	
	public static AssignServiceImpl getInstance() {
		if(service == null) {
			service = new AssignServiceImpl();
		}
		return service;
	}
	
	//생성자
	private AssignServiceImpl() {
		dao = AssignDaoImpl.getInstance();
	}

	@Override
	public List<AssignVO> getLectureAssignList(String lec_code) {
		return dao.getLectureAssignList(lec_code);
	}

	@Override
	public int insertAssign(AssignVO assignVo) {
		return dao.insertAssign(assignVo);
	}

	@Override
	public List<AssignVO> getSubStudentList(int assign_no) {
		return dao.getSubStudentList(assign_no);
	}

	@Override
	public List<AssignVO> getStuAssignList(String stu_id) {
		
		return dao.getStuAssignList(stu_id);
	}

	@Override
	public AssignVO viewAssign(int assign_no) {
		
		return dao.viewAssign(assign_no);
	}

	@Override
	public int updateAssign(AssignVO assignVo) {
		return dao.updateAssign(assignVo);
	}

	@Override
	public int deleteAssign(int assign_no) {
		return dao.deleteAssign(assign_no);
	}

	@Override
	public int submitAssignFile(AssignVO assignVo) {
		return dao.submitAssignFile(assignVo);
	}

	@Override
	public AssignVO getStuAssignFile(AssignVO stuAssign) {
		return dao.getStuAssignFile(stuAssign);
	}

	@Override
	public int existAssignFile(AssignVO assignVo) {
		return dao.existAssignFile(assignVo);
	}

	@Override
	public List<String> getAllAssignPath(int assign_no) {
		return dao.getAllAssignPath(assign_no);
	}





}
