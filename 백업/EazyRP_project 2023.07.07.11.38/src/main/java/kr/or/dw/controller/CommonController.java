package kr.or.dw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@GetMapping("/common/loginForm")
	public String loginForm() {
		return "/common/loginForm";
	}
	
	@GetMapping("/common/main")
	public String main() {
		return "/common/main";
	}
}
