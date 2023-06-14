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

public class EvaluationLectureAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String stu_id = (String) session.getAttribute("stu_id");
		String lec_code = req.getParameter("lec_code");
		int que1 = Integer.parseInt(req.getParameter("que1"));
		int que2 = Integer.parseInt(req.getParameter("que2"));
		int que3 = Integer.parseInt(req.getParameter("que3"));
		int que4 = Integer.parseInt(req.getParameter("que4"));
		int que5 = Integer.parseInt(req.getParameter("que5"));
		int que6 = Integer.parseInt(req.getParameter("que6"));
		int que7 = Integer.parseInt(req.getParameter("que7"));
		int que8 = Integer.parseInt(req.getParameter("que8"));
		String que9 = req.getParameter("que9");
		
		EvaluationVO evalVo = new EvaluationVO();
		evalVo.setLec_code(lec_code);
		evalVo.setStu_id(stu_id);
		evalVo.setQue1(que1);
		evalVo.setQue2(que2);
		evalVo.setQue3(que3);
		evalVo.setQue4(que4);
		evalVo.setQue5(que5);
		evalVo.setQue6(que6);
		evalVo.setQue7(que7);
		evalVo.setQue8(que8);
		evalVo.setQue9(que9);
		
		int result = 0;
		
		ILectureService service = LectureServiceImpl.getInstance();
		
		EvaluationVO eval = null;
		eval = service.getEvalResult(evalVo);
		if(eval != null) {
			result = service.updateEval(evalVo);
		}else {
			
			result = service.insertEval(evalVo);
		}
		
		
		return "/lecture/evaluationResult.do";
	}

}
