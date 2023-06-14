package heesung.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		HttpSession session = req.getSession();
		String mainPage = "/heesung/login/mainPage.jsp";
		
//		if (id != null && password != null) {
//			if (id.equals("dongju") && password.equals("1004")) {
				session.setAttribute("userId", id);
				session.setAttribute("userPassword", password);
//			} else {
				
//			}
//		} 
		
		RequestDispatcher rd = req.getRequestDispatcher(mainPage);
		rd.forward(req, resp);
		
	}

}
