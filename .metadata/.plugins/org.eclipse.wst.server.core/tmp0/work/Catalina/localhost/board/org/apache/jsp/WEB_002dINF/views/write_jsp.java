/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.52
 * Generated at: 2018-06-15 08:40:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class write_jsp extends org.apache.jasper.runtime.HttpJspBase
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
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=viewport content=\"width=device-width, initial-scale=1, user-scalable=0\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/core.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/core2.css\" media=\"only screen and (min-width:800px)\">\r\n");
      out.write("<title>My Social Network</title>\r\n");
      out.write("<style>\r\n");
      out.write(".form-mtxt {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tpadding: 10px 15px;\r\n");
      out.write("\tline-height: 1.5em;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\tfont-size: 1.1em;\r\n");
      out.write("\tborder: 1px solid #ddd;\r\n");
      out.write("\tborder-radius: 10px;\r\n");
      out.write("\toutline: none;\r\n");
      out.write("}\r\n");
      out.write(".form-txbn {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("}\r\n");
      out.write(".form-txbn .text {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tline-height: 32px;\r\n");
      out.write("}\r\n");
      out.write(".form-txbn .button {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tpadding: 5px 20px;\r\n");
      out.write("\tfont-size: 0.9em;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tcolor: #24C;\r\n");
      out.write("\tborder: 1px solid #24C;\r\n");
      out.write("\tborder-radius: 8px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write(".form-txbn .button2 {\r\n");
      out.write("\tfloat: right;\r\n");
      out.write("    padding: 5px 20px;\r\n");
      out.write("}\r\n");
      out.write(".image-pane {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tmin-height: 150px;\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("\tbox-sizing: border-box;\r\n");
      out.write("\tborder: 1px solid #ddd;\r\n");
      out.write("\tborder-radius: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"page-hdr\"> 글쓰기\r\n");
      out.write("\t\t<div class=\"back\" onclick=\"history.back()\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"section bg-eee phor-16\">\r\n");
      out.write("\t\t<textarea id=\"--desc\" class=\"form-mtxt mtop-20 mbot-20\" rows=5 placeholder=\"나누고자 하는 이야기를 올려보세요.\"></textarea>\r\n");
      out.write("\t\t<div class=\"form-txbn\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t <label class=\"tran_03\">\r\n");
      out.write("         <div class=\"button\" onclick=\"openImage()\">사진추가</div>\r\n");
      out.write("         </label>\r\n");
      out.write("         <div class=\"button2\">\r\n");
      out.write("            <input type=\"file\" name=\"file\" onchange=\"javascript:document.getElementById('file_route1').value=this.value\">\r\n");
      out.write("\t\t\t<input type=\"text\" readonly=\"readonly\" title=\"File Route\" id=\"file_route1\" placeholder=\"파일을 선택해 주세요.\">\r\n");
      out.write("\t     </div>\t\t  \r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"--img-pane\" class=\"image-pane mtop-10 mbot-20\"></div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"section mbot-30\">\r\n");
      out.write("\t\t<div class=\"form-submit\" onclick=\"upload2()\">작성글을 업로드합니다.</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"form-btn mbot-30\">\r\n");
      out.write("\t\t<div class=\"button\" onclick=\"maingo()\">메인으로 돌아가기</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"page-footer\">MYSNS COMPANY 2017</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/jquery-1.12.0.min.js\"></script>\r\n");
      out.write("<script src=\"js/core.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(document).ready(function() {\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : 'sessioncheck', //내가 보내는 서버주소(컨트롤러)\r\n");
      out.write("\t\tdataType : 'text', //내가 서버로 부터 리턴받는 데이터 형태\r\n");
      out.write("\t\ttype : 'POST', \r\n");
      out.write("\t\tdata : null, //내가 서버로 보내는 데이터\r\n");
      out.write("\t\tsuccess: function (data) { \r\n");
      out.write("\t\t\tif (data == \"OK\") {\r\n");
      out.write("                console.log(\"세션값있음\")\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if (data == \"NO\") {\r\n");
      out.write("\t\t\t\talert(\"로그인이 필요합니다.\");\r\n");
      out.write("\t\t\t\tlocation.replace(\"login\");\r\n");
      out.write("\t\t\t}\t\t\t\r\n");
      out.write("\t      }\r\n");
      out.write("   });\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function maingo() {\r\n");
      out.write("\tlocation.replace(\"main\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("var pagectx = {};\r\n");
      out.write("function start(id) {\r\n");
      out.write("\tpagectx.id = id;\r\n");
      out.write("\t\r\n");
      out.write("\tImageUploader.init(\"#--img-pane\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openImage() {\r\n");
      out.write("    var form = $('#FILE_FORM')[0];\r\n");
      out.write("    var formData = new FormData(form);\r\n");
      out.write("    formData.append(\"fileObj\", $(\"#FILE_TAG\")[0].files[0]);\r\n");
      out.write("    formData.append(\"fileObj2\", $(\"#FILE_TAG2\")[0].files[0]);\r\n");
      out.write("\r\n");
      out.write("    $.ajax({\r\n");
      out.write("        url: '',\r\n");
      out.write("                processData: false,\r\n");
      out.write("                contentType: false,\r\n");
      out.write("                data: formData,\r\n");
      out.write("                type: 'POST',\r\n");
      out.write("                success: function(result){\r\n");
      out.write("                    alert(\"업로드 성공!!\");\r\n");
      out.write("                }\r\n");
      out.write("        });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function upload2() {\r\n");
      out.write("\tif (check() == false) return;\r\n");
      out.write("\r\n");
      out.write("\tvar id = \"");
      out.print((String)session.getAttribute("iogincheck"));
      out.write("\"\r\n");
      out.write("\tvar writedate = {\r\n");
      out.write("\t\t\t\"id\":id,\r\n");
      out.write("\t\t\t\"jsonobj\": $(\"#--desc\").val().trim()\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\tconsole.log(writedate);\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl :'writeupdata', //내가 보내는 서버주소(컨트롤러)\r\n");
      out.write("\t\t\tdataType : 'text', //내가 서버로 부터 리턴받는 데이터 형태\r\n");
      out.write("\t\t\ttype : 'POST', \r\n");
      out.write("\t\t\tdata : JSON.stringify(writedate),\r\n");
      out.write("\t\t\tcontentType : 'application/json; charset=UTF-8',//내가 서버로 보내는 데이터\r\n");
      out.write("\t\t\tsuccess: function (data) { \r\n");
      out.write("\t\t\t\tif (data == \"writeOK\") {\r\n");
      out.write("\t\t\t\t\talert(\"글 작성 완료.\");\r\n");
      out.write("\t\t\t\t\tlocation.replace(\"main\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if (data == \"writeNO\") {\r\n");
      out.write("\t\t\t\t\talert(\"로그인이 필요합니다.\");\r\n");
      out.write("\t\t\t\t\tlocation.replace(\"login\");\r\n");
      out.write("\t\t\t\t}\t\t\t\r\n");
      out.write("\t\t      }\r\n");
      out.write("\t   });\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function check() {\r\n");
      out.write("\tvar pass = $(\"#--desc\").val().trim();\r\n");
      out.write("\tif (pass == \"\") {\r\n");
      out.write("\t\talert(\"나누고자 하는 글을 입력해주세요.\");\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>");
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
