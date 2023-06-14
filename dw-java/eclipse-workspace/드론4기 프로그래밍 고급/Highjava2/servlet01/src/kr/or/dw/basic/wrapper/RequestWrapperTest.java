package kr.or.dw.basic.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/*
	 * Wrapper 	=> 요청(Request)객체나 응답(Response)객체를 포장하는것
	 * 			=> 요청객체나 응답객체의 메서드들을 재정의할 때 사용한다.
	 * 
	 * 요청객체 포장 => HttpServletRequestWrapper 클래스를 상속받아서 작성한다.
	 * 응답객체 포장 => HttpServletResponseWrapper 클래스를 상속받아서 작성한다.
	 * 
	 * - Wrapper 클래스를 작성한 후 이 Wrapper 클래스를 사용하려면 Filter를 사용해서 Wrapper 클래스를 사용
	 */

public class RequestWrapperTest extends HttpServletRequestWrapper {

	public RequestWrapperTest(HttpServletRequest request) {
		super(request);	// 반드시 조상클래스의 생성자에 요청(Request) 객체를 넘겨준다.
	}

	// getRemoteAddr() 메서드 재정의
	@Override
	public String getRemoteAddr() {
		String ip = super.getRemoteAddr();	// 원래의 명령 실행
		if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
			return  ip+ "; 님 환영합니다.";
		}
		return super.getRemoteAddr();
	}
	
	
}
