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
        <h1>Update e-Diary</h1><br>
        <div class="content">
            <div class="image">
                <img src="./mydiary.jpg" alt="Diary Image">
            </div>
            <div class="form-container">
                <form method="post" action="SaveEntry">
                    <div class="form-group">
                        <label for="date">Date:</label>
                        <input type="date" name="date" id="date" value="${Date}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="desc">Description:</label>
                        <textarea name="desc" id="desc" required>${Description}</textarea>
                    </div>
                    <button type="submit">Save</button>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
