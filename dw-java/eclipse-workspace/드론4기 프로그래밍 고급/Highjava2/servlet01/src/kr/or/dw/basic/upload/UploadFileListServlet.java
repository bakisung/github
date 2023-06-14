package kr.or.dw.basic.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UploadFileListServlet.do")
public class UploadFileListServlet extends HttpServlet{
	private static final String UPLOAD_DIR = "c:/others/uploadFiles";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File file = new File(UPLOAD_DIR);
		
		// 폴더가 없으면 폴더를 만든다.
		if (!file.exists()) {
			file.mkdirs();
		}
		
		// 파일이 저장된 폴더에서 파일 목록을 구해와서 List에 저장한다.
		File[] allFiles = file.listFiles();
		List<UploadDetail> fileList = new ArrayList<>();
		
		for(File f : allFiles) {
			if (!f.isFile()) {
				continue;	// 폴더가 있을 수 있으니까.
			}
			UploadDetail details = new UploadDetail();
			details.setFileName(f.getName()); 	// 파일명 셋팅
			details.setFileSize(f.length() / 1024); 	// 파일 크기를 kb로 세팅
			details.setUploadStatus(""); 	// 업로드 하는게 아니기 때문에 빈값으로 둔다.
			
			fileList.add(details);
		}
		
		req.setAttribute("uploadFileList", fileList);
		
		String view = "/basic/04/fileList.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
}
