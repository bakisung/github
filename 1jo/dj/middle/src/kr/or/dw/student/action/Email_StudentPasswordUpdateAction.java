package kr.or.dw.student.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.web.IAction;

public class Email_StudentPasswordUpdateAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String stu_id = req.getParameter("stu_id");
		req.setAttribute("stu_id", stu_id);
		
		req.setAttribute("titleName", "비밀번호 변경");
		
		return "/student/emailPasswordUpdate.jsp";
	}

}
