package kr.or.dw.lecture.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.vo.EvaluationVO;
import kr.or.dw.web.IAction;

public class EvaluationResultAvgAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String lec_code = req.getParameter("lec_code");
		
		ILectureService service = LectureServiceImpl.getInstance();
		String lec_name = service.getLecName(lec_code);
		EvaluationVO evalAvg = null;
		evalAvg = service.getEvalAvg(lec_code);
		List<String> que9List = null;
		que9List = service.getQue9List(lec_code);
		if(evalAvg != null) {
			
			req.setAttribute("evalAvg", evalAvg);
		}
		if(que9List != null) {
			
			req.setAttribute("que9List", que9List);
		}
		req.setAttribute("lec_name", lec_name);
		req.setAttribute("titleName", "강의평가 결과");
		return "/staff/score/lectureEvaluationResult.jsp";
	}

}
