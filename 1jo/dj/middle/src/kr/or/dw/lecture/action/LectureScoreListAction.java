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

public class LectureScoreListAction implements IAction{

	@Override
	public boolean isRedirect() {
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
		
		req.setAttribute("titleName", "수강생 관리");
		
		return "/staff/score/lectureScoreList.jsp";
	}

}
