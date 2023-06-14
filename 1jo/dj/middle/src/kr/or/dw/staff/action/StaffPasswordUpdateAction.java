package kr.or.dw.staff.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.util.CryptoUtil;
import kr.or.dw.vo.StaffVO;
import kr.or.dw.web.IAction;

public class StaffPasswordUpdateAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStaffService service = StaffServiceImpl.getInstance();
		
		
		StaffVO staffVo = new StaffVO();
		
		String staff_pass = (String) req.getParameter("pwd");
		
		String staff_id = null;
		HttpSession session = req.getSession();
		if(session.getAttribute("staff_id") != null) {
			staff_id = (String) session.getAttribute("staff_id");
		}else {
			staff_id = req.getParameter("staff_id");
		}
		
		try {
			staff_pass = CryptoUtil.sha512(staff_pass);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		staffVo.setStaff_pwd(staff_pass);
		staffVo.setStaff_id(staff_id);
		
		int result = service.passwordUpdate(staffVo);

		String referer = req.getHeader("referer");
		
		System.out.println(referer);
		req.setAttribute("titleName", "비밀번호 변경");
		
		if(referer.contains("http://localhost:8080/staff/emailstaffPassUpdateResult.do")) {
			return "/staff/staffLoginForm.do";
		}
		
		if(session.getAttribute("staff_id") == null) {
			return "/";
		}
		return "/staff/staffLoginForm.do";
		
		
		
	}

}
