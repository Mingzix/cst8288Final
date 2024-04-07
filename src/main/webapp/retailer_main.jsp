<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food List</title>
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        table {
            margin: auto; 
            width: 80%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .add-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            margin-top: 20px;
            margin-bottom: 20px;
        }

        #loginoutdiv{
            width: 80%;
            text-align: right;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div id="loginoutdiv"><a id="loginoutBtn" href="LogoutServlet"><button>Log out</button></a></div>
<h1>Food List</h1>
<!-- 添加按钮 -->
<button class="add-button" onclick="window.location.href='FoodTypeListServlet';">Add</button>
<table>
    <tr>
        <th>Food ID</th>
        <th>Food Name</th>
        <th>Expiration</th>
        <th>Price</th>
        <th>Inventory</th>
        <th>Discount</th>
        <th>Type</th>
        <th>isExpired</th>
        <th>isDonate</th>
        <th>Edit</th>
    </tr>
<c:forEach var="food" items="${foodList}">
    <tr>
        <td>${food.fid}</td>
        <td>${food.fname}</td>
        <td>${food.expiration}</td>
        <td>${food.price}</td>
        <td>${food.inventory}</td>
        <td>${food.discount}</td>
        <td>${food.foodType}</td>
        <td>${food.isExpired}</td>
        <td>
            <c:choose>
                <c:when test="${food.isDonate == 1}">
                    yes
                </c:when>
                <c:when test="${food.isDonate == 0}">
                    no
                </c:when>
                <c:otherwise>
                    unknown
                </c:otherwise>
            </c:choose>
        </td>
        <td><a href="GetFoodByIdServlet?fid=${food.fid}"><button>Edit</button></a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>