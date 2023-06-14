package kr.or.dw.assign.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.assign.service.AssignServiceImpl;
import kr.or.dw.assign.service.IAssignService;
import kr.or.dw.web.IAction;

public class DeleteAssignFormAction implements IAction{

	@Override
	public boolean isRedirect() {
	
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int assign_no = Integer.parseInt(req.getParameter("assign_no"));
		String lec_code = req.getParameter("lec_code");
		IAssignService service = AssignServiceImpl.getInstance();
		
		int result = 0;
		result = service.deleteAssign(assign_no);
		
		req.setAttribute("titleName", "과제 조회");

		return "/assign/lectureAssignList.do?lec_code=" + lec_code;
	}

}
