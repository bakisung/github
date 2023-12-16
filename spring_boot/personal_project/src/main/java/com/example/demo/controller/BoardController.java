package com.example.demo.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.BoardService;
import com.example.demo.vo.BoardVO;
import com.google.gson.JsonObject;


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
    
    // 게시글 상세페이지로 이동
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
    
    // 게시글 수정 페이지로 이동
    @GetMapping(value = "/{board_no}/edit")
    public ModelAndView modifyFormBoard(ModelAndView mnv, @PathVariable String board_no) throws SQLException {
    	
    	System.out.println("BoardController 진입\n" + "modifyBoard 실행");
    	System.out.println("board_no : " + board_no);
    	
    	BoardVO board = boardService.selectBoardDetail(board_no);
    	String url = "/board/modifyForm";
    	
    	mnv.setViewName(url);
    	mnv.addObject("board", board);
    	
    	return mnv;
    }
    
    // 게시글 수정
    
//    // 서머노트 이미지 첨부
//    @PostMapping(value = "/image", produces = "application/json; charset=utf8")
//    @ResponseBody
//    public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest req) throws IOException {
//
//    	System.out.println("BoardController 진입\n" + "uploadSummernoteImageFile 실행");
//    	System.out.println("multipartFile : " + multipartFile);
//    	
////    	JsonObject json = new JsonObject();
//    	
////    	String fileRoot = EgovProperties.getProperty("Globals.tempDir");
////    	String originalFileName = multipartFile.getOriginalFilename();	// 오리지널 파일명
////    	String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); 	// 파일 확장자
////    	
////    	String savedFileName = UUID.randomUUID() + extension;	// 저장될 파일명
////    	File targetFile = new File(fileRoot + savedFileName);
////    	
////    	try {
////    		// 파일 저장
////    		InputStream fileStream = multipartFile.getInputStream();
////    		FileUtils.copyInputStreamToFile(fileStream, targetFile);
////    		
////    		// 파일을 열기 위해여 common/getImg.do 호출 / 파라미터로 savedFileName 보냄
////    		json.addProperty("url", "common/getImg.do?savedFileName=" + savedFileName);
////    		json.addProperty("responseCode", "success");
////		} catch (IOException e) {
////			FileUtils.deleteQuietly(targetFile);
////			json.addProperty("responseCode", "error");
////			e.printStackTrace();
////		}
//    	
////    	String jsonvalue = json.toString();
//    	
////    	return jsonvalue;
//    	
//    	return null;
//    };
    
    // 서머노트 이미지 업로드 파일을 temp(임시) 폴더에 저장
    @PostMapping(value = "/uploadSummernoteImageFile", produces = "application/json; charset=utf8")
    @ResponseBody
    public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
    	
    	// 저장 루트
    	String realPath = "/Users/park/Downloads/realPath/"; // 임시로 설정해두었으니 수정 필요 예상

    	System.out.println("BoardController 진입\n" + "uploadSummernoteImageFile 실행");
    	System.out.println("multipartFile : " + multipartFile);
    	
    	// json 객체 생성
    	JsonObject jsonObject = new JsonObject();
    	
    	// 이미지 파일이 저장될 경로
    	String contextRoot = realPath + "/upload_image/image/fileupload/29/";
    	String fileRoot = contextRoot;
    	
    	// 업로드된 파일의 원본 파일명과 확장자를 추출한다.
    	String originalFileName = multipartFile.getOriginalFilename();	// 파일명
    	String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	// 확장자
    	
    	// 새로운 파일명 생성 (고유한 식별자 + 확장자)
    	String savedFileName = UUID.randomUUID() + extension;
    	
    	// 저장될 파일의 경로와 파일명을 나타내는 File 객체 생성
    	File targetFile = new File(fileRoot + savedFileName);
    	
    	try {
			// 업로드된 파일의 InputStream 얻기
    		java.io.InputStream fileStream = multipartFile.getInputStream();
    		
    		// 업로드된 파일을 지정된 경로에 저장
    		// 2023.11.19 copyInputStreamToFile 메소드를 불러오지 못하는 이슈가 있었다.
    		// 원인은 FileUtils 객체를 임포트 할때, commons가 아닌 tomcat으로 임포트한게 원인이었다.
    		FileUtils.copyInputStreamToFile(fileStream, targetFile);
    		
		} catch (Exception e) {
			
		}
    	
    	// JSON 객체를 문자열로 변환하여 반환
        String a = jsonObject.toString();
        
        return a;
    };
    
}
