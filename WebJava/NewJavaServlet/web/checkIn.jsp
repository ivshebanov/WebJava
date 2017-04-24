<%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 03.04.17
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form action="/addUserServlet" method="post">
    <label for="firstName">Введите ваше имя:</label><input type="text" name="firstName" id="firstName" placeholder="Введите ваше имя"><br>
    <label for="lastName">Введите вашу фамилию:</label><input type="text" name="lastName" id="lastName" placeholder="Введите вашу фамилию"><br>
    Ваш пол:<input type="radio" value="male" name="sex">Мужской | <input type="radio" value="female" name="sex"> Женский<br>
    <label for="email">Введите ваш email:</label><input type="text" name="email" id="email"
                                                        placeholder="Введите ваш email"><br>
    <label for="phone">Введите ваш телфон:</label><input type="text" name="phone" id="phone"
                                                         placeholder="Введите ваш телефон"><br>
    <label for="address">Введите ваш адресс:</label><input type="text" name="address" id="address"
                                                           placeholder="Введите ваш адрес"> <br>
    <input type="submit">
</form>
</body>
</html>
