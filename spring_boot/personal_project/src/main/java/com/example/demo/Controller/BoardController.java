package com.example.demo.Controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BoardService;
import com.example.demo.vo.BoardVO;

@RestController
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
	
	// 게시글 등록 (RESTful API 방식)
    @PostMapping(value = "/regist")
    public ResponseEntity<String> regist(@RequestBody BoardVO boardVO) throws SQLException{
    	
    	System.out.println("BoardController 진입 성공\n" + "regist 실행");

    	System.out.println("boardVO : " + boardVO);
    	System.out.println("title : " + boardVO.getTitle());
    	System.out.println("content : " + boardVO.getContent());
    	
        try {
        	
        	System.out.println("try 진입");
        	System.out.println("registBoard 실행 전");
            boardService.registBoard(boardVO);
            System.out.println("registBoard 실행 후");
            
            return new ResponseEntity<>("게시글이 등록되었습니다.", HttpStatus.OK);
            
        } catch (Exception e) {
        	
        	System.out.println("catch 진입");
        	
            return new ResponseEntity<>("게시글 등록에 실패했습니다. 다시 시도해주세요.", HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }
	
}
