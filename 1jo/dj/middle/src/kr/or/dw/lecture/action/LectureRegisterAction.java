package kr.or.dw.lecture.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.web.IAction;

public class LectureRegisterAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String stu_id = (String)session.getAttribute("stu_id");
		String lec_code = req.getParameter("lec_code");
		
		ILectureService service = LectureServiceImpl.getInstance();
		
		int max_peo = 1;
		int cur_peo = 0;
		
		max_peo = service.getMaxPeo(lec_code);
		cur_peo = service.getCurPeo(lec_code);
		
		if(max_peo <= cur_peo) {
			return "/lecture/registerFail.do";
		}
		
		LectureVO lecVo = new LectureVO();
		lecVo.setLec_code(lec_code);
		lecVo.setStu_id(stu_id);
		
		int result = 0;
		result = service.registerLecture(lecVo);
		
		req.setAttribute("titleName", "강의 관리");
		return "/lecture/lectureRegisterForm.do";
	}

}
