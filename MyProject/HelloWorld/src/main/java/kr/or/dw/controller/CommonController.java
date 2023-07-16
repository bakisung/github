package kr.or.dw.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.dw.service.MemberService;


@Controller
@RequestMapping("/common")
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private MemberService memberService;
	
	// 메인 페이지로 이동
	@RequestMapping("/main.do")
	public String main () throws Exception {
		
		System.out.println("CommonController -> /common/main.do");
		
		String url = "/common/main";
		return url;
		
	}
	
	// 로그인 페이지로 이동
	@RequestMapping("/loginPage.do")
	public String login () throws Exception {
		
		System.out.println("CommonController -> /common/loginPage.do");
		
		String url = "/common/loginPage";
		return url;
		
	}
	
	// 로그인 처리
	@RequestMapping("/login.do")
	public String login(String id, String password, HttpSession session) throws SQLException {
		
		System.out.println("CommonController -> /common/login.do");
		System.out.println(id);
		String url="/common/main";
		memberService.login(id, password, session);
		System.out.println(session);
		
		return url;
	}
	
}
