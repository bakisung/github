package kr.or.dw.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseTest01.do")
public class ResponseTest01 extends HttpServlet{
	// redirect 용 서블릿
	// redirect ==> 다른 페이지로 넘어가도록 하는 기능
	// 요청을 받게되면 url을 클라이언트에게 전달하고, 클라이언트(웹브라우저)가 새로운 url 을 요청하고 그에
	// 따른 응답을 한다.
	// url 값이 넘어가기 때문에 길이에 제한이 있다. (GET방식 규칙)

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 보내온 데이터 받기
		String id = req.getParameter("id");
		String pwd =req.getParameter("pwd");
		
		// 파라미터로 받아온 데이터를 넣어서 전송할 예정
		// 형식) sendRedirect("리다이렉트할 URL 주소");
		//		전송할 데이터는 GET 방식으로 보낼 수 있다.
		//		GET 방식은 path 뒤에 ?(파라미터라는 표시)를 써주고 넘겨줄 파라미터를 써준다.
		res.sendRedirect("/servlet01/basic/01/jspTest.jsp?userId=" + id + "&pwd=" + pwd);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, res);
	}
	
	
	
}
