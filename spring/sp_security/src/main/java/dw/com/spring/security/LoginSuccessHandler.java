package dw.com.spring.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		Map<String, String> loginUser = new HashMap<>();
		loginUser.put("id", authentication.getName());
		
//		ㅡ 로그인한 유저의 정보를 가져온다 ㅡ
//		Object obj = authentication.getPrincipal();
//		System.out.println(obj.toString());
//		System.out.println(authentication.getDetails().toString());
		
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
}
