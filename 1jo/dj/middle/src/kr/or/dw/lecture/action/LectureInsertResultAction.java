package kr.or.dw.lecture.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.web.IAction;

public class LectureInsertResultAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int result = Integer.parseInt(req.getParameter("result"));
		
		req.setAttribute("result", result);
		
		req.setAttribute("titleName", "강의 관리");
		
		return "/staff/lecture/lectureInsertResult.jsp";
	}

}
