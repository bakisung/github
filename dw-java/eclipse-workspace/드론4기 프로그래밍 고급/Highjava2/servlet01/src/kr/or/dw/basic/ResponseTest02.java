package kr.or.dw.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseTest02.do")
public class ResponseTest02 extends HttpServlet{
	
	// forward 용 서블릿
	// forward - 특정 서블릿에 대한 요청을 다른 서블릿이나 JSP로 넘겨준다.
	// 상대방에게 페이지 주소를 숨길때 사용할 수 있으며, redirect 보다 성능이 좋다.
	// URL 주소는 바뀌지 않으며, 내부에서만 접근이 가능하다.
	
	// 이때 사용하는 객체는 RequestDispatcher 객체이다.
	
	// 이동되는 페이지로 값을 넘기려면 request 객체의 setAttribute()메서드로 데이터를 셋팅하여 보내고
	// 받는쪽에서는 getAttribute()메서드로 데이터를 읽어온다.
	// 형식) setAttribute("key값", value값);	// key 값은 문자열만, value 값은 모든 데이터 사용 가능

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 보내온 데이터 받기
		String id = req.getParameter("id");
		String pwd =req.getParameter("pwd");
		
		req.setAttribute("tel", "010-112-119");		// Object 타입으로 넘어간다. (value는 모든 데이터 사용 가능하기 때문에)
		
		// getRequestDispatcher("forward할 서블릿 문서명");
		RequestDispatcher rd = req.getRequestDispatcher("/basic/01/jspTest.jsp");
		
		rd.forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, res);
	}
	
	
	
}
