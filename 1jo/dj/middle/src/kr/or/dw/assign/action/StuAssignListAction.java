package kr.or.dw.assign.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.dw.assign.service.AssignServiceImpl;
import kr.or.dw.assign.service.IAssignService;
import kr.or.dw.vo.AssignVO;
import kr.or.dw.web.IAction;

public class StuAssignListAction implements IAction{

	@Override
	public boolean isRedirect() {
		
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String stu_id = (String) session.getAttribute("stu_id");
		
		List<AssignVO> assignList = null;
		IAssignService service = AssignServiceImpl.getInstance();
		
		
		assignList = service.getStuAssignList(stu_id);
		
		for(AssignVO vo : assignList) {
			AssignVO assignVo = new AssignVO();
			assignVo.setAssign_no(vo.getAssign_no());
			assignVo.setStu_id(stu_id);
			int exist = 0;
			exist = service.existAssignFile(assignVo);
			if(exist != 0) {
				assignVo = service.getStuAssignFile(assignVo);
				vo.setAssign_path(assignVo.getAssign_path());
			}
		}
		req.setAttribute("assignList", assignList);
		
		req.setAttribute("titleName", "과제 조회");
		
		return "/student/assign/assignList.jsp";
	}

}
