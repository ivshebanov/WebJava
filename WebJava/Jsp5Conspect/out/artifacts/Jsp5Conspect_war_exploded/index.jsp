<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 01.04.17
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-страница</title>
</head>
<body>

<%--<form action="postpage.jsp" method="post">--%>
<%--<p>Это отправка на другую страницу</p>--%>
<%--<input type="submit" value="Перебросить меня">--%>
<%--</form>--%>

<%--<form action="gerpage.jsp" method="get">--%>
<%--<p>Это отправка данных GET</p>--%>
<%--<input type="text" name="firstName">--%>
<%--<input type="text" name="lastName">--%>
<%--<input type="submit">--%>
<%--</form>--%>

<form action="postpage.jsp" method="post">
    <p> Как вы относитесь к полетам в космос? </p>
    <input type="radio" name="space" value="yes"/>
    Положительно, всегда хотел полететь в космос<br/>
    <input type="radio" name="space" value="indifferent"/>
    Безразлично, никогда не думал об этом серьезно <br/>
    <input type="radio" name="space" value="no"/>
    Отрицательно, меня с детства отталкивают мысли о космосе <br/>
    <input type="submit" value="Сделать выбор">
</form>
<form action="gerpage.jsp" method="get">
    <br/><br/><br/><br/>
    <p>Введите число строк и столбцов</p><br/>
    <input type="text" name="chisloStrok" value="Введите число строк"><br/>
    <input type="text" name="chisloStolbcov" value="Введите число столбцов"><br/>
    <input type="submit" value="Нирисовать тамблицу">
</form>
</body>
</html>
