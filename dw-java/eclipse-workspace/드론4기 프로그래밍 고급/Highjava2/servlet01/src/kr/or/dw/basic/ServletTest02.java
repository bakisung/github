package kr.or.dw.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @WebServlet 어노테이션은 Servlet 버전 3.0 이상에서 사용할 수 있다.
 *
 * @WebServlet 어노테이션의 속성들
 * 1. name : 서블릿의 이름을 설정한다. (기본값 : 빈 문자열(""))
 * 2. value : 서블릿의 URL 패턴을 설정한다.
 * 3. urlPatterns : 서블릿의 URL 패턴의 목록을 설정한다. (기본값 : 빈 배열( {} ))
 * 		예) : urlPatterns="/url1" 또는 urlPatterns={"/url1"} ==> 패턴이 1개일 경우
 * 		예) : urlPatterns={"/url1", "/url2", ...} ==> 패턴이 2개 이상일 경우
 * 4. description : 주석(설명글)을 설정한다.
 */

@WebServlet(urlPatterns = {"/ServletTest02.do"}, description = "어노테이션을 이용한 서블릿 예제입니다.")
public class ServletTest02 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8");	// 응답 문서의 인코딩 방식 지정
		res.setContentType("text/html; charset=utf-8");	// 응답 문서의 ContentType 지정
		System.out.println("request : " + req + " / response : " + res);
		// 처리한 내용을 응답으로 보내기 위해서 PrintWriter 객체를 생성한다.
		PrintWriter out = res.getWriter();

		// 처리한 내용을 출력한다.
		// 방법2) print()메서드 또는 println()메서드 이용하기
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>두번째 Servlet 연습</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 style='text-align:center; color:blue;'>");
		out.println("안녕하세요. 두번째 Servlet 프로그램입니다.<br>");
		out.println("Server 경로 : " + req.getContextPath());
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");

	}

}
