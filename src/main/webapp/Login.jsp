<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="./style.css">
</head>
<body>
    <div class="container">
        <div class="register-box">
            <% 
            String successMessage = (String) request.getAttribute("successMessage");
            if (successMessage != null) {
        %>
            <div style="color: green; text-align: center;"><%= successMessage %></div>
        <% 
            }
        %>
        <% 
            String message = (String) request.getAttribute("msg");
            if (message != null) {
        %>
            <div style="color: red; text-align: center;"><%= message %></div>
        <% 
            }
        %>
        <h2>Login Here!!</h2>
            <form action="Login" method="post">
                <table>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" placeholder="Name" required></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" placeholder="Password" required></td>
                    </tr>
                    <tr>
                        <td><a href="ForgotSearch.jsp" style="text-decoration:none;">Forgot Password?</a></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center;"><button type="submit">Login</button></td>
                    </tr>
                    <tr>
                        <td>Not a Member?</td>
                        <td><a href="Registration.jsp" style="text-decoration:none;">Create an account</a></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
