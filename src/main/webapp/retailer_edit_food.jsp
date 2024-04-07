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
      width: 50%;
      max-width: 600px;
      padding: 20px;
      border: 1px solid #ddd;
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    label {
      display: block;
      margin-bottom: 5px;
    }
    input[type="text"], input[type="number"], input[type="hidden"] {
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
  </style>
</head>
<body>
<p>${msg}</p>
<form action="EditFoodServlet" method="post">
  <label for="fid">FID:</label>
  <input type="hidden" id="fid" name="fid" value="${food.fid}">

  <label for="fname">Name:</label>
  <input type="text" id="fname" name="fname" value="${food.fname}" disabled>

  <label for="expiration">Expiration:</label>
  <input type="date" id="expiration" name="expiration" value="${food.expiration}">

  <label for="price">Price:</label>
  <input type="text" id="price" name="price" value="${food.price}" disabled>

  <label for="inventory">Inventory:</label>
  <input type="number" id="inventory" name="inventory" value="${food.inventory}">

  <label for="discount">Discount:</label>
  <input type="number" id="discount" name="discount" value="${food.discount}">

  <label for="foodType">Type:</label>
  <input type="text" id="foodType" name="foodType" value="${food.foodType}" disabled>

  <label for="isDonate" style="display:inline">doNate:</label>
  <input style="margin-bottom: 10px;" type="checkbox" id="isDonate" name="isDonate" value="1" ${food.isDonate == 1 ? 'checked' : ''}>
  <br/>
  <input type="submit" value="Submit">
</form>
</body>
</html>