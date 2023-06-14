package kr.or.dw.user.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.web.IAction;

public class UserLogoutAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.invalidate();
		
		req.setAttribute("title_nm", "Starter");
		
		return "/user/main.jsp";
	}

}
