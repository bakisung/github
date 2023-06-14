package kr.or.dw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.member.service.IMemberService;
import kr.or.dw.member.service.MemberServiceImpl;
import kr.or.dw.vo.MemberVO;

public class TestController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		/*
		 * URL ==> http://localhost/servlet02/member/memberList.do
		 * URI ==>				   /servlet02/member/memberList.do
		 * 요청 URI ==>						 /member/memberList.do
		 * ContextPath ==>		   /servlet02
		 */
		
		// 사용자의 요청정보 가져오기
		String uri = req.getRequestURI();
		
		System.out.println("uri = " + uri);
		
		String view = "";	// view 페이지가 저장될 변수
		
		if(uri == null) {
			// 반환할 uri가 없으면 404에러 처리
			res.setStatus(HttpServletResponse.SC_NOT_FOUND);	// 404
		}else if("/member/memberList.do".equals(uri)) {
			IMemberService memService = MemberServiceImpl.getInstance();
			List<MemberVO> memList = memService.getAllMember();
			
			req.setAttribute("memList", memList);
			view = "/member/memberList.jsp";
		}else if("/member/insertMember.do".equals(uri)) {
			IMemberService memService = MemberServiceImpl.getInstance();
			
		}
		
		// 해당 view로 포워딩 한다.
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view" + view);
		rd.forward(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	
}
