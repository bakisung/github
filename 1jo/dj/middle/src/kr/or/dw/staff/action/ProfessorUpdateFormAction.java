package kr.or.dw.staff.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.vo.StaffVO;
import kr.or.dw.web.IAction;

public class ProfessorUpdateFormAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStaffService service = StaffServiceImpl.getInstance();
		
		String sta_id = req.getParameter("sta_id");
		StaffVO staVo = null;
		staVo = service.getstaffInfo(sta_id);
		
		List<StaffVO> vo = service.getDept();
		req.setAttribute("staVo", staVo);
		req.setAttribute("dept", vo);
		
		req.setAttribute("titleName", "교직원 관리");
		return "/staff/professor/professorUpdateForm.jsp";
	}

}
