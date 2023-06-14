package kr.or.dw.assign.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.assign.service.AssignServiceImpl;
import kr.or.dw.assign.service.IAssignService;
import kr.or.dw.vo.AssignVO;
import kr.or.dw.web.IAction;

public class UpdateAssignAction implements IAction{

	@Override
	public boolean isRedirect() {

		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int assign_no = Integer.parseInt(req.getParameter("assign_no"));
		String lec_code = req.getParameter("lec_code");
		String assign_name = req.getParameter("assign_name");
		String assign_content = req.getParameter("assign_content");
		
		String start = req.getParameter("assign_start");
		String end = req.getParameter("assign_end");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date assign_start = null;
		Date assign_end = null;
		try {
			assign_start = format.parse(start);
			assign_end = format.parse(end);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AssignVO assignVo = new AssignVO();
		assignVo.setAssign_content(assign_content);
		assignVo.setAssign_end(assign_end);
		assignVo.setAssign_name(assign_name);
		assignVo.setAssign_start(assign_start);
		assignVo.setLec_code(lec_code);
		assignVo.setAssign_no(assign_no);
		
		IAssignService service = AssignServiceImpl.getInstance();
		int result = 0;
		result = service.updateAssign(assignVo);

		req.setAttribute("titleName", "과제 조회");
		
		return "/assign/viewAssign.do?assign_no=" + assign_no;
	}

}
