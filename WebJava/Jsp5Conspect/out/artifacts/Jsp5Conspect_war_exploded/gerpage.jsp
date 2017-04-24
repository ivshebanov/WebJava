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
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String chisloStrok = request.getParameter("chisloStrok");
    String chisloStolbcov = request.getParameter("chisloStolbcov");
%>

<table border="1">
    <%
        try {
            out.println(chisloStrok + chisloStolbcov);
            int a = Integer.parseInt(chisloStrok);
            int b = Integer.parseInt(chisloStolbcov);
            for (int j = 0; j < a; j++) {
                out.println("<tr>");
                for (int e = 0; e < b; e++) {
                    out.println("<td>" + (a + b) + "</td>");
                }
                out.println("</tr>");
            }
        }catch (Exception ex){
            out.println("Ошибка");
        }


    %>
</table>
</body>
</html>
