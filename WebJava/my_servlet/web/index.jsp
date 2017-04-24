<%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 25.03.17
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <p><a href="/abc">нажмите тут</a></p>

  <form action="register" method="post">
    <p>Это отправка данных POST</p>
    <p>Введите логин</p>
    <input type="text" name="firstName"><br/>
    <p>Введите пароль</p>
    <input type="password" name="password"><br/>
    <input type="submit">
  </form>

  <form action="register" method="get">
    <p>Это отправка данных GET</p>
    <input type="text" name="firstName">
    <input type="text" name="lastName">
    <input type="submit">
  </form>

  <form action="register" method="post">
    <p>Выберите любимые направления музыки:</p> <br/>
    <input type="checkbox" name="favoriteMusic" value="Rock"> Rock <br/>
    <input type="checkbox" name="favoriteMusic" value="Jazz">Jazz<br/>
    <input type="checkbox" name="favoriteMusic" value="Pop">Pop<br/>
    <input type="checkbox" name="favoriteMusic" value="Classica">Classica<br/><br/>
    <input type="submit" value="Сделать выбор" >
  </form>

  <form action="register" method="post">
    <p>Введите логин и пароль:</p> <br/>
    <input type="text" name="userName" >  <br/>
    <input type="password" name="password"><br/><br/>
    <input type="submit" value="Войти" >
  </form>

  </body>
</html>
