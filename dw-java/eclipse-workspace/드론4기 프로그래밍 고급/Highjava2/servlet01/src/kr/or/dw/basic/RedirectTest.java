package kr.or.dw.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectTest.do")
public class RedirectTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// redirect 로 넘어온 데이터 구하기
		String userName = req.getParameter("userName");
		String tel = req.getParameter("tel");
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		out.println("<html><head><meta charset='UTF-8'><title>리다이렉트 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Response Redirect 결과</h2>");
		out.println("<table border='1'>");
		out.println("<tr><td>이름 : " + userName + "</td></tr>");
		out.println("<tr><td>전화 : " + tel + "</td></tr>");
		out.println("</table>");
		out.println("<script>alert('userName, tel : " + userName + ", " + tel + "')</script>");
		out.println("</body></html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
