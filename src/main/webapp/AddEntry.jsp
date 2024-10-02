<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Entry</title>
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
        <h1>Write e-Diary</h1><br>
        <div class="content">
            <div class="image">
                <img src="./mydiary.jpg" alt="Diary Image">
            </div>
            <div class="form-container">
                <form action="AddEntry" method="post">
                    <div class="form-group">
                        <label for="date">Date</label>
                        <input type="date" id="date" name="date" required/>
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea id="description" name="desc" required placeholder="Enter the description"></textarea>
                    </div>
                    <div class="form-group">
                        <a href="Welcome.html" class="button">Home</a>
                        <button type="submit">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
