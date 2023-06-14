package kr.or.dw.lecture.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.web.IAction;

public class LecturePlanAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LectureVO lecVo = new LectureVO();
		String lec_code = "";
		
		HttpSession session = req.getSession();
		String staff_id = (String) session.getAttribute("staff_id");
		
		String planFoldName = "" + staff_id;
		String realPath = "C:/upload/planFile/" + planFoldName;
		
		String fileName = "";
		
		File fileUploadDirectory = new File(realPath);
		if(!fileUploadDirectory.exists()) {
			fileUploadDirectory.mkdirs();
		}
		
		MultipartRequest multi = new MultipartRequest(req, realPath, 100*1024*1024, "utf-8");
		fileName = multi.getFilesystemName("lec_plan");
		lec_code = multi.getParameter("lec_code");
		
		
		System.out.println(fileName);
		System.out.println(lec_code);
		
		lecVo.setLec_code(lec_code);
		lecVo.setPlan_path(planFoldName + "/" + fileName);
		
		ILectureService service = LectureServiceImpl.getInstance();
		int cnt = 0;
		cnt = service.updatePlanFile(lecVo);
		

		Gson gson = new Gson();
		String result = gson.toJson(lecVo);
		PrintWriter out = res.getWriter();
		out.println(result);
		out.flush();
		
		req.setAttribute("titleName", "강의 관리");
		
		return null;
	}

}
