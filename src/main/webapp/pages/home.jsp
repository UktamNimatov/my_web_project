<%--
  Created by IntelliJ IDEA.
  User: uktamnimatov
  Date: 5/25/22
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
Hello, ${username}
<form action="controller">
    <input type="hidden" name="command" value="find_all_users">
    <input type="submit" value="Find All Users">
</form>
<form action="controller">
    <input type="hidden" name="command" value="logout">
    <input type="submit" value="logout">
</form>
</body>
</html>
