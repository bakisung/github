package kr.or.dw.staff.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.vo.DateVO;
import kr.or.dw.web.IAction;

public class DateListAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStaffService service = StaffServiceImpl.getInstance();
		
		List<DateVO> dateList = null;
		dateList = service.getDateList();
		
		req.setAttribute("dateList", dateList);
		req.setAttribute("titleName", "일정관리");
		return "/staff/date/dateList.jsp";
	}

}
