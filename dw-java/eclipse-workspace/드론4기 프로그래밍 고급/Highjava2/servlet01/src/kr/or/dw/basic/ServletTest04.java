package kr.or.dw.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest04.do")
public class ServletTest04 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*
		 * Servlet 클래스나 JSP 페이지의 환경에 관한 정보는 ServletContext 인터페이스 타입의 객체를 이용해서 구할 수 있다.
		 */
		ServletContext context = this.getServletContext();
		String serverInfo = context.getServerInfo(); // Servlet이 속한 웹 서버의 종류 구하기

		// 웹 컨테이너가 지원하는 Servlet 규격서의 메이저 버전과 마이너 버전 구하기
		int majorVersion = context.getMajorVersion();
		int minorVersion = context.getMinorVersion();

		String servletName = this.getServletName();
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=utf-8");

		PrintWriter out = res.getWriter();
		out.println("<html><head><meta charset='utf-8'><title>웹 서버의 정보</title></head>");
		out.println("<body>");
		out.println("웹 서버의 종류(ServerInfo) : " + serverInfo + "<br>");
		out.println("serverName : " + servletName + "<br>");
		out.printf("지원하는 Servlet 버전(MajorVersion, MinorVersion) : (%d, %d)<br><br>", majorVersion, minorVersion);

		/*
		 * 웹 애플리케이션의 초기화 파라미터(web.xml에 설정한 값)
		 * 특정 Servlet에 속하는 초기화 파라미터가 아닌 웹 애플리케이션 전체에 속하는 초기화 파라미터이다.
		 *
		 * 이 초기화 파라미터는 web.xml 파일이 속한 웹 애플리케이션 디렉토리의 모든 웹 컴포넌트에서 읽기가 가능하다.
		 *
		 * Servlet 클래스에서는 getServletContext() 메서드를 통해 ServletContext 객체를 구하고,
		 * 이 객체의 getInitParameter() 메서드를 이용해서 구할 수 있다.
		 *
		 * JSP 페이지에서는 application 이라는 내장 객체변수의 getInitParameter() 메서드를 이용해서 구한다.
		 *
		 * 형식) getInitParameter("param-name값");
		 */
		String fileName = context.getInitParameter("FileName");
		out.println("web.xml에 설정한 파라미터 : " + fileName + "<br></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		super.doPost(req, res);
	}

}
