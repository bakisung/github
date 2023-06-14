package kr.or.dw.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionAddServlet.do")
public class SessionAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Session 저장하는 방법
		
		// 1. Session 객체를 구한다.
		// 형식1) request객체.getSession(); 또는 request객체.getSession(true);
		// 		==> 현재 세션이 있으면 현재 세션을 반환하고, 없으면 새로 생성해서 반환한다.
		// 형식2) request객체.getSession(false);
		// 		==> 현재 세션이 있으면 현재 세션을 반환하고, 없으면 null을 반환한다.
		HttpSession session = req.getSession();
		
		// 세션의 유효기간 설정
		session.setMaxInactiveInterval(60*60*24*365);	// 최대허용 시간설정, 단위는 초
		// 2. setAttribute()메서드로 Session값 저장
		// 형식) session객체.setAttribute("세션key값", 세션값);
		// 		==> '세션key값'은 문자열, '세션값'은 모든 데이터 가능
		session.setAttribute("testSession", "연습용 세션입니다.");
		session.setAttribute("userName", "홍길동");
		session.setAttribute("age", 20);
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out= res.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Session 데이터가 저장되었습니다.</h2><br><br>");
		out.println("<a href='"+req.getContextPath()+"/basic/03/sessionTest.jsp'>시작문서로 이동</a>");
		out.println("</bodt></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
}
