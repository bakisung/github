package heesung;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. index 페이지에서 로그인을 하면  해당 서블렛이 동작한다.
		// 2. if문에서 id와 password 값을 비교한다. 
		// 3. "memid" 키값에 담긴 value 값(id)을 해당 session에 등록한다.
		// 4. 클라이언트로부터 들어온 요청을 loginResult.jsp에 보낸다.
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		String loginResult = "/01/loginResult.jsp";
		HttpSession session = req.getSession();
		if (id != null && password != null) {
			if (id.equals("dongju") && password.equals("1004")) {
				session.setAttribute("memId", id);
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher(loginResult);
		rd.forward(req, resp);
	}
	
}
