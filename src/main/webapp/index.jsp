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

        #retailerFields{
            margin-top: 10px;
            margin-bottom: 10px;
        }
    </style>
    <!-- https://coderanch.com/t/54978/frameworks/TAB-JSP -->
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
        <input type="radio" id="retailer" name="userType" value="retailer" onclick="showHideFields()">
        <label for="retailer">Retailer</label><br>
        <!-- 初始隐藏city和store name的输入框 -->
        <div id="retailerFields" >
            <label for="city">City:</label><br>
            <input type="text" id="city" name="city"><br>
            <label for="storeName">Store Name:</label><br>
            <input type="text" id="storeName" name="storeName"><br>
        </div>
        <input type="radio" id="consumer" name="userType" value="consumer" onclick="showHideFields()">
        <label for="consumer">Consumer</label><br>
        <input type="radio" id="organization" name="userType" value="organization" onclick="showHideFields()">
        <label for="organization">Organization</label><br><br>



        <input type="submit" value="Register">
    </form>
</div>

<script>
    function showHideFields() {
        debugger
        console.log("showHideFields")
        // 获取所有的单选框
        var radios = document.getElementsByName('userType');
        // 获取需要显示或隐藏的输入框的容器
        var retailerFields = document.getElementById('retailerFields');

        // 遍历所有的单选框
        for (var i = 0; i < radios.length; i++) {
            // 如果选中的是retailer单选框
            if (radios[i].id === 'retailer' && radios[i].checked) {
                // 显示city和store name的输入框
                retailerFields.style.display = 'block';
                break
            } else {
                // 否则隐藏city和store name的输入框
                retailerFields.style.display = 'none';
            }
        }
    }

    // 初始页面加载时，检查哪个单选框被选中，并据此显示或隐藏输入框
    showHideFields();
</script>
<%--<div id="Register" class="tabcontent">
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
</div>--%>

</body>
</html>
