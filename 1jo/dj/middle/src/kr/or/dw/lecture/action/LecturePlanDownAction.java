package kr.or.dw.lecture.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.web.IAction;

public class LecturePlanDownAction implements IAction{

	@Override
	public boolean isRedirect() {

		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String plan_path = req.getParameter("plan_path");
		String planName = plan_path.split("/")[1].trim();
		
		String realPath = "C:/upload/planFile/" + plan_path;
		
		File file = new File(realPath);
		
		if(file.exists()) {
			FileInputStream fin = null;
			OutputStream out = null;
			try {
				// MIME (Multipurpose Internet Mail Extensions)
				//"다목적 인터넷 확장 메일" 이라는 뜻으로, 웹을 통해 여러 형태의 파일을 전달하는데 사용됨
				//(이메일과 함께 첨부한 파일을 텍스트 문자로 전환하여 email system으로 전달하기 위해 개발됨
				//UUEncode 방식 : ASCII 파일만 가능
				//MIME : Binary File(music, movie, word files, ...) -> Text File
				
				//개별타입
				//1) text
				//- 특정 문자셋으로 구성된 텍스트 정보 or formatted text 정보
				//ex: text/plain, text/html, text/css, text/javascript
				//2) audio
				//- 모든 종류의 오디오
				//ex: audio/midi, audio/mpeg, audio/wav
				//3) video
				//- 모든 종류의 비디오
				//ex: video/webm, video/ogg
				//4) application
				//- 모든 Binary Data
				//ex: application/octet-stream, application/vnd.mspowerpoint, application/pdf
				
				//멀티파트 타입: 일반적으로 다른 MIME타입들을 지닌 개별적인 파트들로 나누어지는 문서의 카테고리
				//ex: multipart/form-data, multipart-byteranges
				
				//그래서 application/octet-stream
				//MIME의 개별 타입 중 application에 속하는 타입. 8비트 단위의 Binary data라는 뜻
				//브라우저가 보통 자동으로 실행하지 않거나 실행할 지 묻기도 하는 타입
				//Content-Disposition 헤더를 attachment 로 줌으로써 해당 데이터를 수신받은 브라우저가 저장할 수 있도록 설정할 수 있다.
				
				
				//ContentType설정
				res.setContentType("aplication/octet-stream; charset=utf-8");
				
				String encodedFileName = getFileNameEncoding(planName, getBrowser(req));
				
				//Response의 Header content-disposition 속성 성정
				res.setHeader("Content-Disposition", "attachment; fileName=\"" + encodedFileName + "\"");
				
				//출력용 스트림 객체 생성 ==> Response 객체 이용
				out = res.getOutputStream();
				
				//파일입력용 스트림 객체
				fin = new FileInputStream(file);
				
				byte[] buffer = new byte[8192];
				int bytesRead = -1;
				
				//byte 배열을 이용해서 파일 내용을 읽어와 출력용 스트림으로 출력한다.
				while((bytesRead = fin.read(buffer)) != -1) {
					out.write(buffer, 0, bytesRead);
				}
				
				out.flush();
			}catch(IOException e){
				System.out.println("입출력 오류 : " + e.getMessage());
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				if(fin != null) fin.close();
				if(out != null) out.close();
			}
		}else {	//파일이 없을경우의 처리
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=utf-8");
			res.getWriter().println("<h3>파일이 존재하지 않습니다.</h3>");
		}
		req.setAttribute("titleName", "강의 관리");
		
		return null;
	}
	
	//사용중인 웹브라우저 종류를 반환하는 메서드
		private String getBrowser(HttpServletRequest req) {
			String header = req.getHeader("User-Agent");
			//User-agent = Http 요청을 보내는 디바이스와 브라우저 등 사용자 소프트웨어의 식별 정보가 담겨있음
			//임의로 수정될 수 없는 값
			//보통은 요청을 보낸 사용자 환경을 알아보기 위해 사용한다.
			
			if(header.indexOf("MSIE") > -1) {
				return "MSIE";
			}else if(header.indexOf("Chrome") > -1) {
				return "Chrome";
			}else if(header.indexOf("Opera") > -1) {
				return "Opera";
			}else if(header.indexOf("Trident") > -1) {
				return "Trident";
			}
			
			return "Firefox";
			
		}
		
		//웹브라우저별로 한글 파일명을 인코딩해서 반환하는 메서드
		private String getFileNameEncoding(String fileName, String browser) throws Exception {
			//인코딩된 파일명이 저장될 변수
			String encodedFileName = null;
			
			if(browser.equals("MSIE")) {
				//URLEncode를 실행하면 띄어쓰기가 +로 표시되어서 다른 문자열로 바꿔준다.
				encodedFileName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");
			}else if(browser.equals("Chrome")) {
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i < fileName.length(); i++) {
					char c = fileName.charAt(i);
					if(c > '~') {	//'~' 문자는 ASCII문자중 제일 마지막 위치의 문자이다.
						sb.append(URLEncoder.encode("" + c, "utf-8"));
					}else {
						sb.append(c);
					}
				}
				encodedFileName = sb.toString();
			}
			return encodedFileName;
			
		}
}



