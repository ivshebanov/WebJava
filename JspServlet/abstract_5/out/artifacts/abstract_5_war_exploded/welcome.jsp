<%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 03.07.17
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ЛК</title>
</head>
<body>
<form action="/qwe" method="post">
    <p>Введите товар для поиска</p>
    <input type="text" name="searchtxt">
    <input type="submit" value="Поиск" >
</form>

<form action="/qwe" method="get">
    <select name="selecttable"><option>Выберите таблицу для просмотра:</option>
        <option value="customers">Customers</option>
        <option value="products">Products</option>
        <option value="employees">Employees</option>
    </select>
    <input type="submit" value="Сделать выбор" >
</form>

<a href="/vod.jsp"><H2>Список пользователей</H2></a>
</body>
</html>
