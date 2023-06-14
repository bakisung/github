package kr.or.dw.student.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.student.service.IStudentService;
import kr.or.dw.student.service.StudentServiceImpl;
import kr.or.dw.vo.StudentVO;
import kr.or.dw.web.IAction;

public class StudentPasswordUpdateAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStudentService service = StudentServiceImpl.getInstance();
		HttpSession session = req.getSession();
		
		StudentVO stuVo = new StudentVO();
				
		String stu_id = (String)session.getAttribute("stu_id");
		
		stuVo = service.stdentInfo(stu_id);
		
		req.setAttribute("stu_id", stuVo);
		
		req.setAttribute("titleName", "내 정보");
		
		
		return "/student/mymenu/passwordUpdate.jsp";
	}

}
