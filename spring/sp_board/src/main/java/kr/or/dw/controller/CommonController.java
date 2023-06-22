package kr.or.dw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.dw.service.MemberService;
import kr.or.dw.service.MenuService;
import kr.or.dw.vo.MenuVO;

@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping("/common/loginForm")
	public String loginForm(HttpServletResponse res) throws Exception {
		String url = "/common/loginForm";
		
		return url;
	}
	
//	@RequestMapping("/common/login")
//	public String login(String id, String pwd, HttpSession session) throws SQLException{
//		String url = "redirect:/index.do";
//		
//		memberService.login(id, pwd, session);
//		
//		return url;
//	}
	
	@RequestMapping("/security/accessDenied")
	public String accessDenied(HttpServletResponse res) throws Exception{
		String url = "security/accessDenied.open";
		
		res.setStatus(302);
		
		return url;
	}
	
	@RequestMapping("/common/LoginTimeOut")
	public void loginTimeOut(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<script>");
		out.println("alert('세션이 만료되었습니다.\\n다시 로그인하세요!')");
		out.println("location.href='/';");
		out.println("</script>");
		out.close();
	}
	
	@RequestMapping("/common/LoginExpired")
	public void loginExpired(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<script>");
		out.println("alert('중복 로그인이 확인되었습니다.\\n 다시 로그인하면 다른 장치의 로그인은 해제됩니다!')");
		out.println("location.href='/';");
		out.println("</script>");
		out.close();
	}
	
	@RequestMapping("/index")
	public ModelAndView index(@RequestParam(defaultValue="M000000")String mcode, ModelAndView mnv) throws SQLException{
		String url = "/common/indexPage.page";
		
		List<MenuVO> menuList = menuService.selectMainMenuList();
		MenuVO menu = menuService.selectMenuByMcode(mcode);
		
		mnv.addObject("menuList", menuList);
		mnv.addObject("menu", menu);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/main")
	public String main() {
		String url = "/common/main.open";
		return url;
	}
	
	@RequestMapping("/common/handlebarsTest")
	public String handlebarsTest() {
		String url = "/common/handlebarsTest";
		return url;
	}
	
	@RequestMapping("/common/subMenu")
	public ResponseEntity<List<MenuVO>> subMenu(String mcode){
		ResponseEntity<List<MenuVO>> entity = null;
		
		List<MenuVO> subMenu = null;
		try {
			subMenu = menuService.selectSubMenuList(mcode);
			entity = new ResponseEntity<List<MenuVO>>(subMenu, HttpStatus.OK);
		} catch (SQLException e) {
			entity = new ResponseEntity<List<MenuVO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	
}
