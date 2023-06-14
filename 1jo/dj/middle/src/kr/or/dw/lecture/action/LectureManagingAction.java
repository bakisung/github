package kr.or.dw.lecture.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.web.IAction;

public class LectureManagingAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<LectureVO> lecList = null;
		
		HttpSession session = req.getSession();
		String staff_id = (String) session.getAttribute("staff_id");
		
		ILectureService service = LectureServiceImpl.getInstance();
		
		lecList = service.staffLecList(staff_id);
		
		req.setAttribute("lecList", lecList);
		
		req.setAttribute("titleName", "강의 관리");
		
		return "/staff/lecture/lectureManaging.jsp";
	}

}
