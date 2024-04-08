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
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f5f5f5;
    }
    form {
      width: 100%;
      max-width: 400px;
    }
    label {
      display: block;
      margin-bottom: 10px;
    }
    input[type="text"],
    input[type="number"],
    input[type="date"],
    select {
      width: 100%;
      padding: 10px;
      margin-bottom: 20px;
      border: 1px solid #ddd;
    }
    #loginoutdiv{
      width: 80%;
      text-align: right;
      margin-top: 20px;
    }
  </style>
</head>
<body>
<div id="loginoutdiv"><a id="loginoutBtn" href="LogoutServlet"><button>login out</button></a>&nbsp; &nbsp; &nbsp;username: ${user.name} &nbsp; &nbsp; &nbsp;
  <p>last login: ${user.lastLogin}</p>
</div>
<p>${msg}</p>
<form action="FoodAddServlet" method="post">
  <label for="fname">Name:</label>
  <input type="text" id="fname" name="fname" required>

  <label for="expiration">Expiration:</label>
  <input type="date" id="expiration" name="expiration" required>

  <label for="price">Price:</label>
  <input type="number" id="price" name="price" step="0.01" required>

  <label for="inventory">Inventory:</label>
  <input type="number" id="inventory" name="inventory" required>

   <label for="discount" >Discount:</label>
	<select id="discount" name="discount">
	  	<option value="1" ${food.discount == 1 ? 'selected' : ''}>No discount</option>
	  	<option value="0.95" ${food.discount == 0.95 ? 'selected' : ''}>95%</option>
		<option value="0.9" ${food.discount == 0.9 ? 'selected' : ''}>90%</option>
		<option value="0.85" ${food.discount == 0.85 ? 'selected' : ''}>85%</option>
		<option value="0.8" ${food.discount == 0.8 ? 'selected' : ''}>80%</option>
		<option value="0.75" ${food.discount == 0.85 ? 'selected' : ''}>75%</option>
	  	<option value="0.7" ${food.discount == 0.8 ? 'selected' : ''}>70%</option>
	   
	</select>
  <label for="foodType">Food Type:</label>
  <select id="foodType" name="ftid">
    <c:forEach var="type" items="${foodTypeList}">
      <option value="${type.id}">${type.name}</option>
    </c:forEach>
  </select>

  <input type="submit" value="Submit">
</form>
</body>
</html>
