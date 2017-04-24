<%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 25.03.17
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>$Title$</title>
</head>
<body>
<p>Для вызова сервлета нажмите <a href="/abc">здесь</a></p>

<form action="reg" method="get">
    <p>это отправка данных Get</p>
    <input type="text" name="firstName">
    <input type="text" name="lastName">
    <input type="submit">
</form>

<form action="reg" method="post">
    <p>это отправка данных Post</p>
    <input type="text" name="firstName">
    <input type="text" name="lastName">
    <input type="submit">
</form>

<form action="/reg" method="post">
    <p> Как вы относитесь к полетам в космос? </p>
    <input type="radio" name="space" value="Положительно, всегда хотел полететь в космос"/>
    Положительно, всегда хотел полететь в космос<br/>
    <input type="radio" name="space" value="default"/>
    Безразлично, никогда не думал об этом серьезно <br/>
    <input type="radio" name="space" value="no"/>
    Отрицательно, меня с детства отталкивают мысли о космосе <br/>
    <input type="submit" value="Сделать выбор">
</form>

<form action="reg" method="post">
    <p>Введите логин или пароль</p><br/>
    <input type="text" name="userName"> <br/>
    <input type="password" name="password">
    <input type="submit" value="Войти">
</form>

<form action="reg" method="get">
    <p>Сколько будет 2+2</p><br/>
    <input type="text" name="ansve"> <br/>
    <input type="submit" value="ответить">
</form>

</body>
</html>
