package kr.or.dw.staff.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.dw.staff.service.IStaffService;
import kr.or.dw.staff.service.StaffServiceImpl;
import kr.or.dw.vo.StaffVO;
import kr.or.dw.web.IAction;

public class StaffInfoUpdateAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		StaffVO staffVo = new StaffVO();
		
		BeanUtils bean = new BeanUtils();
		
		try {
			bean.populate(staffVo, req.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		IStaffService service = StaffServiceImpl.getInstance();
		service.staffInfoUpdate(staffVo);
		
		req.setAttribute("titleName", "개인정보");
		
		return "/staff/staffInfo.do";
	}

}
