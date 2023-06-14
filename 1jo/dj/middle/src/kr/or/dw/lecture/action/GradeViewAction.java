package kr.or.dw.lecture.action;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.vo.DateVO;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.web.IAction;

public class GradeViewAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String stu_id = (String) session.getAttribute("stu_id");
		
		Date d = new Date();
		DateFormat yearFormat = new SimpleDateFormat("yyyy");
		DateFormat monthFormat = new SimpleDateFormat("MM");
		int lec_year = Integer.parseInt(yearFormat.format(d));
		int lec_term = Integer.parseInt(monthFormat.format(d));

		if(lec_term <= 7 && lec_term != 1) {
			lec_term = 1;
		}else {
			lec_term = 2;
			
		}
		IStaffService staffService = StaffServiceImpl.getInstance();
		
		DateVO yearTerm = new DateVO();
		yearTerm.setTerm(lec_term);
		yearTerm.setYear(lec_year);
		DateVO dateVo = staffService.getDate(yearTerm);
		String start = dateVo.getLec_start().split(" ")[0];
		String end = dateVo.getLec_end().split(" ")[0];
		start = start.split("-")[0] + start.split("-")[1] + start.split("-")[2];
		end = end.split("-")[0] + end.split("-")[1] + end.split("-")[2];
		int startDate = Integer.parseInt(start);
		int endDate = Integer.parseInt(end);
		DateFormat fomatter1 = new SimpleDateFormat("yyyyMMdd");
		int date = Integer.parseInt(fomatter1.format(d));
		
		
		ILectureService service = LectureServiceImpl.getInstance();
		int leccnt = 0;
		int evalcnt = 0;
		leccnt = service.getStuLecCnt(stu_id);
		evalcnt = service.getStuEvalCnt(stu_id);
		if(leccnt != evalcnt && date > endDate) {
			return "/student/lecture/gradeFail.jsp";
		}else {
			
		
		
			List<LectureVO> lecList = service.getAllLecture(stu_id);
			
			req.setAttribute("lecList", lecList);
			req.setAttribute("titleName", "성적 조회");
			
			return "/student/lecture/gradeView.jsp";
		}
	}

}
