package kr.or.dw.staff.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.util.SendEmail;
import kr.or.dw.vo.StaffVO;
import kr.or.dw.web.IAction;

public class IdEmailCheckAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String staff_id = req.getParameter("staff_id");
		String staff_email = req.getParameter("staff_email");
		
		StaffVO staffVo = new StaffVO();
		staffVo.setStaff_id(staff_id);
		staffVo.setStaff_email(staff_email);

		int cnt = 0;
		IStaffService service = StaffServiceImpl.getInstance();
		
		cnt = service.idEmailCheck(staffVo);
		String ver_code = null;
		
		if(cnt == 1) {
			SendEmail se = new SendEmail();
			ver_code = se.pwdEmail(staff_email);
			Gson gson = new Gson();
			ver_code = gson.toJson(ver_code);
		}
		
		System.out.println(ver_code);
		PrintWriter out = res.getWriter();
		out.println(ver_code);
		out.flush();
		req.setAttribute("titleName", "계정");
		return null;
	}

}
