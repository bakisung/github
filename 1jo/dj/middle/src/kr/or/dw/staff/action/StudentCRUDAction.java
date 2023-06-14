package kr.or.dw.staff.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.dw.student.service.IStudentService;
import kr.or.dw.student.service.StudentServiceImpl;
import kr.or.dw.util.PaginationUtil;
import kr.or.dw.vo.StudentVO;
import kr.or.dw.web.IAction;

public class StudentCRUDAction implements IAction{

	@Override
	public boolean isRedirect() {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IStudentService service = StudentServiceImpl.getInstance();
		
		
		
		// 페이징 처리
		Map<String, Integer> pagingConfigMap = null;
		PaginationUtil pagination = new PaginationUtil();
		String pageParam = req.getParameter("page");	//사용자가 선택한 페이지번호
		//추가
		
		int page = (pageParam == null ? 1 : Integer.parseInt(pageParam));
		
		int totalCount = service.selectStuCount();
		
		pagination.setConfig(page, 10, 10, totalCount);
		pagingConfigMap = pagination.getConfig();
		
		//ibatis에서 받을 parameterMap을 만든다.
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", pagingConfigMap.get("start"));
		paramMap.put("end", pagingConfigMap.get("end"));
		
		List<StudentVO> stuVoList = service.getAllStudentInfo(paramMap);
		//추가
		req.setAttribute("pagingConfigMap", pagination);
		req.setAttribute("stuVoList", stuVoList);
		
		
		req.setAttribute("titleName", "학생 관리");
		return "/staff/student/studentCRUD.jsp";
	}

}
