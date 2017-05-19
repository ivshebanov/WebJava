<%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 08.04.17
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск по таблице продукты</title>
</head>
<body>
<form action="/abc" method="post">
    <select name="selecttable">
        <option>Выберите таблицу для просмотра</option>
        <option value="customers">customers</option>
        <option value="products">products</option>
        <option value="employees">employees</option>
    </select>
    <input type="submit" value="Сделать выбор">
</form>

<form action="/qwe" method="post">
    <p> Введите логин и пароль</p>
    <input type="text" name="userlogin">
    <input type="password" name="userpassword">
    <input type="submit" value="Войти">
</form>

<form action="/sql" method="post">
    <h3> SQL Tool для работы с БД Northwing</h3>
    <p>Введите запрос</p>
    <textarea rows="10" cols="45" type="text" name="sqltext">select * from customers</textarea></br>
    <input type="submit" value="Выполнить запрос">
</form>

</body>
</html>
