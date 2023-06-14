package kr.or.dw.staff.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.vo.DateVO;
import kr.or.dw.web.IAction;

public class DateInsertAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DateVO dateVo = new DateVO();
		int year = Integer.parseInt(req.getParameter("year"));
		int term = Integer.parseInt(req.getParameter("term"));
		String lec_start = req.getParameter("lec_start");
		String lec_end = req.getParameter("lec_end");
		String reg_start = req.getParameter("reg_start");
		String reg_end = req.getParameter("reg_end");
		
		dateVo.setLec_end(lec_end);
		dateVo.setLec_start(lec_start);
		dateVo.setReg_end(reg_end);
		dateVo.setReg_start(reg_start);
		dateVo.setYear(year);
		dateVo.setTerm(term);
		
		IStaffService service = StaffServiceImpl.getInstance();
		int result = 0;
		
		int cnt = 0;
		cnt = service.existDate(dateVo);
		if(cnt != 0) {
			result = service.updateDate(dateVo);
		}else {
			result = service.insertDate(dateVo);
			
		}
		
		
		return "/staff/dateList.do";
	}

}
