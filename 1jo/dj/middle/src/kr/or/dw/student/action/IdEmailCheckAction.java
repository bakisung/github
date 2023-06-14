package kr.or.dw.student.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.dw.student.service.IStudentService;
import kr.or.dw.student.service.StudentServiceImpl;
import kr.or.dw.util.SendEmail;
import kr.or.dw.vo.StudentVO;
import kr.or.dw.web.IAction;

public class IdEmailCheckAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String stu_id = req.getParameter("stu_id");
		String stu_email = req.getParameter("stu_email");
		
		StudentVO stuVo = new StudentVO();
		stuVo.setStu_id(stu_id);
		stuVo.setStu_email(stu_email);

		int cnt = 0;
		IStudentService service = StudentServiceImpl.getInstance();
		
		cnt = service.idEmailCheck(stuVo);
		String ver_code = null;
		
		if(cnt == 1) {
			SendEmail se = new SendEmail();
			ver_code = se.pwdEmail(stu_email);
			Gson gson = new Gson();
			ver_code = gson.toJson(ver_code);
		}
		
		
		PrintWriter out = res.getWriter();
		out.println(ver_code);
		out.flush();
		
		req.setAttribute("titleName", "이메일 확인");
		
		return null;
	}

}
