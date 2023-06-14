package kr.or.dw.basic.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionLogoutServlet.do")
public class SessionLogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 세션을 삭제한 후 main페이지로 이동
		HttpSession session = req.getSession();
		
		session.invalidate();
		
		String viewPage = "basic/03/sessionMain.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
