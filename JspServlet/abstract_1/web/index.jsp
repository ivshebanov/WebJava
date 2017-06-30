<%@ page import="sample.Dog" %>
<%@ page import="sample.HelloWorld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Илья</title>
</head>
<body>
<h3 class="message"><%=HelloWorld.getMessage()%>
    <br/>
    <table border="1">
        <tr>
            <td><%= Dog.gav()%></td>
            <td><%= Dog.color%></td>
            <td><%= Dog.size%></td>
            <td><%= Dog.weigth%></td>
        </tr>
    </table>
    <a href="test.html">нажать</a>
</h3>
</body>
</html>
