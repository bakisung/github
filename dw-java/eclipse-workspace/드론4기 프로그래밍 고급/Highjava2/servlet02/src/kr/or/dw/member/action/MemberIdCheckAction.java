package kr.or.dw.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.dw.member.service.IMemberService;
import kr.or.dw.member.service.MemberServiceImpl;
import kr.or.dw.web.IAction;

public class MemberIdCheckAction implements IAction{

	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=utf-8");
		
		String mem_id = req.getParameter("mem_id");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int cnt = service.getMemberCount(mem_id);
		
		Gson gson = new Gson();
		String result = null;
		
		if(cnt == 1) {	// 중복되는 경우
			result = gson.toJson("Fail");
		}else {	// 중복되지 않을 경우
			result = gson.toJson("OK");
		}
		
		PrintWriter out = res.getWriter();
		out.println(result);
		out.flush();
		
		return null;
	}

}
