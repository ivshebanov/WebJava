<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.03.2017
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/entrance" method="post">
    <label for="email">Введите ваш email:</label><input type="text" name="email" id="email"
                                                        placeholder="Введите ваш email">
    <br>
    <label for="phone">Введите ваш пароль:</label><input type="password" name="phone" id="phone"
                                                         placeholder="Введите ваш пароль">
    <br>
    <label for="entrance1">Вход </label><input type="submit" id="entrance1" value="Вход">
    <br>
    <p1><a href="/checkIn.jsp">Регистрация</a></p1>
</form>
</body>
</html>
