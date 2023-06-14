package kr.or.dw.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.web.IAction;

public class ProfessorDeleteAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStaffService service = StaffServiceImpl.getInstance();
		String[] sta_id = req.getParameterValues("sta_id_arr[]");
		
		if (sta_id != null && sta_id.length > 0) {
	        for (String id : sta_id) {
	            service.professorDelete(id);
	        }
	    }	  
		req.setAttribute("titleName", "교직원 관리");
		return null;
	}

}
