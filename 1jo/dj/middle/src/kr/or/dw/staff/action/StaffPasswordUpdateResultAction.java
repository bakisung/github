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

public class StaffPasswordUpdateResultAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStaffService service = StaffServiceImpl.getInstance();
		HttpSession session = req.getSession();
		String staff_id = (String) session.getAttribute("staff_id");
		StaffVO staffVo = service.staffLogin(staff_id);
		
		int result = 0;
		int success = 0;
		
		String staff_passCge = req.getParameter("staff_pwdChange");
		String staff_passChk = req.getParameter("staff_pwdCheck");
		String staff_pass = req.getParameter("staff_pwd");
		String hashedPass = "";
		
		try {
			hashedPass = CryptoUtil.sha512(staff_pass);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		if(hashedPass.equals(staffVo.getStaff_pwd()) || staff_pass.equals(staffVo.getStaff_pwd())) {
			result = 1;
		}
		if(staff_passCge.equals(staff_passChk)) {
			success = 1;
			session.getAttribute(staff_passCge);
		}
		
		req.setAttribute("passResult", result);
		req.setAttribute("passSuccess", success);
		req.setAttribute("staffPass", staff_passCge);
		
		req.setAttribute("titleName", "비밀번호 변경 결과");
		
		return "/staff/mymenu/passwordUpdateResult.jsp";
	}

}
