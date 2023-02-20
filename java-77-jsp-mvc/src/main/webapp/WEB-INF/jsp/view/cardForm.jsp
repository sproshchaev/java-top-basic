<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Support service</title>
</head>
<message>
    <h1>Add a card</h1>
    <form method="POST" action="cards">
        <input type="hidden" name="action"
               value="create"/>
        Name<br/>
        <input type="text" name="clientName"><br/>
        Topic<br/>
        <input type="text" name="topic"><br/>
        Message<br/>
        <textarea name="message" rows="10"
                  cols="25"></textarea><br/>
        <input type="submit" value="Submit"/>
    </form>
</message>
</html>