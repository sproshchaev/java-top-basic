<%@ page import="com.prosoft.domain.Card" %>
<%@ page session="false" %>
<%
    String cardId = (String) request.
            getAttribute("cardId");
    Card card = (Card) request.getAttribute("card");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Support service</title>
</head>
<message>
    <h1>Card #<%= cardId %>: <%= card.getTopic() %>
    </h1>
    <i>Client Name - <%= card.getClientName() %>
    </i><br/>
    <%= card.getMessage() %><br/>
    <a href="<c:url value="/cards" />">
        Back to other cards</a>
</message>
</html>