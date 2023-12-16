package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// @RestController 어노테이션을 설정하면 return 값은 문자 그대로 반환한다.
// @Ctonroller 어노테이션을 설정하면 return 값은 지정한 경로를 반환한다.

@Controller
public class CommonController {

	@GetMapping(value = "/")
	public String main(Model model) {
		
		System.out.println("CommonController 진입 성공\n메인 페이지로 이동합니다.");
	
		String url = "/common/main";
		
		return url;
	
	}

	@GetMapping(value = "/loginPage")
	public String loginPage() {
		
		System.out.println("CommonController 진입 성공\n로그인 페이지로 이동합니다.");
		
		String url = "/common/loginPage";
		
		return url;
	
	}
	
	@GetMapping(value = "/signUpPage")
	public String signinPage() {
		
		System.out.println("CommonController 진입 성공\n회원가입 페이지로 이동합니다.");
		
		String url = "/common/signUpPage";
		
		return url;
	
	}
	
}
