package kr.or.dw.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieLogin.do")
public class CookieLogin extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String chkId = req.getParameter("chkId");
		
		Cookie idCookie = new Cookie("id", id);
		if(chkId != null) {
			res.addCookie(idCookie);
		}else {
			idCookie.setMaxAge(0);
			res.addCookie(idCookie);
		}
		
		// Forward 방식
		String url = "";
		if(id.equals("admin") && pwd.equals("1234")) {
			url = "/basic/02/cookieMain.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}else {
			PrintWriter out = res.getWriter();
			
			out.println("<html><head><meta charset='utf-8'><title>Cookie 연습</title></head>");
			out.println("<body>");
			out.println("<h2>로그인 실패 페이지</h2>");
			out.println("<a href='" + req.getContextPath() + "/basic/02/cookieLogin.jsp'>로그인 페이지로 이동</a>");
			out.println("</body></html>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
