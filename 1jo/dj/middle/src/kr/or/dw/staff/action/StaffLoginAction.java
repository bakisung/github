package kr.or.dw.staff.action;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.util.CryptoUtil;
import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.vo.StaffVO;
import kr.or.dw.web.IAction;

public class StaffLoginAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String view = "";
		
		String staff_id = req.getParameter("staff_id");
		String staff_pwd = req.getParameter("staff_pwd");
		IStaffService service = StaffServiceImpl.getInstance();
		
		StaffVO vo = service.staffLogin(staff_id);
		
		String cpass = "";
		try {
			System.out.println("actioin1");
			cpass = CryptoUtil.sha512(staff_pwd);
			System.out.println("actioin2");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		int result = 0;
		if(vo != null && (cpass.equals(vo.getStaff_pwd()) || staff_pwd.equals(vo.getStaff_pwd()))) {
			
			String staff_name = null;
			staff_name = service.getStaffName(staff_id);
			result = 1;
			HttpSession session = req.getSession();
			session.setAttribute("staff_name", staff_name);
			session.setAttribute("staff_id", staff_id);
			session.setAttribute("auth_cd", vo.getAuth_cd());
		}
		System.out.println("actioin3");
		
		req.setAttribute("result", result);
		req.setAttribute("titleName", "로그인");
		return "/staff/staffLoginResult.jsp";
	}

}
