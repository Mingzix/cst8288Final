<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login and Registration Form</title>
    <style>
        body { font-family: Arial, sans-serif; }

        .tab {
            overflow: hidden;
            border: 1px solid #ccc;
            background-color: #f1f1f1;
        }

        .tab button {
            background-color: inherit;
            float: left;
            border: none;
            outline: none;
            cursor: pointer;
            padding: 14px 16px;
            transition: 0.3s;
            font-size: 17px;
        }

        .tab button:hover {
            background-color: #ddd;
        }

        .tab button.active {
            background-color: #ccc;
        }

        .tabcontent {
            display: none;
            padding: 6px 12px;
            border: 1px solid #ccc;
            border-top: none;
        }

        /* Center the form */
        .tabcontent, .tab {
            width: 50%;
            margin: 0 auto;
            margin-top: 20px;
        }

    </style>
    <script>
        function openForm(evt, formName) {
            var i, tabcontent, tablinks;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }
            tablinks = document.getElementsByClassName("tablinks");
            for (i = 0; i < tablinks.length; i++) {
                tablinks[i].className = tablinks[i].className.replace(" active", "");
            }
            document.getElementById(formName).style.display = "block";
            evt.currentTarget.className += " active";
        }

        // Get the first tab and click it to default to open
        document.addEventListener("DOMContentLoaded", function() {
            document.getElementsByClassName("tablinks")[0].click();
        });

    </script>
</head>
<body>

<div class="tab">
    <button class="tablinks" onclick="openForm(event, 'Login')">Login</button>
    <button class="tablinks" onclick="openForm(event, 'Register')">Register</button>
</div>
    <p class="tab">${msg}</p>

<div id="Login" class="tabcontent">
    <h3>Login</h3>
    <form action="LoginServlet" method="post">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Login">
    </form>
</div>

<div id="Register" class="tabcontent">
    <h3>Register</h3>
    <form action="RegisterServlet" method="post">
        <label for="reg_name">Name:</label><br>
        <input type="text" id="reg_name" name="name"><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email"><br>
        <label for="reg_password">Password:</label><br>
        <input type="password" id="reg_password" name="password"><br>
        <label>User Type:</label><br>
        <input type="radio" id="retailer" name="userType" value="retailer">
        <label for="retailer">Retailer</label><br>
        <input type="radio" id="consumer" name="userType" value="consumer">
        <label for="consumer">Consumer</label><br>
        <input type="radio" id="organization" name="userType" value="organization">
        <label for="organization">Organization</label><br><br>
        <input type="submit" value="Register">
    </form>
</div>

</body>
</html>
