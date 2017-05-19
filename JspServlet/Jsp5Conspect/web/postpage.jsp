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
    if (znach != null) {
        out.println("ВЫ выбрали: ");
        for (int i = 0; i < znach.length; i++) {
            out.println("<br/>" + znach[i]);
        }
    }
%>
</body>
</html>
