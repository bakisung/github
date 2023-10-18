package kr.or.dw.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.or.dw.service.MemberService;

/**
 * Please explain the class!!
 *
 * @author : park hee sung
 * @fileName : CommonController
 * @since : 2023/10/16
 */

@RestController
@RequestMapping("/common")
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private MemberService memberService;
	
	// 메인 페이지로 이동
	@RequestMapping("/main.do")
	public ModelAndView main (ModelAndView mnv) throws Exception {
		
		System.out.println("CommonController -> /common/main.do");
		
		String url = "/common/main";
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	// 회원가입 페이지로 이동
	@RequestMapping(value = "/signinPage")
	public ModelAndView signin (ModelAndView mnv) throws Exception {
		
		System.out.println("CommonController -> /common/signinPage.do");
		
		String url = "/common/signinPage";
		mnv.setViewName(url);
		
		return mnv;
		
	}

	// 로그인 페이지로 이동
	@RequestMapping(value = "/loginPage")
	public ModelAndView login (ModelAndView mnv) throws Exception {
		
		System.out.println("CommonController -> /common/loginPage.do");
		
		String url = "/common/loginPage";
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
//	// 로그인 처리 (시큐리티를 사용하지 않는 버전)
//	@RequestMapping("/login.do")
//	public String login(String id, String password, HttpSession session) throws SQLException {
//		
//		System.out.println("CommonController -> /common/login.do");
//		System.out.println(id);
//		String url="/common/main";
//		memberService.login(id, password, session);
//		System.out.println(session);
//		
//		return url;
//	}
	
	@RequestMapping("/security/accessDenied")
	public String accessDenied(HttpServletResponse res) throws Exception{
		String url = "/security/accessDenied.open";
		
		res.setStatus(302);
		
		return url;
	}
	
	@RequestMapping("/common/LoginTimeOut")
	public void loginTimeOut(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<script>");
		out.println("alert('세션이 만료되었습니다.\\n다시 로그인하세요.')");
		out.println("location.href='/';");
		out.println("</script>");
		out.close();
	}
	
	@RequestMapping("/common/LoginExpired")
	public void loginExpired(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<script>");
		out.println("alert('중복 로그인이 확인되었습니다.\\n 다시 로그인하면 다른 장치의 로그인은 해제됩니다!')");
		out.println("location.href='/';");
		out.println("</script>");
		out.close();
	}
	
}
