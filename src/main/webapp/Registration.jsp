<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="./style.css">
    <script type="text/javascript">
        function phvalidate() {
            var divref = document.getElementById("ph");
            var phnoref = document.getElementById("phone");
            if(phnoref.value.length !== 10) {
                divref.textContent = "Please enter 10 digit mobile number";
                divref.style.color = "red";
                phnoref.focus();
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <div class="register-box">
            <h2>Register Here!!</h2>
            <form action="Registration" method="post">
                <table>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" placeholder="First Name" required></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lname" placeholder="Last Name" required></td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" placeholder="Username" required></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" placeholder="Password" required></td>
                    </tr>
                    <tr>
                        <td>Email Id</td>
                        <td><input type="email" name="email" placeholder="Email" required></td>
                        <td>
                            <% 
                                String val1 = (String) request.getAttribute("msg1");
                                if (val1 != null) {
                                    out.print(val1);
                                }
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><input type="tel" name="phone" id="phone" placeholder="Phone no" required onblur="phvalidate();"></td>
                        <td>
                            <% 
                                String val2 = (String) request.getAttribute("msg2");
                                if (val2 != null) {
                                    out.print(val2);
                                }
                            %>
                        </td>
                        <td><span id="ph"></span></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center;"><button type="submit">Register</button></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
