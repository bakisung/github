package kr.or.dw.basic.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileUpLoadServlet.do")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 10,	// 10M, 파일 업로드시에 메모리에 임시로 올라갈 수 있는 용량
	maxFileSize = 1024 * 1024 * 30,			// 30M, 개별 파일의 제한 용량
	maxRequestSize = 1024 * 1024 * 50		// 50M, 전체 파일의 제한 용량
)
public class FileUploadServlet extends HttpServlet {

	// 업로드된 파일이 저장될 폴더 설정
	private static final String upload_dir = "c:/others/uploadFiles";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파일 업로드에서는 GET 방식을 사용할 수 없다.
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File fileUploadDirectory = new File(upload_dir);
		if (!fileUploadDirectory.exists()) {
			fileUploadDirectory.mkdirs();
		}
		
		String fileName = "";	// 업로드한 파일명이 저장될 변수
		
		List<UploadDetail> fileList = new ArrayList<>();
		
		// Part 개수만큼 반복
		for(Part part : req.getParts()) {
			fileName = getFileName(part);	// 파일명 구하기
			if ("".equals(fileName)) {
				continue;					// 파일 이름이 없으면 건너뛴다.
			}
			UploadDetail details = new UploadDetail();	// 파일 정보가 저장될 객체 생성
			details.setFileName(fileName);
			details.setFileSize(part.getSize() / 1024);	// kb 단위로 변환

			try {
				part.write(upload_dir + File.separator + fileName); // 파일 저장
				details.setUploadStatus("Success");
			} catch (IOException e) {
				details.setUploadStatus("fail : " + e.getMessage());
			}

			fileList.add(details);
		}
		
		req.setAttribute("uploadFileList", fileList);
		
		String view = "/basic/04/fileList.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
		
	}
	
	// Part 영역에서 업로드한 파일 이름을 구해서 반환하는 메서드
	private String getFileName(Part part) {
		/*
		 * - Part의 구조
		 * 1) 파일이 아닌 경우
		 * --------------------------------------------------- 	==> Part 의 구분선
		 * Content-Disposition : form-data; name="memId"		==> 파라미터명
		 * 		-------------------------- 빈 줄 ----------------------
		 * a001					파라미터값
		 * 
		 * 2) 파일인 경우 
		 * --------------------------------------------------- 	==> Part 의 구분선
		 * Content-Disposition : form-data; name="fileUpload1"; filename="test1.txt"	==> 파일 정보
		 * Content-Type : text/plain		==> 파일 종류
		 *  		-------------------------- 빈 줄 ----------------------
		 *  abcdef123가나다 				파일 내용
		 *  
		 *  Disposition : 기질, 성향, 배치, 배열 이란 뜻
		 *  HTTP Response Header 에 들어가는 Content-Disposition 은 HTTP Response Body에 오는 컨텐츠의 기질/성향을 알려주는 속성이다.
		 *  default 값은 inline 으로 web에 전달되는 data 라고 생각하면 된다.
		 *  특수한 경우는 Content-Disposition에 attachment 를 주는 경우로, 이 때 filename 과 함께 작성해주면
		 *  body에 오는 값을 다운로드 받으라는 뜻이 된다.
		 */
		String fileName = "";
		String contentDisposition = part.getHeader("content-disposition");
		System.out.println(contentDisposition);
		String[] items = contentDisposition.split(";");
		for(String item : items) {
			if (item.trim().startsWith("fileName")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		
		return fileName;
	}

}
