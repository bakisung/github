package kr.or.dw.assign.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.web.IAction;

public class InsertAssignFormAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String lec_code = req.getParameter("lec_code");
		req.setAttribute("lec_code", lec_code);
		req.setAttribute("titleName", "과제 조회");
		return "/staff/score/assignInsertForm.jsp";
	}

}
