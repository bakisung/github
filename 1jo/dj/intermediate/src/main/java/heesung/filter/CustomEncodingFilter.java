package heesung.filter;

import java.io.IOException;
import java.util.logging.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomEncodingFilter implements javax.servlet.Filter{

	@Override
	public void destroy() {
		System.out.println("필터가 실행됩니다.");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("필터가 종료됩니다.");
	}
	
}
