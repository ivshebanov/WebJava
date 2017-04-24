<%@ page import="IntPackege.IntClass" %>
<%@ page import="Spample.HelloWorld" %>
<%@ page import="Spample.Dog" %><%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 25.03.17
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заголовок моей преврой страницы</title>
</head>
<body>
<font color="red">
    <h1><%=HelloWorld.getMessage()%>
    </h1>
</font>
<marquee>
    <h<%=IntClass.getIntMetod()%>>121231</h<%=IntClass.getIntMetod()%>>
</marquee>
<p>текст</p>
<p><%=Dog.gav()%>
</p>
<table border="1">
    <tr>
        <td><%=Dog.gav()%>
        </td>
        <td><%=Dog.color%>
        </td>
        <td><%=Dog.size%>
        </td>
        <td><%=Dog.weight%>
        </td>
    </tr>
</table>
<img src="/imeges/images.jpeg" alt="" height="170">
</body>
</html>