package com.example.demo.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping(value="")
	public ModelAndView main(ModelAndView mnv, String url) throws SQLException {
		System.out.println("BoardController 진입 성공\n" + "main 메소드 실행");
		
		url = "/board/main";
		
		List<BoardVO> boardList = boardService.selectBoardList();
		mnv.addObject("boardList", boardList);
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
    @PostMapping(value = "")
    public ResponseEntity<String> regist(@RequestBody BoardVO boardVO) throws SQLException{
    	
    	// @RequestBody 어노테이션은 사용자가 POST 요청에 담아 보낸 데이터를 자바 객체로 변환한다.
    	// 즉, JSON 형식으로 데이터를 전송하면, 이를 BoardVO 객체로 변환하여 사용할 수 있다.
    	// 그 때문에 해당 메소드에서 따로 데이터를 set 해주지 않아도 된다.
    	// 그에 따라 BoardVO에 속한 변수명과 jsp 파일의 코드에서 담긴 name 값이 서로 일치해야 하는것 같다. (검증 필요)
    	
    	System.out.println("BoardController 진입 성공\n" + "regist 실행");

    	System.out.println("boardVO : " + boardVO);
    	System.out.println("title : " + boardVO.getTitle());
    	System.out.println("content : " + boardVO.getContent());
    	
        try {
        	
        	System.out.println("try 진입");
        	System.out.println("registBoard 실행 전");
            boardService.registBoard(boardVO);
            System.out.println("registBoard 실행 후");
            
            return new ResponseEntity<>("게시글 등록 성공.", HttpStatus.OK);
            
        } catch (Exception e) {
        	
        	System.out.println("catch 진입");
        	
            return new ResponseEntity<>("게시글 등록 실패", HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
    }
    
    // 게시글 상세페이지
    @GetMapping(value = "/{board_no}")
    public ModelAndView selectBoardDetail(ModelAndView mnv, @PathVariable String board_no) throws SQLException {
    	
    	System.out.println("BoardController 진입 \n" + "selectBoardDetail 실행");
    	System.out.println("board_no : " + board_no);
    	
    	BoardVO board = boardService.selectBoardDetail(board_no);
    	String url = "/board/detail";
    	
    	mnv.setViewName(url);
    	mnv.addObject("board", board);
    	
    	return mnv;
    }
    
}
