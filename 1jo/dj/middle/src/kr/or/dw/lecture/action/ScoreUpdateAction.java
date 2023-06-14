package kr.or.dw.lecture.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.lecture.service.ILectureService;
import kr.or.dw.lecture.service.LectureServiceImpl;
import kr.or.dw.vo.LectureVO;
import kr.or.dw.web.IAction;

public class ScoreUpdateAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LectureVO lecVo = new LectureVO();
		String lec_code = req.getParameter("lec_code");
		String stu_id = req.getParameter("stu_id");
		String stu_grade = req.getParameter("stu_grade");
		double stu_score = Double.parseDouble(req.getParameter("stu_score"));
		
		lecVo.setStu_id(stu_id);
		lecVo.setStu_grade(stu_grade);
		lecVo.setStu_score(stu_score);
		lecVo.setLec_code(lec_code);
		
		ILectureService service = LectureServiceImpl.getInstance();
		
		int result = 0;
		result = service.updateScore(lecVo);
		
		req.setAttribute("titleName", "수강생 관리");
		return "/lecture/lectureStudentScoreInsert.do?lec_code=" + lec_code;
	}

}
