<%--
  ~ Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
  ~ Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
  ~ Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
  ~ Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
  ~ Vestibulum commodo. Ut rhoncus gravida arcu.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 01.04.17
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
    <%--request.setCharacterEncoding("UTF-8");--%>
    <%--String firstName = request.getParameter("firstName");--%>
    <%--String lastName = request.getParameter("lastName");--%>
    <%--out.println("Ваше имя: <h1>" + firstName + " " + lastName + "</h1>");--%>
<%--%>--%>

<%--<%--%>
<%--//    response.sendRedirect("http://www.mail.ru/");--%>
    <%--RequestDispatcher re = request.getRequestDispatcher("https:mail.ru");--%>
    <%--re.forward(request, response);--%>
<%--%>--%>

<%
    String[] znach = request.getParameterValues("space");
    if (znach != null){
        out.println("ВЫ выбрали: " );
        for (int i = 0; i < znach.length; i++){
            out.println("<br/>"+znach[i]);
        }
    }
%>
</body>
</html>
