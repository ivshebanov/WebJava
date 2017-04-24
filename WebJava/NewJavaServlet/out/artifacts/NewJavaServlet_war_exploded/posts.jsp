<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 27.03.2017
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <c:forEach items="${requestScope.posts}" var="post">
        <tr>
            <td>${post.id}</td>
            <td><c:out value="${post.txt}"/></td>
            <td>
                <a href="delete?id=${post.id}">
                    <img src="imeges/delete.png"/>
                </a>
            </td>
        </tr>
    </c:forEach>

    <form action="/add" method="post">
        <tr>
            <td colspan="2">
                <input type="text" name="txt">
            </td>
            <td>
                <input type="submit">
            </td>
        </tr>
    </form>
</table>
</body>
</html>
