<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <link rel="stylesheet" href="./style.css">
</head>
<body>
<div class="container">
	<div class="register-box">
<%
String s = (String) request.getAttribute("msg");
if (s != null) {
    %><div style="color: red; text-align: center;"><%= s %></div>
<% 
    }
%>

<h2>Forgot Password</h2>
    <form action="ForgotPassword" method="post">
                <table>
                    <tr>
                        <td><label for="phone">Enter Number :</label></td>
                        <td><input type="text" id="phone" name="phone" required placeholder="Enter Phone number"></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center;"><button type="submit">Search</button></td>
                    </tr>
                </table>
    </form>
    </div>
</div>
</body>

</html>
