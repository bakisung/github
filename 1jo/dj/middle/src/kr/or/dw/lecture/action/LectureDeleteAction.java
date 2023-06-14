package kr.or.dw.lecture.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.web.IAction;

public class LectureDeleteAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String lec_code = null;
		lec_code = req.getParameter("lecCode");
		
		ILectureService service = LectureServiceImpl.getInstance();
		
		int result = 0;
		result = service.deleteLecture(lec_code);
		req.setAttribute("titleName", "강의 관리");
		return "/lecture/lectureManaging.do";
	}

}
