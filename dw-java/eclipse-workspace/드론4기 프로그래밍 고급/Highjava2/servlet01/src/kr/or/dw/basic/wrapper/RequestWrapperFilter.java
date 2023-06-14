package kr.or.dw.basic.wrapper;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestWrapperFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// RequestWrapper 객체 생성
		// ServletRequest가 HttpServletRequest 보다 조상이라서 형변환을 해야한다.
		RequestWrapperTest reqWrapper = new RequestWrapperTest((HttpServletRequest)(request));
		// 만약 ResponseWrapper 객체도 등록을 하려면 이곳에서 같이 생성한다.
		
		// 필터 체이닝에서 원래의 Request 객체 대신 RequestWrapper 객체를 인수로 넣어준다.
		chain.doFilter(reqWrapper, response);
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	
	
}
