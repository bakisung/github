package kr.or.dw.lecture.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.web.IAction;

public class LectureInsertFormAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		if(req.getParameter("lecCode") != null) {
		String lec_code = req.getParameter("lecCode");
		ILectureService service = LectureServiceImpl.getInstance();
		LectureVO lecVo = null;
		lecVo = service.selectLecture(lec_code);
		req.setAttribute("lecVo", lecVo);
		
		}
		
		req.setAttribute("titleName", "강의");
		
		return "/staff/lecture/lectureInsert.jsp";
	}

}
