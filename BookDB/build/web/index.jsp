<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bibliothèque</title>
        <!-- Latest compiled and minified CSS -->

        <style>
            body {
                width: 960px;
                margin: 30px;
            }
        </style>
    </head>
    <body>
        <h1>Liste des livres</h1>
        <br/>
        <c:if test="${books.size() > 0}">
            <table class="table table-bordered table-striped">
                <tr>
                    <th>ISBN</th>
                    <th>Nom du livre</th>
                    <th>Prix</th>
                </tr>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.isbn}</td>
                        <td>${book.getTitle()}</td>
                        <td>${book.getPrice()}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>