package kr.or.dw.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTest02 implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("두번째 Filter - init() 메서드 호출");
		
		// 초기화 파라미터 정보 가져오기
		String paramValue1 = filterConfig.getInitParameter("param1");
		System.out.println(paramValue1);

		String paramValue2 = filterConfig.getInitParameter("param2");
		System.out.println(paramValue2);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("두번째 Filter - init() 메서드 호출");
	}
	
}
