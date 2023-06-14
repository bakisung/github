package kr.or.dw.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCheckServlet.do")
public class LoginCheckServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// Redirect 방식
//		String id = req.getParameter("id");
//		String pwd = req.getParameter("pwd");
//		
//		System.out.println("id / pwd : " + id + " / " + pwd);
//		
//		if(id.equals("admin") && pwd.equals("1234")) {
//			// 아이디와 비밀번호가 일치할 때
//			res.sendRedirect("/servlet01/basic/01/main.jsp");
//		}else {
//			// 아이디 혹은 비밀번호가 틀릴 때
//			res.sendRedirect("/servlet01/loginCheck.jsp");
//		}
		
		// Forward 방식
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		RequestDispatcher rd = null;
		String url = "";
		if(id.equals("admin") && pwd.equals("1234")) {
			url = "/basic/01/main.jsp";
		}else {
			url = "/basic/01/loginFail.jsp";
		}
		rd = req.getRequestDispatcher(url);
		rd.forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

	
	
}
