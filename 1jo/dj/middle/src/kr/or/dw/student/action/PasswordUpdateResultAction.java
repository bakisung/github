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

public class PasswordUpdateResultAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStudentService service = StudentServiceImpl.getInstance();
		HttpSession session = req.getSession();
		String stu_id = (String) session.getAttribute("stu_id");
		StudentVO stuVo = service.stuLogin(stu_id);
		
		int result = 0;
		int success = 0;
		
		String stu_passCge = req.getParameter("stu_pwdChange");
		String stu_passChk = req.getParameter("stu_pwdCheck");
		String stu_pass = req.getParameter("stu_pwd");
		String hashedPass = "";
		
		try {
			hashedPass = CryptoUtil.sha512(stu_pass);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		if(hashedPass.equals(stuVo.getStu_pwd()) || stu_pass.equals(stuVo.getStu_pwd())) {
			result = 1;
		}
		if(stu_passCge.equals(stu_passChk)) {
			success = 1;
			session.getAttribute(stu_passCge);
		}
		
		req.setAttribute("passResult", result);
		req.setAttribute("passSuccess", success);
		req.setAttribute("stuPass", stu_passCge);
		
		req.setAttribute("titleName", "비밀번호 변경 결과");
		
		return "/student/mymenu/passwordUpdateResult.jsp";
	}

}
