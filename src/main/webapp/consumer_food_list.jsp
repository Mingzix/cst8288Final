<!--
This JSP page displays a list of food items with various attributes such as ID, name, expiration date, price, inventory, discount, type, and subscription status.
It provides functionality for users to buy items, subscribe to items, and logout.

Key Features:
- Displaying food list in a table format.
- Showing user's login information (username and last login time).
- Providing buttons for subscribing, unsubscribing, and buying items.
- Using modals for subscription confirmation and item purchase.

-->
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
            display: none; 
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
        #topContainer {
	      display: flex;
	      justify-content: space-between;
	      align-items: center;
	      margin:auto;
	      margin-bottom: 20px;
	       width: 80%;
	    }
    </style>
</head>
<body>
<div id="topContainer">
	<div id="topButtons">
	  <button onclick="history.go(-1);">Go Back</button>
	</div>
	<div id="loginoutdiv"><a id="loginoutBtn" href="LogoutServlet"><button>log out</button></a>&nbsp; &nbsp; &nbsp;username: ${user.name} &nbsp; &nbsp; &nbsp;
	    <p>last login: ${user.lastLogin}</p>
	</div>
</div>
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
        <th>Actions</th>
    </tr>
<c:forEach var="food" items="${foodList}">
<!-- Loop through food items to display in table rows -->
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
        <td>
            <c:choose>
                <c:when test="${food.isExpired == 'no'}">
                    <c:choose>
                        <c:when test="${food.isSubscribe==1}">
                            <button onclick="location.href='RemoveSubscribeServlet?fid=${food.fid}'" >Unsubscribe</button>
                        </c:when>
                        <c:otherwise>
                            <button onclick="showSubscribeModal(${food.fid})">subscription</button>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:when test="${food.isExpired=='yes'}">
                    <button disabled>subscription</button>
                </c:when>
            </c:choose>
            <c:choose>
                <c:when test="${food.inventory == 0}">
                    <button onclick="showModal(${food.fid},${food.inventory},${food.price},${food.discount})" disabled>buy</button>
                </c:when>
                <c:when test="${food.inventory>0}">
                    <button onclick="showModal(${food.fid},${food.inventory},${food.price},${food.discount})">buy</button>
                </c:when>
            </c:choose>
        </td>
    </tr>
</c:forEach>
    <!-- Modals for subscription confirmation and item purchase -->
    <div id="myModal" class="modal">
        <div class="modal-content">
            <span class="close1">&times;</span>
            <input type="number" id="inputField" placeholder="buy num"><br/><br/>
            <button id="confirmBtn">confirm</button>
            <button id="cancelBtn">cancel</button>
        </div>
    </div>
    <div id="myModal2" class="modal">
        <div class="modal-content">
            <span class="close2">&times;</span>
            <span>confirm subscription？</span><br/><br/>
            <button id="confirmBtn2">confirm</button>
            <button id="cancelBtn2">cancel</button>
        </div>
    </div>
    <!-- JavaScript code for modal functionality and event handling -->
    <script>
        let fid1;
        let inventory1;
        let price1;
        let discount1;
        // Function to display the modal for item purchase
        function showModal(fid,inventory,price,discount) {
            fid1=fid;
            inventory1=inventory;
            price1=price;
            discount1=discount;
            console.log(fid1)
            console.log(inventory1)
            document.getElementById('myModal').style.display = "block";
        }
        // Function to display the modal for subscription confirmation
        function showSubscribeModal(fid) {
            fid1=fid;
            document.getElementById('myModal2').style.display = "block";
        }

        var modal = document.getElementById("myModal");
        var modal2 = document.getElementById("myModal2");

        var span = document.getElementsByClassName("close1")[0];
        var span2 = document.getElementsByClassName("close2")[0];

        span.onclick = function() {
            modal.style.display = "none";
        }
        span2.onclick = function() {
            modal2.style.display = "none";
        }
        // Functionality to close modals when clicking outside the modal content
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
            if (event.target == modal2) {
                modal2.style.display = "none";
            }
        }
        // Event listeners for the confirm and cancel buttons in the purchase modal
        document.getElementById('confirmBtn').addEventListener('click', function() {
            var inputValue = document.getElementById('inputField').value;
            if(inputValue>inventory1){
                alert("The quantity exceeds the inventory")
            }else{
                if(inputValue=="" || inputValue==0){
                    alert("not empty")
                    return;
                }
                let money = price1*inputValue*discount1;
                window.location.href="AddOrderServlet?fid="+fid1+"&num="+inputValue+"&money="+money;
                modal.style.display = "none";
            }
        });
        // Event listeners for the confirm and cancel buttons in the subscription confirmation modal
        document.getElementById('confirmBtn2').addEventListener('click', function() {
                window.location.href="AddSubscribeServlet?fid="+fid1;
                modal2.style.display = "none";
        });
        // Event listeners for the cancel buttons in both modals
        document.getElementById('cancelBtn').addEventListener('click', function() {
            modal.style.display = "none";
        });
        document.getElementById('cancelBtn2').addEventListener('click', function() {
            modal2.style.display = "none";
        });
    </script>
</table>
</body>
</html>