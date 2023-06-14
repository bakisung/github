package kr.or.dw.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.vo.DateVO;
import kr.or.dw.web.IAction;

public class DateInsertFormAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("titleName", "일정관리");
		IStaffService service = StaffServiceImpl.getInstance();
		
		if(req.getParameter("year") != null) {
			DateVO yearTerm = new DateVO();
			yearTerm.setTerm(Integer.parseInt(req.getParameter("term")));
			yearTerm.setYear(Integer.parseInt(req.getParameter("year")));
			
			DateVO dateVo = null;
			dateVo = service.getDate(yearTerm);
			req.setAttribute("dateVo", dateVo);
		}
		
		return "/staff/date/dateInsertForm.jsp";
	}

}
