package kr.or.dw.lecture.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StudentVO;
import kr.or.dw.web.IAction;

public class LectureStudentListAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<StudentVO> stuList = null;
		
		String lec_code = req.getParameter("lec_code");
		
		ILectureService service = LectureServiceImpl.getInstance();
		stuList = service.getLectureStudentListForm(lec_code);
		
		req.setAttribute("stuList", stuList);
		req.setAttribute("titleName", "수강생 관리");
		return "/staff/score/lectureStudentList.jsp";
	}

}
