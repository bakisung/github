package kr.or.dw.assign.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import kr.or.dw.assign.service.AssignServiceImpl;
import kr.or.dw.assign.service.IAssignService;
import kr.or.dw.vo.AssignVO;
import kr.or.dw.web.IAction;

public class SubmitAssignFileAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AssignVO assignVo = new AssignVO();
		int assign_no = 0;
		
		HttpSession session = req.getSession();
		String stu_id = (String) session.getAttribute("stu_id");
		
		String assignFoldName = "" + stu_id;
		String realPath = "C:/upload/assignFile/" + assignFoldName;
		
		String fileName = "";
		
		File fileUploadDirectory = new File(realPath);
		if(!fileUploadDirectory.exists()) {
			fileUploadDirectory.mkdirs();
		}
		
		MultipartRequest multi = new MultipartRequest(req, realPath, 100*1024*1024, "utf-8");
		fileName = multi.getFilesystemName("assignfile");
		 assign_no = Integer.parseInt(multi.getParameter("assign_no"));
		
		
		System.out.println(fileName);
		System.out.println(assign_no);
		
		assignVo.setAssign_no(assign_no);
		assignVo.setAssign_path(assignFoldName + "/" + fileName);
		assignVo.setStu_id(stu_id);
		
		IAssignService service = AssignServiceImpl.getInstance();
		int cnt = 0;
		
		
		cnt = service.submitAssignFile(assignVo);
		

		Gson gson = new Gson();
		String result = gson.toJson(assignVo);
		PrintWriter out = res.getWriter();
		out.println(result);
		out.flush();
		
		
		return null;
	}

}
