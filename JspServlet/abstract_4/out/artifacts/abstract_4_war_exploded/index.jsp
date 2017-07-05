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

  <%--<%--%>
    <%--RequestDispatcher rd = request.getRequestDispatcher("/PostPage.jsp");--%>
    <%--rd.forward(request, response);--%>
  <%--%>--%>

  <form action="PostPage.jsp" method="post">
    <p>Выберите любимые направления музыки:</p> <br/>
    <input type="checkbox" name="favoriteMusic" value="Rock"> Rock <br/>
    <input type="checkbox" name="favoriteMusic" value="Jazz">Jazz<br/>
    <input type="checkbox" name="favoriteMusic" value="Pop">Pop<br/>
    <input type="checkbox" name="favoriteMusic" value="Classica">Classica<br/><br/>
    <input type="submit" value="Сделать выбор" >
  </form>

  <table border="1">
    <tr><td>1</td><td>2</td><<td>2</td></tr>
    <tr><td>3</td><td>4</td><td>2</td><</tr>
    <tr><td>3</td><td>4</td></tr>
  </table>
  <br/>

  <table border="1">
    <%
      for(int i = 0; i<6; i++) {
        out.println("<tr ><td>"+i+ "</td ></tr >");
      }
    %>
  </table>

  <br/>
  <table border="1">
    <%
      for(int i = 0; i<6; i++) {
        out.println("<tr ><td >" + i+" </td ><td >" + i+1+"</td ></tr >");
      }
    %>
  </table>
  <br/>

  <table border="1">
    <%
      for(int i = 0; i<6; i++) {
        int a = i;
        int b = i+1;
        out.println("<tr ><td >" + a+" </td ><td >" + b+"</td ></tr >");
      }
    %>
  </table>
  <br/>

  <table border="1">
    <%
      for(int i = 1; i<10; i++) {
        for (int j = 1; j<10; j++){
            int a= i*j;
          out.println("<td>" + a + "</td>");
        }
        out.println("</tr>");
      }
    %>
  </table>

  </body>
</html>
