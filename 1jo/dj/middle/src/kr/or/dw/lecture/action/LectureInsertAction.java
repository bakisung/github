package kr.or.dw.lecture.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.web.IAction;

public class LectureInsertAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		LectureVO lecVo = new LectureVO();
		
		ILectureService service = LectureServiceImpl.getInstance();
		
		HttpSession session = req.getSession();
		String staff_id = (String) session.getAttribute("staff_id");
		
		
		String lec_name = req.getParameter("lec_name");
		String lec_loc = req.getParameter("lec_loc");
		int lec_year = Integer.parseInt(req.getParameter("lec_year"));
		int lec_term = Integer.parseInt(req.getParameter("lec_term"));
		String lec_day = req.getParameter("lec_day");
		String lec_div = req.getParameter("lec_div");
		int lec_maxpeo = Integer.parseInt(req.getParameter("lec_maxpeo"));
		int lec_credit = Integer.parseInt(req.getParameter("lec_credit"));
		
		String[] lecTimeList = req.getParameterValues("lec_time");
		
		
		String lec_code = null;
		String plan_path = "";
		if(!req.getParameter("lec_code").equals("")) {
			lec_code = req.getParameter("lec_code");
			plan_path = service.getPlanPath(lec_code);
			
			int deleteRes = 0;
			deleteRes = service.deleteLecture(lec_code);
			
		}else {
			lec_code = service.getLecCode();

		}	
		
		int lec_time = 0;
		int result = 0;
		for(String lecTime : lecTimeList) {

			lec_time = Integer.parseInt(lecTime);
			lecVo.setLec_code(lec_code);
			lecVo.setStaff_id(staff_id);
			lecVo.setLec_credit(lec_credit);
			lecVo.setLec_day(lec_day);
			lecVo.setLec_div(lec_div);
			lecVo.setLec_loc(lec_loc);
			lecVo.setLec_maxpeo(lec_maxpeo);
			lecVo.setLec_name(lec_name);
			lecVo.setLec_term(lec_term);
			lecVo.setLec_time(lec_time);
			lecVo.setLec_year(lec_year);
			lecVo.setPlan_path(plan_path);
			
			
			result += service.insertLecture(lecVo);
		}
		
		
		req.setAttribute("titleName", "강의 관리");
		
		return "/lecture/lectureInsertResult.do?result=" + result;
	}

}
