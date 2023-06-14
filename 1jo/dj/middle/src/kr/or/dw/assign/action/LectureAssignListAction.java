package kr.or.dw.assign.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.assign.service.AssignServiceImpl;
import kr.or.dw.assign.service.IAssignService;
import kr.or.dw.vo.AssignVO;
import kr.or.dw.web.IAction;

public class LectureAssignListAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String lec_code = req.getParameter("lec_code");
		
		IAssignService service = AssignServiceImpl.getInstance();
		List<AssignVO> assignList = null;
		
		assignList = service.getLectureAssignList(lec_code);
		
		req.setAttribute("lec_code", lec_code);
		if(assignList != null) {
			
			req.setAttribute("assignList", assignList);
		}
		req.setAttribute("titleName", "과제 조회");
		return "/staff/score/lectureAssignList.jsp";
	}

}
