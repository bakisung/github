package kr.or.dw.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.vo.StaffVO;
import kr.or.dw.web.IAction;

public class StaffPasswordUpdateFormAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStaffService service = StaffServiceImpl.getInstance();
		HttpSession session = req.getSession();
		
		StaffVO staffVo = new StaffVO();
				
		String staff_id = (String)session.getAttribute("staff_id");
		
		staffVo = service.getstaffInfo(staff_id);
		
		req.setAttribute("staff_id", staffVo);
		
		req.setAttribute("titleName", "내 정보");
		
		
		return "/staff/mymenu/passwordUpdate.jsp";
	}

}
