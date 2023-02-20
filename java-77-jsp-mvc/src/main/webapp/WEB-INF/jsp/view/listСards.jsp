<%@ page session="false" import="java.util.Map" %>
<%
    @SuppressWarnings("unchecked")
    Map<Integer, Card> cardBase = (Map<Integer,
            Card>) request.getAttribute("cardBase");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Support service</title>
</head>
<body>
<h1>Cards</h1>
<a href="<c:url value="/cards">
<c:param name="action" value="create" />
</c:url>">Add card</a><br/><br/>
<%
    if (cardBase.size() == 0) {
%><b>Base is empty.</b><%
} else {
    for (int id : cardBase.keySet()) {
        String idStr = Integer.toString(id);
        Card card = cardBase.get(id);
%>Card #<%= idStr %>:
<a href="<c:url value="/cards">
    <c:param name="action" value="view" /><c:param name="cardId" value="<%= idStr %>" />
</c:url>"><%= card.getTopic() %>
</a>
(client:
<%= card.getClientName() %>)<br/><%
        }
    }
%>
</body>
</html>