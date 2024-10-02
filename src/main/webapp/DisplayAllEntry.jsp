<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Display Entries by Month</title>
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
                <form action="DisplayAllEntry" method="get">
                    <div class="form-group">
                    <h1>Display Entries by Month</h1>
                        <label for="month">Select Month:</label>
                        <select name="month" id="month">
                            <option value="1">January</option>
                            <option value="2">February</option>
                            <option value="3">March</option>
                            <option value="4">April</option>
                            <option value="5">May</option>
                            <option value="6">June</option>
                            <option value="7">July</option>
                            <option value="8">August</option>
                            <option value="9">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                    </div>
                    <button type="submit">Display</button>
                    <a href="Welcome.html" class="button">Home</a>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
