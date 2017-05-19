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
            out.println(chisloStrok + ", " + chisloStolbcov);
            int a = Integer.parseInt(chisloStrok);
            int b = Integer.parseInt(chisloStolbcov);
            for (int j = 0; j < a; j++) {
                out.println("<tr>");
                for (int e = 0; e < b; e++) {
                    out.println("<td>" + (a + b) + "</td>");
                }
                out.println("</tr>");
            }
        } catch (Exception ex) {
            out.println("Ошибка");
        }
    %>
</table>
</body>
</html>
