package kr.or.dw.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * - 서블릿 필터
 * 1. 사용목적
 *		- 클라이언트의 요청을 수행하기 전에 가로채 필요한 작업을 수행할 수 있다.
 *		- 클라이언트에 대한 응답 정보를 제공하기 전에 응답 정보에 필요한 작업을 수행할 수 있다.
 * 
 * 2. 사용예
 * 		- 인증 작업용 필터
 * 		- 데이터 압축용 필터
 * 		- 인코딩용 필터
 * 		- 로깅 작업용 필터
 * 		- 이미지 변환 작업용 필터 등등..
 */

// 필터 Class 는 javax.servlet.Filter 인터페이스를 구현해서 작성해야 한다.
// 작성된 필터는 web.xml에 등록해서 작동 시킨다.

public class FilterTest01 implements Filter {

	// 필터 초기화 부분
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("첫번째 Filter - init() 메서드 호출");
	}

	// 실제 처리하는 부분
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// chain.doFilter() 메서드 앞쪽은 요청에 관련된 처리를 구현한다.
		System.out.println("첫번째 Filter - doFilter() 메서드 호출 전");
		
		chain.doFilter(request, response);	// 다음 필터로 체이닝하는 메서드(다른 필터로 제어권을 넘겨주는 명령어)
		
		// chain.doFilter()메서드 뒤쪽은 응답에 관련된 처리를 구현한다.
		System.out.println("첫번째 Filter - chain.doFilter() 메서드 호출 후");
	}

	// 필터 종료시 처리할 부분
	@Override
	public void destroy() {
		System.out.println("첫번째 Filter - destroy() 메서드 호출");
	}

}
