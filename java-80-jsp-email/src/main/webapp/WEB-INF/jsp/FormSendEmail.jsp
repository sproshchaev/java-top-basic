<template:main title="SendEmail">
    <form action=" ServiceEmailServlet" method="post">
        <table border="0" width="40%" align="center">
            <caption><h2>Send E-mail</h2></caption>
            <tr>
                <td width="50%">Address</td>
                <td><input type="text" name="address"
                           size="30"/></td>
            </tr>
            <tr>
                <td>Topic</td>
                <td><input type="text" name="topic"
                           size="30"/></td>
            </tr>
            <tr>
                <td>Text</td>
                <td><textarea rows="5" cols="30"
                              name="text">
</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Send"/>
                </td>
            </tr>
        </table>
    </form>
</template:main>