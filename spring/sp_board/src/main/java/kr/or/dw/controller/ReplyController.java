package kr.or.dw.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.dw.command.PageMaker;
import kr.or.dw.command.SearchCriteria;
import kr.or.dw.service.ReplyService;
import kr.or.dw.vo.ReplyVO;

// url : /replies
// /replies/all/{bno}			list : GET방식, bno번 게시글의 댓글 목록
// /replies/{rno}				modify : PUT, PATCH 방식, rno 댓글의 수정
// /replies/{bno}/{rno}/{page}	remove : DELETE 방식, rno 댓글의 삭제
// /replies						regist : POST 방식, 댓글 입력
// /replies/{bno}/{page}		page list : GET방식

@Controller
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO reply) throws SQLException {
		ResponseEntity<String> entity = null;
		
		try {
			replyService.registReply(reply);
			
			SearchCriteria cri = new SearchCriteria();
			
			Map<String, Object> dataMap = replyService.selectReplyList(reply.getBno(), cri);
			PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
			int realEndPage = pageMaker.getRealEndPage();
			
			entity = new ResponseEntity<String>(realEndPage + "", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
		
	}
	
	@RequestMapping(value="/{bno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> replyList(@PathVariable int bno, @PathVariable int page) {
		ResponseEntity<Map<String, Object>> entity = null;
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		
		try {
			Map<String, Object> dataMap = replyService.selectReplyList(bno, cri);
			entity = new ResponseEntity<Map<String,Object>>(dataMap, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
//	@RequestMapping(value="/{bno}/{rno}/{page}", method=RequestMethod.POST)
//	public ResponseEntity<String> removeReply(@PathVariable int bno, @PathVariable int rno, @PathVariable int page){
//		
//		ResponseEntity<String> entity = null;
//		
//		try {
//			replyService.removeReply(rno);
//			
//			SearchCriteria cri = new SearchCriteria();
//			cri.setPage(page);
//			
//			Map<String, Object> dataMap = replyService.selectReplyList(bno, cri);
//			PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
//			int startPage = pageMaker.getStartPage();
//			
//			entity = new ResponseEntity<String>(startPage + "", HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		return entity;
//		
//	}

}
