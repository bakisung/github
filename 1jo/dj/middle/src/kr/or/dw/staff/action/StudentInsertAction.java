package kr.or.dw.staff.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.dw.student.service.IStudentService;
import kr.or.dw.student.service.StudentServiceImpl;
import kr.or.dw.vo.StudentVO;
import kr.or.dw.web.IAction;

public class StudentInsertAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StudentVO stuVo = new StudentVO();
		BeanUtils bean = new BeanUtils();
		try {
			bean.populate(stuVo, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IStudentService service = StudentServiceImpl.getInstance();
		List<StudentVO> vo = null;
				
		vo = service.studentInsert(stuVo);
		
		
		req.setAttribute("stuVoList", vo);
		req.setAttribute("titleName", "학생 관리");
		return "/staff/studentCRUD.do";
	}

}
