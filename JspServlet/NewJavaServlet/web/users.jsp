<%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 02.04.17
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table border="1">
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.sex}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.phone}"/></td>
            <td><c:out value="${user.address}"/></td>
        </tr>
    </c:forEach>
    <%--<form action="/addUserServlet" method="post">--%>
        <%--<tr>--%>
            <%--<td><input type="submit"></td>--%>
            <%--<td><input type="text" name="firstName" placeholder="firstName"></td>--%>
            <%--<td><input type="text" name="lastName" placeholder="lastName"></td>--%>
            <%--<td><input type="text" name="sex" placeholder="sex"></td>--%>
            <%--<td><input type="text" name="email" placeholder="email"></td>--%>
            <%--<td><input type="text" name="phone" placeholder="phone"></td>--%>
            <%--<td><input type="text" name="address"placeholder="address"></td>--%>
        <%--</tr>--%>
    <%--</form>--%>
</table>
</body>
</html>
