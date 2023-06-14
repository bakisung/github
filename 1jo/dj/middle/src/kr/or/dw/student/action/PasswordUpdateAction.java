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

public class PasswordUpdateAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStudentService service = StudentServiceImpl.getInstance();
		
		
		StudentVO stuVo = new StudentVO();
		
		String stu_pass = (String) req.getParameter("pwd");
		
		String stu_id = null;
		HttpSession session = req.getSession();
		if(session.getAttribute("stu_id") != null) {
			stu_id = (String) session.getAttribute("stu_id");
		}else {
			stu_id = req.getParameter("stu_id");
		}
		
		try {
			stu_pass = CryptoUtil.sha512(stu_pass);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		stuVo.setStu_pwd(stu_pass);
		stuVo.setStu_id(stu_id);
		
		int result = service.passwordUpdate(stuVo);

		String referer = req.getHeader("referer");
		
		System.out.println(referer);
		
		if(referer.contains("http://localhost:8080/student/emailPassUpdateResult.do")) {
			return "/";
		}
		
		if(session.getAttribute("stu_id") == null) {
			return "/";
		}
		
		req.setAttribute("titleName", "비밀번호 변경");
		
		return "/student/studentInfo.do";
	}

}
