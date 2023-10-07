package kr.or.dw.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import kr.or.dw.vo.MemberVO;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		// 위의 authentication은 AuthenticationProvider에서 넘어온 Token이다.
		
		User user = (User) authentication.getDetails();
		
		MemberVO member = user.getMemberVO();
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", member);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
}
