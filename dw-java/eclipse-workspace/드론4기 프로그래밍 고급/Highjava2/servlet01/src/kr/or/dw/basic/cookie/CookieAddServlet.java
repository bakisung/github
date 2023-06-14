package kr.or.dw.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 쿠키 저장용 서블릿
@WebServlet("/CookieAddServlet.do")
public class CookieAddServlet extends HttpServlet{
	
	// 쿠키란?
	
	// 쿠키 기본
	// 1) 기본적으로 클라이언트의 소유
	// 2) 서버에 요청시 헤더에 자동으로 포함해서 전송됨
	// 3) 주로 서버단의 필요에 의해 클라이언트에 생성하도록 지시 (Set-Cookie) 예) JSESSIONID
	// 4) HttpOnly, Secure 속성은 서버 -> 클라이언트로 던져주며, 클라이언트 -> 서버는 값을 주지 않음.
	
	// - 세션 쿠키 vs 영구적 쿠키
	// 1) 만료시각을 지정하면 영구적 쿠키, 파일 저장
	// 2) 만료시각이 없으면 세션 쿠키, 메모리 저장, 브라우저 닫으면 삭제됨
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		
		// Cookie 저장하는 방법
		// 1) Cookie 객체를 생성한다.
		// 형식) Cookie cookie변수 = new Cookie("쿠키변수", "쿠키값");
		//		==> '쿠키변수'와  '쿠키값'은 문자열로 지정한다.
		//		==> '쿠키값'으로 한글을 사용할 경우 URLEncoder.encode()메서드로 인코딩 후 사용한다.
		// 쿠키는 쿠키를 생성한 서버에만 전송된다. ==> 다른 사이트로 연결할 때에는 전송되지 않는다.
		// 한 도메인당 20개, 쿠키 하나당 4KB
		Cookie nameCookie = new Cookie("name", URLEncoder.encode("홍길동", "utf-8"));
		Cookie ageCookie = new Cookie("age", "20");
		Cookie genderCookie = new Cookie("gender", "Male");
		
		// 2)response 객체를 이용하여 쿠키를 웹브라우저로 보낸다.
		// 그러면 웹브라우저가 이쿠키를 받아서 저장한ㄷ,
		// 형식) respones.addCookie(1번에서 만든 cookie객체)
		resp.addCookie(nameCookie);
		resp.addCookie(ageCookie);
		resp.addCookie(genderCookie);
		
		resp.setContentType("text/html; charest-utf-8");
		PrintWriter out= resp.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Cookie 데이터가 저장되었습니다.</h2><br><br>");
		out.println("<a href='"+req.getContextPath()+"/basic/02/cookieTest.jsp'>시작문서로 이동</a>");
		out.println("</bodt></html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
