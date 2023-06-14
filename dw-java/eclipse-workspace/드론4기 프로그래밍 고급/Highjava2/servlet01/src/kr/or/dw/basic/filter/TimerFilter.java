package kr.or.dw.basic.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TimerFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		long startTime = System.currentTimeMillis();

		chain.doFilter(request, response);
		
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();	// 요청한 URI 출력
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(uri + " => " + (endTime - startTime));
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}



}
