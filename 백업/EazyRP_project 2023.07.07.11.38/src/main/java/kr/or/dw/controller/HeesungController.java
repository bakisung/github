package kr.or.dw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/heesung")
public class HeesungController {

	private static final Logger logger = LoggerFactory.getLogger(HeesungController.class);
	
	@RequestMapping("/main")
	public String main() {
		return "heesung/main";
	}
	
}
