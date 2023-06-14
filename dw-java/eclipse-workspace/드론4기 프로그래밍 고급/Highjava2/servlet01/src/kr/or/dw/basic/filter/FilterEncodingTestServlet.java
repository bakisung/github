package kr.or.dw.basic.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FilterEncodingTestServlet.do")
public class FilterEncodingTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("userName");
		
		System.out.println("name : " + name);
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html><head><meta charset='utf-8'></head>");
		out.println("<body>");
		out.println("<h1>당신의 이름은 " + name + "이군요</h1>");
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
