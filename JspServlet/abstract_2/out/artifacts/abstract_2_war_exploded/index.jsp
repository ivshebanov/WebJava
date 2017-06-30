<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Простой пример вызова сервлета</h1>
  <p>Вызываем первый сервлет <a href="/abc">нажмите здесь</a></p>
  <form action="register" method="post">
    <p>Это отправда кадннах post</p>
    <input type="text" name="firstName">
    <input type="text" name="lastName">
    <input type="submit">
  </form>

  <form action="register" method="get">
    <p>Это отправка данныех GET</p>
    <input type="text" name="firstName">
    <input type="text" name="lastName">
    <input type="submit">
  </form>
  <p>Вызываем второй сервлет <a href="/xyz">нажмите здесь</a></p>
  </body>

  <form action="register" method="get">
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
</html>
