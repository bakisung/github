/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.59
 * Generated at: 2023-06-14 03:39:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class handlebarsTest_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print( request.getContextPath());
      out.write("/resources/bootstrap/plugins/jquery/jquery.min.js\"></script>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<ul id=\"commentUl\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<!-- \r\n");
      out.write("\t\t1. 템플레이팅할 html을 세팅한다. 이때 데이터 바인딩 시킬 부분은\r\n");
      out.write("\t\t{{ 바인딩시킬 데이터의 프로퍼티명 }} 의 형태로 적는다.\r\n");
      out.write("\t -->\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"template\" id=\"commentTemplate\">\r\n");
      out.write("\t{{#each .}}\r\n");
      out.write("\t\t<li class=\"list_item\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<div class=\"review_area\">\r\n");
      out.write("\t\t\t\t\t<p class=\"review\">{{comment}}</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"\">\r\n");
      out.write("\t\t\t\t\t<div class=\"review_info\">\r\n");
      out.write("\t\t\t\t\t\t<span>{{name}}</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t{{/each}}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t// 데이터 세팅\r\n");
      out.write("\t\tlet list = [];\r\n");
      out.write("\t\r\n");
      out.write("\t\tlet data = {\r\n");
      out.write("\t\t\t\tcomment : '굿',\r\n");
      out.write("\t\t\t\tname : \"초보\"\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlet data2 = {\r\n");
      out.write("\t\t\t\tcomment : '굿2',\r\n");
      out.write("\t\t\t\tname : \"초보2\"\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tlist.push(data);\r\n");
      out.write("\t\tlist.push(data2);\r\n");
      out.write("\t\tconsole.log(list);\r\n");
      out.write("\t\t// 2. html Template을 가져온 후 Handlebars 로 compile 한다.\r\n");
      out.write("\t\tlet commentTemplate = $('#commentTemplate').html();\r\n");
      out.write("\t\tlet commentBindTemplate = Handlebars.compile(commentTemplate);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 3. 컴파일한 템플릿에 데이터를 집어넣는다. 이 때 리턴값은 html 로 나온다.\r\n");
      out.write("\t\tlet resultHtml = '';\r\n");
      out.write("\t\tresultHtml += commentBindTemplate(list);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 4. 리턴받은 html을 target에 html로 세팅한다.\r\n");
      out.write("\t\t$('#commentUl').html(resultHtml);\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
