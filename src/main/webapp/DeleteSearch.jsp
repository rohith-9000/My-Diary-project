<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Entry</title>
    <link rel="stylesheet" href="Entries.css">
</head>
<body>
    <header>
        <div class="logo">My e-Diary</div>
        <div class="logout">
            <a href="Login.jsp">Log Out</a>
        </div>
    </header>
    <main>
        <%
        String s = (String) request.getAttribute("msg");
        if (s != null) {
            out.print("<div class='message'>" + s + "</div>");
        }
        %>
        <h1>Search Entry</h1><br>
        <div class="content">
            <div class="image">
                <img src="./mydiary.jpg" alt="Diary Image">
            </div>
            <div class="form-container">
                <form action="DeleteEntry" method="post">
                    <div class="form-group">
                        <label for="date">Date</label>
                        <input type="date" id="date" name="date" required placeholder="Enter date"/>
                    </div>
                    <button type="submit">Submit</button>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
