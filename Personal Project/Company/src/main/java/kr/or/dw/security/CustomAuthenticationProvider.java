package kr.or.dw.security;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import kr.or.dw.dao.MemberDAO;
import kr.or.dw.vo.MemberVO;

public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String login_id = (String) auth.getPrincipal();	// 로그인 시도한 ID를 가져온다.
		String login_password = (String) auth.getCredentials();	// 로그인 시도한 PASSWORD를 가져온다.
		
		MemberVO member = null;
		
		try {
			member = memberDAO.selectMemberId(login_id);
		} catch (SQLException e) {
			throw new AuthenticationServiceException("Internal server error");
		}
		
		if (member != null && login_password.equals(member.getMember_password())) {	// 로그인 성공
			
			if (member.getMember_enabled() == 0) {
				throw new DisabledException("정지된 계정 입니다.");	// throw로 하기 때문에 if문 다음 아래로 더 이상 내려가지 않고 멈춤
			}
			User authUser = new User(member);
			
			// 스프링 시큐리티 내부 클래스로 인증 토큰을 생성한다.
			UsernamePasswordAuthenticationToken result = 
					new UsernamePasswordAuthenticationToken(
							authUser.getUsername(), authUser.getPassword(), authUser.getAuthorities());
			// 전달할 내용을 설정한 후
			result.setDetails(authUser);
			// 리턴. default-target-url로 전송된다.
			return result;
		} else {	// 로그인 실패
			throw new BadCredentialsException("잘못된 아이디 혹은 비밀번호 입니다.");
		}
		
	}

	@Override
	public boolean supports(Class<?> auth) {
		// UsernamePasswordAuthenticationToken 리턴할 때 파라미터와 같은 레퍼런스인지 비교를 하고 리턴을 한다.
		// default-target-url로 전송된다.
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
