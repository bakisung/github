package kr.or.dw.staff.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;

import kr.or.dw.student.service.IStudentService;
import kr.or.dw.student.service.StudentServiceImpl;
import kr.or.dw.vo.StudentVO;
import kr.or.dw.web.IAction;import oracle.sql.ARRAY;

public class StudentDeleteAction implements IAction{

	@Override
	public boolean isRedirect() {
		return true;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("action");
		IStudentService service = StudentServiceImpl.getInstance();
		String[] stu_id = req.getParameterValues("stu_id_arr[]");
		
		if (stu_id != null && stu_id.length > 0) {
	        for (String id : stu_id) {
	            service.studentDelete(id);
	        }
	    }	    	
		req.setAttribute("titleName", "학생 관리");
		return null;
	}
	

}
