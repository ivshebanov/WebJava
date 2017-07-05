<%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 30.06.17
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get</title>
</head>
<body>
<%
    int firstName = Integer.parseInt(request.getParameter("firstName"))+1;
    int lastName = Integer.parseInt(request.getParameter("lastName"))+1;
    out.println("Колличество строк и столбцов " + firstName + " " + lastName);
%>

<table border="1">
    <%
        for(int i = 1; i<firstName; i++) {
            for (int j = 1; j<lastName; j++){
                int a= i*j;
                out.println("<td>" + a + "</td>");
            }
            out.println("</tr>");
        }
    %>
</table>
<%--<%--%>
    <%--response.sendRedirect("http://www.mail.ru");--%>
<%--%>--%>

</body>
</html>
