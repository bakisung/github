package com.example.demo.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BoardService;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 게시판 메인 페이지로 이동
	@GetMapping(value="/main")
	public ModelAndView main(ModelAndView mnv, String url) throws SQLException {

		System.out.println("BoardController 진입 성공\n" + "main 실행");
		
		url = "/board/main";
		
//		List<BoardVO> boardList = boardService.selectBoardList();
//		mnv.addObject("boardList", boardList);

		mnv.setViewName(url);
		
		return mnv;
	
	}
	
	// 게시글 등록 페이지로 이동
	@GetMapping(value = "/registForm")
	public ModelAndView registForm(ModelAndView mnv, String url) {
		
		System.out.println("BoardController 진입 성공\n" + "registForm 실행");

		url = "/board/registForm";
		
		mnv.setViewName(url);
		
		return mnv;
		
	}
	
	// 게시글 등록
	@PostMapping(value = "/regist")
	public void regist(HttpServletResponse res, String board_no) throws IOException {
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<script>");
		out.println("alert('게시글이 등록 되었습니다.')");
		out.println("window.opener.location.reload();");
		out.println("window.close();");
		out.println("</script>");
		
	}
	
}
