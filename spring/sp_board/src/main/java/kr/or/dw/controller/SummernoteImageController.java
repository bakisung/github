package kr.or.dw.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SummernoteImageController {

	@Resource(name = "imgPath")
	private String imgPath;
	
	@RequestMapping("/uploadImg")
	public ResponseEntity<String> uploadImage(MultipartFile file, HttpServletRequest req) {
		ResponseEntity<String> result = null;
		
		int fileSize = 5 * 1024 * 1024;
		
		if (file.getSize() > fileSize) {
			return new ResponseEntity<String>("용량을 초과했다네..", HttpStatus.BAD_REQUEST);
		}
		
		return null;
	};
	
}
