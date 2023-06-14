package kr.or.dw.assign.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.web.IAction;

public class SubAssignDownloadAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String assign_path = req.getParameter("assign_path");
		String assignName = assign_path.split("/")[1].trim();
		
		String realPath = "C:/upload/assignFile/" + assign_path;
		
		File file = new File(realPath);
		
		if(file.exists()) {
			FileInputStream fin = null;
			OutputStream out = null;
			try {
				
				//ContentType설정
				res.setContentType("aplication/octet-stream; charset=utf-8");
				
				String encodedFileName = getFileNameEncoding(assignName, getBrowser(req));
				
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
