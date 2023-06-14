package jservlet02.s02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/Login")
public class Login extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("login init!!");
	}
	
	@Override
	public void destroy() {
		System.out.println("login destroy!!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login doGet");
		
		req.setCharacterEncoding("UTF-8");
		
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		System.out.println("userId : " + userId);
		System.out.println("userPw : " + userPw);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}


}
