<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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

        .modal {
            display: none; /* hide */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 250px;
            position: relative;
            top: 20%;
            transform: translateY(-50%); /* Center vertically */
        }

        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
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
<div id="loginoutdiv"><a id="loginoutBtn" href="LogoutServlet"><button>Log out</button></a></div>
<h1>Food List</h1>
<p>${msg}</p>
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
        <td><button onclick="showModal(${food.fid},${food.inventory})">receive</button></td>
    </tr>
</c:forEach>
    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <input type="number" id="inputField" placeholder="reveive num"><br/><br/>
            <button id="confirmBtn">confirm</button>
            <button id="cancelBtn">cancel</button>
        </div>
    </div>
    <script>
        let fid1;
        let inventory1;
        function showModal(fid,inventory) {
            fid1=fid;
            inventory1=inventory;
            console.log(fid1)
            console.log(inventory1)
            document.getElementById('myModal').style.display = "block";
        }

      
        var modal = document.getElementById("myModal");

        
        var span = document.getElementsByClassName("close")[0];

        
        span.onclick = function() {
            modal.style.display = "none";
        }

        // when user click other place
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }

        // the button
        document.getElementById('confirmBtn').addEventListener('click', function() {
            var inputValue = document.getElementById('inputField').value;
            if(inputValue>inventory1){
                alert("The quantity exceeds the inventory")
            }else{
                if(inputValue=="" || inputValue==0){
                    alert("not empty")
                    return;
                }
                window.location.href="AddOrderServlet?fid="+fid1+"&num="+inputValue;
                modal.style.display = "none";
            }
        });

        // cancell button
        document.getElementById('cancelBtn').addEventListener('click', function() {
            modal.style.display = "none";
        });
    </script>
</table>
</body>
</html>