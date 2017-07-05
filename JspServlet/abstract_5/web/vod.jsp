<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Title</title>
</head>
<body>

<BR><H2>SQL Tool</H2>
<BR>Введите запрос<BR>
<p>SELECT * FROM clientinfo;</p>
<BR>
<FORM action="/sdf" METHOD="post">
    <TEXTAREA NAME=sql COLS=80 ROWS=8 >
    </TEXTAREA>
    <BR>
    <INPUT TYPE=SUBMIT VALUE="Выполнить запрос">
</FORM>
<BR>
<BR>
<HR>
<BR>
</body>
</html>
