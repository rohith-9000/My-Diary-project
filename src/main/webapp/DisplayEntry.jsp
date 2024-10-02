<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Entry</title>
    <link rel="stylesheet" href="./Entries.css">
</head>
<body>
    <header>
        <div class="logo">My e-Diary</div>
        <div class="logout">
            <a href="Login.jsp">Log Out</a>
        </div>
    </header>
    <main>
        <h1>Read e-Diary</h1><br>
        <div class="content">
            <div class="image">
                <img src="./mydiary.jpg" alt="Diary Image">
            </div>
            <div class="form-container">
                <div class="form-group">
                    <label for="uid">Uid:</label>
                    <span id="uid" class="entry-value"><%= request.getAttribute("uid") %></span>
                </div>
                <div class="form-group">
                    <label for="date">Date:</label>
                    <span id="date" class="entry-value"><%= request.getAttribute("date") %></span>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <span id="description" class="entry-value"><%= request.getAttribute("description") %></span>
                </div>
                <div class="button-container">
                	<a href="DisplayAllEntry.jsp" class="button">Display All Entry</a>
                    <a href="Welcome.html" class="button">Home</a>
                </div>
            </div>
        </div>
    </main>
</body>
</html>
