<!--
This JSP page displays to edit the food item with various attributes such as ID, name, expiration date, price, inventory, discount, type, and subscription status.
It provides functionality for retailer to edit items, save or logout.

Key Features:
- Displaying food attribute in a form format.
- Showing user's login information (username and last login time).
- Providing buttons for save.
- Using modals for subscription confirmation and item purchase.

-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Food Form</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      
      align-items: center;
      height: 100vh;
      background-color: #f5f5f5;
    }
    form {
      width: 50%;
      max-width: 600px;
      padding: 20px;
      border: 1px solid #ddd;
      margin: auto;  
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    label {
      display: block;
      margin-bottom: 5px;
    }
    input[type="text"], input[type="number"], input[type="hidden"], input[type="date"], select {
      width: 100%;
      padding: 5px;
      margin-bottom: 10px;
    }
    input[type="submit"] {
      padding: 5px 10px;
      background-color: #4CAF50;
      color: white;
      border: none;
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
<p>${msg}</p>
<form action="EditFoodServlet" method="post">
  <label for="fid">Food ID:</label>
  <input type="text" id="fid" name="fid" value="${food.fid}" disabled>
<input type="hidden" name="fid" value="${food.fid}">
  <label for="fname">Name:</label>
  <input type="text" id="fname" name="fname" value="${food.fname}" disabled>

  <label for="expiration" class="form-inline">Expiration:</label>
  <input type="date" id="expiration" name="expiration" value="${food.expiration}">

  <label for="price">Price:</label>
  <input type="text" id="price" name="price" value="${food.price}">

  <label for="inventory">Inventory:</label>
  <input type="number" id="inventory" name="inventory" value="${food.inventory}">

  <label for="discount" >Discount:</label>
	<select id="discount" name="discount" >
	  	<option value="1" ${food.discount == 1 ? 'selected' : ''}>No discount</option>
	  	<option value="0.95" ${food.discount == 0.95 ? 'selected' : ''}>95%</option>
		<option value="0.9" ${food.discount == 0.9 ? 'selected' : ''}>90%</option>
		<option value="0.85" ${food.discount == 0.85 ? 'selected' : ''}>85%</option>
		<option value="0.8" ${food.discount == 0.8 ? 'selected' : ''}>80%</option>
		<option value="0.75" ${food.discount == 0.75 ? 'selected' : ''}>75%</option>
	  	<option value="0.7" ${food.discount == 0.7 ? 'selected' : ''}>70%</option>
	   
	</select>

  <label for="foodType">Type:</label>
  <input type="text" id="foodType" name="foodType" value="${food.foodType}" disabled>

  <label for="isDonate" style="display:inline">For Donation:</label>
  <input style="margin-bottom: 10px;" type="checkbox" id="isDonate" name="isDonate" value="1" ${food.isDonate == 1 ? 'checked' : ''}>
  <br/>
  <input type="submit" value="save">
  <input type="button" value="Cancel" onclick="history.go(-1);">
</form>
</body>
</html>
