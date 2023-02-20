<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Использование бинов:</h2>

     <!-- (1) Вывод даты через бин, используя класс java.util.Date -->
     <jsp:useBean id="date" class="java.util.Date"/>
     <p>The date/time is <%= date %>

     <!-- (2) Создание бина CardDB и запись значения в поле clientName, scope="page" — область видимости объекта -->
     <jsp:useBean id="cardDB" class="database.CardDB" scope="page">
         <jsp:setProperty name="cardDB" property="clientName" value="Ivanov" />
     </jsp:useBean>

     <!-- (3) Вывод на странице значения поля clientName из CardDB -->
     <p>Client Name:
         <jsp:getProperty name = "cardDB" property = "clientName"/>
     </p>

</body>
</html>
