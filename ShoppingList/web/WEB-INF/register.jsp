<%-- 
    Document   : register.jsp
    Created on : Jun 25, 2021, 9:04:07 PM
    Author     : toesl
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList">
            <label>Username:</label>
            <input type="text" name="usernameInput" value="${usernameValue}"></input>
            <!-- hidden input used for servlet register logic-->
            <input type="hidden" name="action" value="register"></input>
            <input type="submit" value="Register Name"></input>
        </form>
    </body>
</html>
