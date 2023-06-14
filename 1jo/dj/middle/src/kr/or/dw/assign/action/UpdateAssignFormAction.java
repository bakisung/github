package kr.or.dw.assign.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.assign.service.AssignServiceImpl;
import kr.or.dw.assign.service.IAssignService;
import kr.or.dw.vo.AssignVO;
import kr.or.dw.web.IAction;

public class UpdateAssignFormAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IAssignService service = AssignServiceImpl.getInstance();
		
		int assign_no = Integer.parseInt(req.getParameter("assign_no"));
		
		AssignVO assignVo = null;
		assignVo = service.viewAssign(assign_no);
		System.out.println(assignVo.getAssign_name());
		req.setAttribute("assignVo", assignVo);
		req.setAttribute("titleName", "과제 조회");
		return "/staff/score/assignUpdateForm.jsp";
	}

}
