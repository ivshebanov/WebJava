<%@ page import="java.util.Calendar" %>
<%@ page import="static java.lang.System.out" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>JSP страница</title>
  </head>
  <body>
  <%--<%!--%>
    <%--out.println("JSP это просто <br/>");--%>
    <%--java.util.Calendar calendar = java.util.Calendar.getInstance();--%>
    <%--int hour = calendar.get(Calendar.HOUR_OF_DAY);--%>
    <%--int min = calendar.get(Calendar.MINUTE);--%>
    <%--if (hour<10)--%>
      <%--out.println("0" + hour);--%>
    <%--else--%>
      <%--out.println(hour);--%>
    <%--out.println(":");--%>
    <%--if (min<10)--%>
      <%--out.println("0" + min);--%>
    <%--else--%>
      <%--out.println(min);--%>
  <%--%>--%>
  <%!
    public void jspInit() {
      System.out.println("init JSP");
    }
  %>
  <%!
    public void jspDestroy() {
      System.out.println("destroy JSP");
    }
  %>
  <%
    out.println("JSP это просто <br/>");
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int min = calendar.get(Calendar.MINUTE);
    if (hour<10)
      out.println("0" + hour);
    else
      out.println(hour);
    out.println(":");
    if (min<10)
      out.println("0" + min);
    else
      out.println(min);
  %>

  <form action="PostPage.jsp" method="post">
    <p>Это отправка данных POST</p>
    <input type="text" name="firstName">
    <input type="text" name="lastName">
    <input type="submit" >
  </form>

  <form action="GetPage.jsp" method="get">
    <p>Это отправка данных GET</p>
    <input type="text" name="firstName">
    <input type="text" name="lastName">
    <input type="submit" >
  </form>

  </body>
</html>
