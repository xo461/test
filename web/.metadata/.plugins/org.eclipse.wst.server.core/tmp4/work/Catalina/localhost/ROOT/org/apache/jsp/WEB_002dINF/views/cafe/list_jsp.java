/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.27
 * Generated at: 2020-01-02 09:10:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.cafe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1577923924236L));
    _jspx_dependants.put("/WEB-INF/tags/pageNav.tag", Long.valueOf(1577923916409L));
    _jspx_dependants.put("jar:file:/D:/workspace/web/.metadata/.plugins/org.eclipse.wst.server.core/tmp4/wtpwebapps/cafeatte/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>카페어때</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".dataRow:hover {\r\n");
      out.write("\tbackground: #fff;\r\n");
      out.write("\tcolor: orange;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul {\r\n");
      out.write("\tpadding: 0px 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul li {\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tmargin: 2px 2px;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tletter-spacing: -.5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul li.tag-item {\r\n");
      out.write("\tpadding: 4px 8px;\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("\tbackground-color: #000;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul li.searchTag-item {\r\n");
      out.write("\tpadding: 4px 8px;\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("\tbackground-color: #000;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".tag-item:hover {\r\n");
      out.write("\tbackground-color: orange;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".searchTag-item:hover {\r\n");
      out.write("\tbackground-color: orange;\r\n");
      out.write("\tcolor: #fff;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t$(\".searchTag-item\").click(function(){\r\n");
      out.write("\t\t\t\tvar word = $(this).text();\r\n");
      out.write("\t\t\t\tif(word === \"#전체\"){\r\n");
      out.write("\t\t\t\t\tword = \"\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tlocation=\"list.do?page=1\"\r\n");
      out.write("\t\t\t\t\t+ \"&perPageNum=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.perPageNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t+ \"&word=\"+word;\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\".pagination>li:not('.active')\").click(\r\n");
      out.write("\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\tvar page = $(this).data(\"page\");\r\n");
      out.write("\t\t\t\t\tlocation = \"list.do?page=\" + page\r\n");
      out.write("\t\t\t\t\t+ \"&perPageNum=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.perPageNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\t\t+ \"&word=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.word}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t$(\"li.active\").click(function() {\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t// 한페이지에 나타날 글의 갯수 변경 이벤트 처리\r\n");
      out.write("\t\t$(\"#perPageRow\").on({\r\n");
      out.write("\t\t\t\"change\":function(){\r\n");
      out.write("\t\t\t\tperPageNum = $(\"#perPageRow\").val();\r\n");
      out.write("\t\t\t\tlocation=\"list.do?page=1\"\r\n");
      out.write("\t\t\t\t\t+ \"&perPageNum=\" + perPageNum\r\n");
      out.write("\t\t\t\t\t+ \"&word=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.word}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".dataRow\").click(function() {\r\n");
      out.write("\t\t\tno = $(this).find(\".no\").val();\r\n");
      out.write("\t\t\tlocation = \"view.do?no=\" + no\r\n");
      out.write("\t\t\t+ \"&cnt=1\"\r\n");
      out.write("\t\t\t+ \"&page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t+ \"&perPageNum=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.perPageNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t//el 객체에서 empty -> null || \"\"체크 -> 데이터가 넘어오지 않았다.\r\n");
      out.write("\t\t\t//el 객체에서 문자열 연결을 \"+\"로 사용 불가능 -> \"+=\"으로 사용\r\n");
      out.write("\t\t   ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(!empty pageObject.word)?\r\n				   \" + \\\"&word=\"\r\n				   += pageObject.word +=\"\\\"\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar tagValue = \"\";\r\n");
      out.write("\r\n");
      out.write("\t\tvar str = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${searchTags}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\tif (str !== \"\") {\r\n");
      out.write("\t\t\ttagValue = str.split(',');\r\n");
      out.write("\t\t\tfor (var i = 0; i < tagValue.length; i++) {\r\n");
      out.write("\t\t\t\t$(\"#searchTag-list\")\r\n");
      out.write("\t\t\t\t\t\t.append(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"<li class='searchTag-item'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ tagValue[i]\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"</li>\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<h2>동네카페 리스트</h2>\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<form class=\"form-inline\" action=\"list.do\">\r\n");
      out.write("\t\t<input name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" type=\"hidden\" /> <input\r\n");
      out.write("\t\t\tname=\"perPageNum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.perPageNum }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" type=\"hidden\" />\r\n");
      out.write("\t\t<div class=\"input-group\" style=\"float: right\">\r\n");
      out.write("\t\t\t<span class=\"input-group-addon\">Rows/Page</span> <select\r\n");
      out.write("\t\t\t\tclass=\"form-control\" id=\"perPageRow\">\r\n");
      out.write("\t\t\t\t<option ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(pageObject.perPageNum == 10)?\"selected='selected'\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">10</option>\r\n");
      out.write("\t\t\t\t<option ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(pageObject.perPageNum == 15)?\"selected='selected'\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">15</option>\r\n");
      out.write("\t\t\t\t<option ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(pageObject.perPageNum == 20)?\"selected='selected'\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">20</option>\r\n");
      out.write("\t\t\t\t<option ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${(pageObject.perPageNum == 25)?\"selected='selected'\":\"\" }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(">25</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<div id=\"hTagDiv\">\r\n");
      out.write("\t\t<h3>\r\n");
      out.write("\t\t\t<ul id=\"searchTag-list\"></ul>\r\n");
      out.write("\t\t</h3>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>");
      if (_jspx_meth_tl_005fpageNav_005f0(_jspx_page_context))
        return;
      out.write("</div>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /WEB-INF/views/cafe/list.jsp(117,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${login.grade == 9 }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<div style=\"float: right\">\r\n");
          out.write("\t\t\t<a href=\"writeForm.do\"><button>카페 추가</button></a>\r\n");
          out.write("\t\t</div>\r\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
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
      // /WEB-INF/views/cafe/list.jsp(145,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("dto");
      // /WEB-INF/views/cafe/list.jsp(145,2) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/cafe/list.jsp(145,2) '${list}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${list}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t<div class=\"col-md-2 imgsDiv\"\r\n");
            out.write("\t\t\t\tstyle=\"padding-right: 0px; padding-left: 0px; max-width: 210px\">\r\n");
            out.write("\t\t\t\t<div class=\"img-thumbnail\">\r\n");
            out.write("\t\t\t\t\t<div class=\"dataRow\">\r\n");
            out.write("\t\t\t\t\t\t<img src=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.fileName1 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\" alt=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.fileName1 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"\r\n");
            out.write("\t\t\t\t\t\t\tid=\"ListImage\" class=\"img-responsive\"> <input type=\"hidden\"\r\n");
            out.write("\t\t\t\t\t\t\tclass=\"no\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.no }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\">\r\n");
            out.write("\t\t\t\t\t\t<div class=\"title\">\r\n");
            out.write("\t\t\t\t\t\t\t<font size=\"20px\"><b>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</b></font>\r\n");
            out.write("\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t<div class=\"caption\">\r\n");
            out.write("\t\t\t\t\t\t<div id=\"hTags\" style=\"hteight: 20%\">\r\n");
            out.write("\t\t\t\t\t\t\t<ul id=\"tag-list\">\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
              return true;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t</ul>\r\n");
            out.write("\t\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t\t\t<div class=\"writeDate\" align=\"right\" style=\"color: #bbb\">\r\n");
            out.write("\t\t\t\t\t\t\t");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.writeDate }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</div>\r\n");
            out.write("\t\t\t\t\t</div>\r\n");
            out.write("\t\t\t\t</div>\r\n");
            out.write("\t\t\t</div>\r\n");
            out.write("\t\t");
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

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
      // /WEB-INF/views/cafe/list.jsp(160,8) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("hTags");
      // /WEB-INF/views/cafe/list.jsp(160,8) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/cafe/list.jsp(160,8) '${hTags }'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${hTags }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t\t");
            if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fforEach_005f1, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f1))
              return true;
            out.write("\r\n");
            out.write("\t\t\t\t\t\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f1, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f1)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f1);
      // /WEB-INF/views/cafe/list.jsp(161,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${hTags.no == dto.no }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<li class='tag-item searchTag-item'>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${hTags.hTag }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</li>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_tl_005fpageNav_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tl:pageNav
    org.apache.jsp.tag.web.pageNav_tag _jspx_th_tl_005fpageNav_005f0 = new org.apache.jsp.tag.web.pageNav_tag();
    _jsp_getInstanceManager().newInstance(_jspx_th_tl_005fpageNav_005f0);
    try {
      _jspx_th_tl_005fpageNav_005f0.setJspContext(_jspx_page_context);
      // /WEB-INF/views/cafe/list.jsp(174,6) name = page type = java.lang.Integer reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
      _jspx_th_tl_005fpageNav_005f0.setPage((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.page }", java.lang.Integer.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      // /WEB-INF/views/cafe/list.jsp(174,6) name = startPage type = java.lang.Integer reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
      _jspx_th_tl_005fpageNav_005f0.setStartPage((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.startPage }", java.lang.Integer.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      // /WEB-INF/views/cafe/list.jsp(174,6) name = endPage type = java.lang.Integer reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
      _jspx_th_tl_005fpageNav_005f0.setEndPage((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.endPage }", java.lang.Integer.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      // /WEB-INF/views/cafe/list.jsp(174,6) name = totalPage type = java.lang.Integer reqTime = true required = true fragment = false deferredValue = false expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
      _jspx_th_tl_005fpageNav_005f0.setTotalPage((java.lang.Integer) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageObject.totalPage }", java.lang.Integer.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      _jspx_th_tl_005fpageNav_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_tl_005fpageNav_005f0);
    }
    return false;
  }
}
