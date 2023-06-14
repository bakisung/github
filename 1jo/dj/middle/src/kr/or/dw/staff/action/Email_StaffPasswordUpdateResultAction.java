package kr.or.dw.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.web.IAction;

public class Email_StaffPasswordUpdateResultAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		IStaffService service = StaffServiceImpl.getInstance();
		
		String staff_id = req.getParameter("staff_id");

		
		int success = 0;
		
		String staff_passCge = req.getParameter("staff_pwdChange");
		String staff_passChk = req.getParameter("staff_pwdCheck");
		
		if(staff_passCge.equals(staff_passChk)) {
			success = 1;
		}
		
		req.setAttribute("passSuccess", success);
		req.setAttribute("staff_pwd", staff_passCge);
		req.setAttribute("staff_id", staff_id);
		
		req.setAttribute("titleName", "비밀번호 변경 결과");
		
		return "/staff/emailPassUpdateResult.jsp";
	}

}
