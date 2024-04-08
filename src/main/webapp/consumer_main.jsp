<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Store List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 10px auto;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {background-color: #f5f5f5;}
        .view-button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
        }
        #loginoutdiv{
            width: 80%;
            text-align: right;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div id="loginoutdiv"><a id="loginoutBtn" href="LogoutServlet"><button>log out</button></a>&nbsp; &nbsp; &nbsp;username: ${user.name} &nbsp; &nbsp; &nbsp;
    <p>last login: ${user.lastLogin}</p>
</div>
<table>
    <tr>
        <th>Store ID</th>
        <th>Store Name</th>
        <th>City</th>
        <th>Actions</th>
    </tr>
<c:forEach var="store" items="${stores}">
    <tr>
        <td>${store.storeId}</td>
        <td>${store.storeName}</td>
        <td>${store.city}</td>
        <td>
            <button class="view-button" onclick="window.location.href='FoodListServlet?storeId=${store.storeId}'">View</button>
        </td>
    </tr>
</c:forEach>
</table>

</body>
</html>