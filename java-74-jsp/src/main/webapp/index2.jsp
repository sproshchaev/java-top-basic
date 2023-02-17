<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Java:</h2>
<%
    for (int i = 0; i < 10; i++) {
        String value = String.valueOf(i);
        out.write(value);
        out.write("<br>");
    }
%>
</body>
</html>