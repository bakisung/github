package kr.or.dw.student.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.student.service.IStudentService;
import kr.or.dw.student.service.StudentServiceImpl;
import kr.or.dw.util.CryptoUtil;
import kr.or.dw.vo.StudentVO;
import kr.or.dw.web.IAction;

public class Email_StudentPasswordUpdateResultAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStudentService service = StudentServiceImpl.getInstance();
	
		String stu_id = req.getParameter("stu_id");

		
		int success = 0;
		
		String stu_passCge = req.getParameter("stu_pwdChange");
		String stu_passChk = req.getParameter("stu_pwdCheck");
		
		if(stu_passCge.equals(stu_passChk)) {
			success = 1;
		}
		
		req.setAttribute("passSuccess", success);
		req.setAttribute("stu_pwd", stu_passCge);
		req.setAttribute("stu_id", stu_id);
		
		req.setAttribute("titleName", "비밀번호 변경 결과");
		
		
		return "/student/emailPassUpdateResult.jsp";
	}

}
