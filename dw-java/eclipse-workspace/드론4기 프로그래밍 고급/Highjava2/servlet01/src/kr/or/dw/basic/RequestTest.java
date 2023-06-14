package kr.or.dw.basic;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestTest.do")
public class RequestTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// getParameter("파라미터명") ==> 해당 파라미터에 설정된 '값'을 가져온다.
		//						   ==> 가져오는 '값'의 자료형은 String이다.
		// 이 '파라미터명'은 <form> 태그의 하위 태그에 만들어진 태그의 'name속성값'을 말한다.
		String userName = req.getParameter("userName");
		String job = req.getParameter("job");
//		String hobby = req.getParameter("hobby"); 맨 앞에것만 나오기 때문에 여기선 겟파라미터를 못씀
		
//		getParameterValues("파라미터명") ==> 파라미터명이 같은것이 여러개일 경우에 사용한다.
//									  ==> 가져오는 '값'의 자료형은 String[] 이다.
		String[] hobbies = req.getParameterValues("hobby");
		System.out.println("userName : " + userName);
		System.out.println("job : " + job);
		System.out.println("hobby : " + Arrays.toString(hobbies));
	}

}
