<%--
  Created by IntelliJ IDEA.
  User: iliashebanov
  Date: 25.03.17
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <SCRIPT type="text/javascript">
        <!--
        function validate_form() {
            valid = true;
            if (document.contact_form.contact_name.value == "") {
                alert("Пожалуйста заполните поле 'Ваше имя'.");
                valid = false;
            }
            return valid;
        }
        //-->
    </SCRIPT>
</head>
<body>

<input type="text" name="userName" value="">
<input type="password" name="userPassord" value="">


<FORM name="myForm" method="get" action="abc" onsubmit="return validate_form ( );">
    <H1>Пожалуйста введите Ваше имя.</H1>
    <br>Ваше имя: <input type="text" name="fname">
    <input type="submit" name="send" value="Отправить данные">
</FORM>

</body>
</html>
