/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.90
 * Generated at: 2023-06-16 14:48:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1686752739462L));
    _jspx_dependants.put("jar:file:/C:/github/spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/sp_board/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--\r\n");
      out.write("This is a starter template page. Use this page to start your new project from\r\n");
      out.write("scratch. This page gets rid of all links and provides the needed markup only.\r\n");
      out.write("-->\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <title>AdminLTE 3 | Starter</title>\r\n");
      out.write("\r\n");
      out.write("  <!-- Google Font: Source Sans Pro -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback\">\r\n");
      out.write("  <!-- Font Awesome Icons -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/resources/bootstrap/plugins/fontawesome-free/css/all.min.css\">\r\n");
      out.write("  <!-- Theme style -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/resources/bootstrap/dist/css/adminlte.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"hold-transition sidebar-mini\">\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Navbar -->\r\n");
      out.write("  <nav class=\"main-header navbar navbar-expand navbar-white navbar-light\">\r\n");
      out.write("    <!-- Left navbar links -->\r\n");
      out.write("    <ul class=\"navbar-nav\">\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" data-widget=\"pushmenu\" href=\"#\" role=\"button\"><i class=\"fas fa-bars\"></i></a>\r\n");
      out.write("      </li>\r\n");
      out.write("      ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    </ul>\r\n");
      out.write("\r\n");
      out.write("    <!-- Right navbar links -->\r\n");
      out.write("    <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("      <!-- Navbar Search -->\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" data-widget=\"navbar-search\" href=\"#\" role=\"button\">\r\n");
      out.write("          <i class=\"fas fa-search\"></i>\r\n");
      out.write("        </a>\r\n");
      out.write("        <div class=\"navbar-search-block\">\r\n");
      out.write("          <form class=\"form-inline\">\r\n");
      out.write("            <div class=\"input-group input-group-sm\">\r\n");
      out.write("              <input class=\"form-control form-control-navbar\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\r\n");
      out.write("              <div class=\"input-group-append\">\r\n");
      out.write("                <button class=\"btn btn-navbar\" type=\"submit\">\r\n");
      out.write("                  <i class=\"fas fa-search\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("                <button class=\"btn btn-navbar\" type=\"button\" data-widget=\"navbar-search\">\r\n");
      out.write("                  <i class=\"fas fa-times\"></i>\r\n");
      out.write("                </button>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("      </li>\r\n");
      out.write("\r\n");
      out.write("      <!-- Messages Dropdown Menu -->\r\n");
      out.write("      <li class=\"nav-item dropdown\">\r\n");
      out.write("        <a class=\"nav-link\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("          <i class=\"far fa-comments\"></i>\r\n");
      out.write("          <span class=\"badge badge-danger navbar-badge\">3</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <div class=\"dropdown-menu dropdown-menu-lg dropdown-menu-right\">\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("            <!-- Message Start -->\r\n");
      out.write("            <div class=\"media\">\r\n");
      out.write("              <img src=\"");
      out.print( request.getContextPath());
      out.write("/resources/bootstrap/dist/img/user1-128x128.jpg\" alt=\"User Avatar\" class=\"img-size-50 mr-3 img-circle\">\r\n");
      out.write("              <div class=\"media-body\">\r\n");
      out.write("                <h3 class=\"dropdown-item-title\">\r\n");
      out.write("                  Brad Diesel\r\n");
      out.write("                  <span class=\"float-right text-sm text-danger\"><i class=\"fas fa-star\"></i></span>\r\n");
      out.write("                </h3>\r\n");
      out.write("                <p class=\"text-sm\">Call me whenever you can...</p>\r\n");
      out.write("                <p class=\"text-sm text-muted\"><i class=\"far fa-clock mr-1\"></i> 4 Hours Ago</p>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Message End -->\r\n");
      out.write("          </a>\r\n");
      out.write("          <div class=\"dropdown-divider\"></div>\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("            <!-- Message Start -->\r\n");
      out.write("            <div class=\"media\">\r\n");
      out.write("              <img src=\"");
      out.print( request.getContextPath());
      out.write("/resources/bootstrap/dist/img/user8-128x128.jpg\" alt=\"User Avatar\" class=\"img-size-50 img-circle mr-3\">\r\n");
      out.write("              <div class=\"media-body\">\r\n");
      out.write("                <h3 class=\"dropdown-item-title\">\r\n");
      out.write("                  John Pierce\r\n");
      out.write("                  <span class=\"float-right text-sm text-muted\"><i class=\"fas fa-star\"></i></span>\r\n");
      out.write("                </h3>\r\n");
      out.write("                <p class=\"text-sm\">I got your message bro</p>\r\n");
      out.write("                <p class=\"text-sm text-muted\"><i class=\"far fa-clock mr-1\"></i> 4 Hours Ago</p>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Message End -->\r\n");
      out.write("          </a>\r\n");
      out.write("          <div class=\"dropdown-divider\"></div>\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("            <!-- Message Start -->\r\n");
      out.write("            <div class=\"media\">\r\n");
      out.write("              <img src=\"");
      out.print( request.getContextPath());
      out.write("/resources/bootstrap/dist/img/user3-128x128.jpg\" alt=\"User Avatar\" class=\"img-size-50 img-circle mr-3\">\r\n");
      out.write("              <div class=\"media-body\">\r\n");
      out.write("                <h3 class=\"dropdown-item-title\">\r\n");
      out.write("                  Nora Silvester\r\n");
      out.write("                  <span class=\"float-right text-sm text-warning\"><i class=\"fas fa-star\"></i></span>\r\n");
      out.write("                </h3>\r\n");
      out.write("                <p class=\"text-sm\">The subject goes here</p>\r\n");
      out.write("                <p class=\"text-sm text-muted\"><i class=\"far fa-clock mr-1\"></i> 4 Hours Ago</p>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Message End -->\r\n");
      out.write("          </a>\r\n");
      out.write("          <div class=\"dropdown-divider\"></div>\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-item dropdown-footer\">See All Messages</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </li>\r\n");
      out.write("      <!-- Notifications Dropdown Menu -->\r\n");
      out.write("      <li class=\"nav-item dropdown\">\r\n");
      out.write("        <a class=\"nav-link\" data-toggle=\"dropdown\" href=\"#\">\r\n");
      out.write("          <i class=\"far fa-bell\"></i>\r\n");
      out.write("          <span class=\"badge badge-warning navbar-badge\">15</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <div class=\"dropdown-menu dropdown-menu-lg dropdown-menu-right\">\r\n");
      out.write("          <span class=\"dropdown-header\">15 Notifications</span>\r\n");
      out.write("          <div class=\"dropdown-divider\"></div>\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("            <i class=\"fas fa-envelope mr-2\"></i> 4 new messages\r\n");
      out.write("            <span class=\"float-right text-muted text-sm\">3 mins</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <div class=\"dropdown-divider\"></div>\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("            <i class=\"fas fa-users mr-2\"></i> 8 friend requests\r\n");
      out.write("            <span class=\"float-right text-muted text-sm\">12 hours</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <div class=\"dropdown-divider\"></div>\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-item\">\r\n");
      out.write("            <i class=\"fas fa-file mr-2\"></i> 3 new reports\r\n");
      out.write("            <span class=\"float-right text-muted text-sm\">2 days</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <div class=\"dropdown-divider\"></div>\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-item dropdown-footer\">See All Notifications</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" data-widget=\"fullscreen\" href=\"#\" role=\"button\">\r\n");
      out.write("          <i class=\"fas fa-expand-arrows-alt\"></i>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li>\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link\" data-widget=\"control-sidebar\" data-slide=\"true\" href=\"#\" role=\"button\">\r\n");
      out.write("          <i class=\"fas fa-th-large\"></i>\r\n");
      out.write("        </a>\r\n");
      out.write("      </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </nav>\r\n");
      out.write("  <!-- /.navbar -->\r\n");
      out.write("\r\n");
      out.write("  <!-- Main Sidebar Container -->\r\n");
      out.write("  <aside class=\"main-sidebar sidebar-dark-primary elevation-4\">\r\n");
      out.write("    <!-- Brand Logo -->\r\n");
      out.write("    <a href=\"index3.html\" class=\"brand-link\">\r\n");
      out.write("      <img src=\"");
      out.print( request.getContextPath());
      out.write("/resources/bootstrap/dist/img/AdminLTELogo.png\" alt=\"AdminLTE Logo\" class=\"brand-image img-circle elevation-3\" style=\"opacity: .8\">\r\n");
      out.write("      <span class=\"brand-text font-weight-light\">AdminLTE 3</span>\r\n");
      out.write("    </a>\r\n");
      out.write("\r\n");
      out.write("    <!-- Sidebar -->\r\n");
      out.write("    <div class=\"sidebar\">\r\n");
      out.write("      <!-- Sidebar user panel (optional) -->\r\n");
      out.write("      <div class=\"user-panel mt-3 pb-3 mb-3 d-flex\">\r\n");
      out.write("        <div class=\"image\">\r\n");
      out.write("          <img src=\"");
      out.print( request.getContextPath());
      out.write("/resources/bootstrap/dist/img/user2-160x160.jpg\" class=\"img-circle elevation-2\" alt=\"User Image\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"info\">\r\n");
      out.write("          <a href=\"#\" class=\"d-block\">Alexander Pierce</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <!-- Sidebar Menu -->\r\n");
      out.write("      <nav class=\"mt-2\">\r\n");
      out.write("        <ul class=\"nav nav-pills nav-sidebar flex-column subMenuList\" data-widget=\"treeview\" role=\"menu\" data-accordion=\"false\">\r\n");
      out.write("          <!-- Add icons to the links using the .nav-icon class\r\n");
      out.write("               with font-awesome or any other icon font library -->\r\n");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("      </nav>\r\n");
      out.write("      <!-- /.sidebar-menu -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.sidebar -->\r\n");
      out.write("  </aside>");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/include/header.jsp(31,6) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/include/header.jsp(31,6) '${menuList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${menuList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/views/include/header.jsp(31,6) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("menu");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("      	<li class=\"nav-item\">\r\n");
            out.write("      		<a href=\"javascript:subMenu('");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${menu.mcode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("'); goPage('");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${menu.murl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("', '");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${menu.mcode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("');\" class=\"nav-link\">");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${menu.mname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</a>\r\n");
            out.write("      	</li>\r\n");
            out.write("      ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
