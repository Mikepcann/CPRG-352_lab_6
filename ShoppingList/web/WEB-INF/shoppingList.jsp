
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello ${username}</p> <%-- change this --%>
        <p><a href="ShoppingList?action=logout">Logout</a></p>
        
        <%-- start of the form --%>
        <form action="" method="POST">
            <h2>Add Item</h2>
            <label for="item">Add item</label>
            <input type="text" name="item">
            <input type="submit" name="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
        
        <%-- list of user items --%>
        <form action="" method="POST">
            <ul>
                <c:forEach var="item" items="${shoppingList}">
                    <li>${item}</li>
                </c:forEach>
            </ul>
        </form>
        
    </body>
</html>
