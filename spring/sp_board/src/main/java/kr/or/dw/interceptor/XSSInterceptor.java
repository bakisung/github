package kr.or.dw.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.josephoconnell.html.HTMLInputFilter;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class XSSInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {

		Enumeration<String> crossParamNames = req.getParameterNames();
		
		while (crossParamNames.hasMoreElements()) {
			String paramName = (String) crossParamNames.nextElement();
			String paramValue = req.getParameter(paramName);
			
			System.out.println("paramName : " + paramName + ", paramValue : " + paramValue);
			
			req.setAttribute("XSS" + paramName, HTMLInputFilter.htmlSpecialChars(paramValue));
		}
		
		return true;
	}

	
	
}
