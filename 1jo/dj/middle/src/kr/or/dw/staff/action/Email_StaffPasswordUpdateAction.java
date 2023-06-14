package kr.or.dw.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.web.IAction;

public class Email_StaffPasswordUpdateAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String staff_id = req.getParameter("staff_id");
		req.setAttribute("staff_id", staff_id);
		
		req.setAttribute("titleName", "비밀번호 변경");
		
		return "/staff/emailPasswordUpdate.jsp";
	}

}
