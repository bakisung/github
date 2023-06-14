package kr.or.dw.assign.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.assign.service.AssignServiceImpl;
import kr.or.dw.assign.service.IAssignService;
import kr.or.dw.vo.AssignVO;
import kr.or.dw.web.IAction;

public class ViewAssignAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String auth_cd = (String) session.getAttribute("auth_cd");

		int assign_no = Integer.parseInt(req.getParameter("assign_no"));
		
		AssignVO assignVo = null;
		
		IAssignService service = AssignServiceImpl.getInstance();
		assignVo = service.viewAssign(assign_no);
		
		req.setAttribute("assignVo", assignVo);
		
		req.setAttribute("titleName", "과제 조회");

		if(auth_cd.equals("S")) {
			AssignVO stuAssign = new AssignVO();
			String stu_id = (String) session.getAttribute("stu_id");
			stuAssign.setAssign_no(assign_no);
			stuAssign.setStu_id(stu_id);
			
			stuAssign = service.getStuAssignFile(stuAssign);
			req.setAttribute("stuAssignVo", stuAssign);
			
			return "/student/assign/assignView.jsp";
		}


		return "/staff/score/assignView.jsp";
		
		
	}

}
