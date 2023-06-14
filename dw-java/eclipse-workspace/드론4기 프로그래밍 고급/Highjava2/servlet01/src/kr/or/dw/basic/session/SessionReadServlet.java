package kr.or.dw.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionReadServlet.do")
public class SessionReadServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 저장된 Session 정보 읽어오기
		
		// 1. 세션 객체 가져오기
		HttpSession session = req.getSession();
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out= resp.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>저장된 Session 데이터 확인하기</h2><br><br>");
		
		// 2. getAttribute()메서드로 Session 값을 읽어온다.
		// 형식) session객체.getAttribute("세션key값");
		String sessionData = (String)session.getAttribute("testSession");
		if (sessionData == null) {
			out.println("<h3>testSession의 세션값이 없습니다.</h3>");
		} else {
			out.println("<h3>testSession의 세션값 : " + sessionData + "</h3>");
		}
		
		// 전체 세션 정보 구하기 ==> getAttributeNames()메서드 이용
		// 형식) session객체.getAttributeNames();
		//		==> 세션에 저장된 모든 '세션key'값들을 구해서 Enumeration 배열로 변환한다.
		
		out.println("<hr>");
		out.println("<h3>전체 세션 데이터 확인하기</h3>");
		out.println("<ol>");
		
		Enumeration<String> sessionNames = session.getAttributeNames();
		int cnt = 0;	// 세션 개수를 위한 변수 선언
		while (sessionNames.hasMoreElements()) {
			cnt++;
			String sessionKey = sessionNames.nextElement();
			out.println("<li>" + sessionKey + " : " + session.getAttribute(sessionKey) + "</li>");
		}
		if (cnt == 0) {
			out.println("<li>세션 데이터가 없습니다.</li>");
		}
		out.println("</ol>");
		
		// 세션을 구분하기 위한 고유한 값
		out.println("세션 ID : " + session.getId() + "<br>");
		// 생성시간 ==> 1970년 1월 1일부터 경과한 시간을 반환(밀리세컨드 단위)
		out.println("세션 생성 시간 : " + session.getCreationTime() + "<br>");
		// 최근 접근 시간 ==> 1970년 1월 1일부터 경과한 시간을 반환(밀리세컨드 단위)
		out.println("세션 최근 접근 시간 : " + session.getLastAccessedTime() + "<br>");
		// 세션 유효 시간 ==> 초 단위
		// 세션의 최근 접근 시간부터 세션 유효시간이 경과하면 세션이 자동으로 삭제된다.
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br><hr>");
		
		out.println("<a href='"+req.getContextPath()+"/basic/03/sessionTest.jsp'>시작문서로 이동</a>");
		out.println("</bodt></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
