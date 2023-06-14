package kr.or.dw.lecture.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.vo.EvaluationVO;
import kr.or.dw.web.IAction;

public class EvaluationLectureFormAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String stu_id = (String) session.getAttribute("stu_id");
		
		String lec_code = req.getParameter("lec_code");
		
		ILectureService service = LectureServiceImpl.getInstance();
		String lec_name = service.getLecName(lec_code);
		
		EvaluationVO evalVo = new EvaluationVO();
		evalVo.setLec_code(lec_code);
		evalVo.setStu_id(stu_id);
		EvaluationVO eval = null;
		eval = service.getEvalResult(evalVo);
		
		if(eval != null) {
			req.setAttribute("evalVo", eval);
		}
		req.setAttribute("lec_code", lec_code);
		req.setAttribute("lec_name", lec_name);
		
		
		req.setAttribute("titleName", "강의 평가");
		return "/student/lecture/lectureEvaluation.jsp";
	}

}
