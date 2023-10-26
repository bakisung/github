package com.example.demo.Controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/common")
public class CommonController {

	@GetMapping(value = "/main")
	public String main(HttpServletResponse res) throws Exception {
	
		String url = "/common/main";
		
		return url;
	
	}
	
}
