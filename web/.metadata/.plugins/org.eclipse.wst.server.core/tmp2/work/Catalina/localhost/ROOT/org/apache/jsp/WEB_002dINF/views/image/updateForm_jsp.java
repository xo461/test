/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.27
 * Generated at: 2019-12-11 06:39:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.image;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class updateForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>이미지 글수정 폼</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/regExUtil.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".attachFile {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function () {\r\n");
      out.write("\t//첨부파일 변경 이벤트 \r\n");
      out.write("\t$(\"#changeImageBtn\").click(function() {\r\n");
      out.write("\t\tif($(this).text()==\"이미지 바꾸기 \")\r\n");
      out.write("\t\t\t$(this).text(\"이미지 바꾸기 취소\");\r\n");
      out.write("\t\telse $(this).text(\"이미지 바꾸기 \");\r\n");
      out.write("\t\t$(\".attachFile\").toggle();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#writeForm\").submit(function () {\r\n");
      out.write("\t\tif(!inputDataCheck(title_RegEx, \"#title\", title_err_msg))\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t// 내용 \r\n");
      out.write("\t\tif(!inputDataCheck(content_RegEx, \"#content\", content_err_msg))\t\r\n");
      out.write("\t\treturn false; \r\n");
      out.write("\t// 작성자 \r\n");
      out.write("\t\tif(!inputDataCheck(writer_RegEx, \"#writer\", writer_err_msg))\t\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>이미지 글수정</h1>\r\n");
      out.write("\t<!--  많은 데이터를 넘길때 form -->\r\n");
      out.write("\t<form action=\"update.do\" method=\"post\" id=\"writeForm\"\r\n");
      out.write("\t\tenctype=\"multipart/form-data\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"page\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.page }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> \r\n");
      out.write("\t\t<input type=\"hidden\" name=\"perPageNum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.perPageNum }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"key\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.key }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> \r\n");
      out.write("\t\t<input type=\"hidden\" name=\"word\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.word }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"deleteFile\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.fileName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t<!--  input, select,textarea : 입력 항목 만들기 : 생략 -->\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"title\">번호(수정불가)</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\tclass=\"form-control\" id=\"no\" name=\"no\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.no }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("\t\t\t\treadonly=\"readonly\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"title\">제목</label>\r\n");
      out.write("\t\t\t<!--         입력한 데이터의 앞뒤 공백 문자 제거 (trim())\r\n");
      out.write("\t\t\t id, class : 화면 컨트롤을 위해서(빠른 선택),name : 넘어가는 데이터이름   -->\r\n");
      out.write("\t\t\t<!--         <input type=\"text\" class=\"form-control\" id=\"title\"  -->\r\n");
      out.write("\t\t\t<!--         \t\tplaceholder=\"제목을 입력하세요\" name=\"title\" -->\r\n");
      out.write("\t\t\t<!--         \t\trequired=\"required\" pattern=\"^.{4,100}$\" -->\r\n");
      out.write("\t\t\t<input type=\"text\" class=\"form-control\" id=\"title\" name=\"title\"\r\n");
      out.write("\t\t\t\ttitle=\"제목은 4~100글자 사이로 입력하셔야 합니다.\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.title }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<img alt=\"\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.fileName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t<hr/>\r\n");
      out.write("\t\t\t<button id=\"changeImageBtn\" type=\"button\">이미지 바꾸기</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"form-group attachFile\">\r\n");
      out.write("\t\t\t<label for=\"fileName\">첨부파일</label> \r\n");
      out.write("\t\t\t<input type=\"file\" class=\"form-control\" id=\"fileName\" name=\"fileName\"> \r\n");
      out.write("\t\t\t현재 파일 :");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.fileName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t<label for=\"content\">내용</label>\r\n");
      out.write("\t\t\t<textarea class=\"form-control\" rows=\"5\" id=\"content\" name=\"content\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${dto.content }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<button>수정</button>\r\n");
      out.write("\t\t<button type=\"reset\">다시입력</button>\r\n");
      out.write("\t\t<button onclick=\"history.back()\">취소</button>\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
