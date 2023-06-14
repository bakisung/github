package kr.or.dw.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 서블릿 동작 방식(Servlet의 LifeCycle)
 *
 * 1. 사용자가(클라이언트) URL을 클릭하면 HttpRequest를 Servlet Container로 전승(요청)한다.
 * 2. 컨테이너는 web.xml에 정의된 URL 패턴을 확인하여 어느 서블릿을 통해서 처리할지를 검색한다.
 * 		(해당 서블릿이 로딩이 안된 경우에는 로딩을 한다. ==> 로딩시 init() 메서드가 호출된다.)
 * 		(Servlet 3.0 이상에서는 어노테이션(@WebServlet)으로 설정 가능하다.)
 * 3. Servlet Container는 요청을 처리할 때 개별 쓰레드 객체를 생성하여 해당 서블릿 객체의 service() 메서드를 호출한다
 * 		(이때 HttpServletRequest 및 HttpServletResponse 객체를 생성하여 파라미터로 넘겨준다.)
 * 4. service() 메서드는 method 타입을 체크하여 적절한 메서드를 호출한다.
 * 		(doGet(), doPost(), doPut(), doDelete()등...)
 * 5. 요청 처리가 완료되면 HttpServletRequest 및 HttpServletResponse 객체는 소멸된다.
 * 6. 컨테이너에서 해당 서블릿이 제거되는 경우에는 destroy() 메서드가 호출된다.
 */

@WebServlet("/ServletTest03.do")
public class ServletTest03 extends HttpServlet{

	// 생성자
	public ServletTest03() {
		System.out.println("생성자 호출입니다.");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet : " + this.getServletName() + "에서 init()메서드 호출입니다.");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("service() 메서드 호출입니다.");
		super.service(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet() 메서드 호출...");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();

		out.println("<html><head><meta charset='utf-8'></head>");
		out.println("<body><h1>doGet() 메서드 처리 결과입니다.</h1></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost() 메서드 호출...");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();

		out.println("<html><head><meta charset='utf-8'></head>");
		out.println("<body><h1>doPost() 메서드 처리 결과입니다.</h1></body></html>");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
