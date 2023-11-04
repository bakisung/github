package com.example.demo.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BoardService;
import com.example.demo.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public ModelAndView openBoardList(ModelAndView mnv) throws SQLException {

		System.out.println("BoardController 진입 성공\n" + "openBoardList 실행");
		
		mnv = new ModelAndView("/board/main");
		
		List<BoardVO> list = boardService.selectBoardList();
		mnv.addObject("list", list);
		
		return mnv;
	
	}
	
}
