<%@ page import="newPackege.HalloWorld" %>
<%@ page import="newPackege.Dog" %><%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 25.03.17
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body bgcolor="#d2691e">
<h1 class="message" id="demo"><%=HalloWorld.getMassage()%>
</h1><br/>
<table border="1" bgcolor="#7fffd4">
    <tr>
        <td><%=Dog.gav()%>
        </td>
        <td><%=Dog.color%>
        </td>
        <td><%=Dog.size%>
        </td>
        <td><%=Dog.weight%>
        </td>
        <td><%=Dog.class.getName()%>
        </td>
    </tr>
    <h1>What Can JavaScript Do?</h1>
    <button onclick="document.getElementById('demo').innerHTML = 'ghvyvhgvgh'">click me!</button>
    <button onclick="document.getElementById('demo').style.display = 'none'">Hide</button>
    <button onclick="document.getElementById('demo').style.display = 'block'">Display</button>

    <%--<script>--%>
    <%--window.alert("Привет");--%>
    <%--</script>--%>

    <%--<script>--%>
    <%--document.write(5 + 6);--%>
    <%--</script>--%>

    <%--<script>--%>
    <%--document.getElementById("demo").innerHTML = 5 + 6;--%>
    <%--</script>--%>

</table>
</body>
</html>
