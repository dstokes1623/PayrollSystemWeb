<%-- 
    Document   : login
    Created on : Feb 21, 2022, 9:18:24 AM
    Author     : stoke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payroll Login</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>My Company Login</h1>
        <div style="color:red" type="alert">${errorMessage}</div>
        <form action="login" method="post">
            <label class="pad_top">User ID: </label>
            <input type="text" name="userID" required><br>
            <label class="pad_top">Password:</label>
            <input type="password" name="password" required><br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
