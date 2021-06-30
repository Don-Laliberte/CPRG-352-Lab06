<%-- 
    Document   : shoppingList.jsp
    Created on : Jun 25, 2021, 9:08:15 PM
    Author     : toesl
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <!-- query string/URL Rewriting used for servlet logic for logging out-->
        <p>Hello, ${username} <a href="ShoppingList?action=logout">Logout</a></p>
        <h2>List</h2>
        <form method="post" action=" ">
            <label>Add item:</label>
            <input type="text" name="itemInput">
            <!-- hidden input used for servlet logic for adding items-->
            <input type="hidden" name="action" value="add">
            <input type="Submit" value="Add">
        </form>
        
        <form method="post" action=" ">
            <ul>
                <c:forEach items="${itemList}" var="items">
                    <li><input type="radio" name="itemRadio" value="${items}"><label>${items}</label></li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <!-- hidden input used for servlet deletion logic-->
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
