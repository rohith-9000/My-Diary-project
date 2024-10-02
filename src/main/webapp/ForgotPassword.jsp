<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <div class="register-box">
        <h2>Forgot Password</h2>
        <table>
    <tr>
        <td>User Name</td>
        <td><input type="text" value="<%=request.getAttribute("uname") %>" readonly></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type="text" value="<%=request.getAttribute("password") %>" readonly></td>
    </tr>
</table>

        <p style="text-align: center;">Please login with above details</p>
<button style="display: block; margin: 0 auto;">
    <a href="Login.jsp" style="color: white; text-decoration: none;">Login</a>
</button>



    </div>
</div>
</body>
</html>
