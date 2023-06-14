package kr.or.dw.basic.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IPCheckFilter implements Filter{
	
	private static Map<String, String> ipMap;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 허용 또는 불허되는 IP주소 정보를 구성한다.
		ipMap = new HashMap<>();
		ipMap.put("127.0.0.1", "Y");
		ipMap.put("0:0:0:0:0:0:0:1", "Y");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 0:0:0:0:0:0:0:1 ==> IPv6의 주소
		// IPv4 로 보면 127.0.0.1 이 맞다.
		// 이클립스에서 톰캣 실행시 자동으로 설정된 IP 값을 가져오는데 default 로 IPv6 로 잡혀있기 때문
		String ip = request.getRemoteAddr();	// 접속한 IP주소
		System.out.println(ip.split(";")[0] + ip.split(";")[1]);
		
		if(ip != null && ipMap.containsKey(ip.split(";")[0])) {	// 목록에 IP가 있으면
			if("Y".equals(ipMap.get(ip.split(";")[0]))) {			// 허용되는지 여부 확인
				chain.doFilter(request, response);
			}else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<h2>접근이 거부된 IP입니다.<br>");
				out.println("관리자에게 문의하세요.</h2>");
			}
		}else {	// 목록에 IP가 없으면
			// 무조건 특정한 페이지로 이동시킨다.
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			
			resp.sendRedirect(req.getContextPath() + "/ServletTest02.do");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
