<html>
<head>
    <title>Index Page</title>
</head>
<body>
<h2>Hello World!</h2>
<form action="controller">
    <input type="hidden" value="login" name="command">
    Login: <input type="text" name="username" value="">
    <br>
    Password: <input type="password" name="password" value="">
    <br>
    <input type="submit" value="Submit" name="submit">
</form>
<br>
${login_message}
</body>
</html>
