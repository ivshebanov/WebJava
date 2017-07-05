<%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 30.06.17
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
</head>
<body>
<%
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    out.println("Ваше имя: " + firstName + " " + lastName);
%>

<%
    String[] values = request.getParameterValues("favoriteMusic");
    if(values!=null) {
        out.println("Вы выбрали: ");
        for (String value : values) {
            out.println("<br/>" + value);
        }
    }
%>

</body>
</html>
