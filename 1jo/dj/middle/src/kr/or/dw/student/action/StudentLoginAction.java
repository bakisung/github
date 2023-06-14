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
import kr.or.dw.vo.LectureVO;
import kr.or.dw.vo.StudentVO;
import kr.or.dw.web.IAction;

public class StudentLoginAction implements IAction{

	@Override
	public boolean isRedirect() {
	
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String view = "";
		
		String stu_id = req.getParameter("stu_id");
		String stu_pwd = req.getParameter("stu_pwd");
		
		IStudentService service = StudentServiceImpl.getInstance();
		
		StudentVO vo = service.stuLogin(stu_id);
		
		String cpass = "";
		try {
			cpass = CryptoUtil.sha512(stu_pwd);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = 0;
		if(vo != null && (cpass.equals(vo.getStu_pwd()) || stu_pwd.equals(vo.getStu_pwd()))) {
			String stu_name = service.getStudentName(stu_id);
			result = 1;
			HttpSession session = req.getSession();
			session.setAttribute("stu_name", stu_name);
			session.setAttribute("stu_id", stu_id);
			session.setAttribute("auth_cd", vo.getAuth_cd());
		}
		
		req.setAttribute("result", result);
		
		req.setAttribute("titleName", "로그인");

		return "/student/studentLoginResult.jsp";
	}
}