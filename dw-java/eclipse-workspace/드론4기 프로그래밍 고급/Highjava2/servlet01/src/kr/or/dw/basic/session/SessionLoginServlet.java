package kr.or.dw.basic.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionLoginServlet.do")
public class SessionLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET 방식으로 요청하면 세션을 확인해서 없으면 sessionLogin.jsp 페이지로 이동
		// 세션에 값이 있으면 sessionLoginResult.jsp 페이지로 이동
		HttpSession session = req.getSession();
		
		String viewPage = "/basic/03/sessionLoginResult.jsp";
		// 세션값 읽기
		String memId = (String)session.getAttribute("memId");
		if(memId == null) {
			viewPage = "/basic/03/sessionLogin.jsp";
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POST 방식으로 요청이 오면 로그인 검증 작업을 수행한다.
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		String viewPage = "/basic/03/sessionLoginResult.jsp";
		HttpSession session = req.getSession();
		if (id != null && pwd != null) {
			if (id.equals("admin") && pwd.equals("1234")) {
				session.setAttribute("memId", id);
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}

}
