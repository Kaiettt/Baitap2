<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css" />
</head>

<body>
    <h2 style="font-size: 24px; color: #333;">Nguyen Anh Kiet - 23110246</h2>
    <h1>Join our email list</h1>
    <p>To join our email list, enter your name and email address below.</p>

    <!-- Form submits to the servlet -->
    <form action="emailList" method="post">
        <!-- hidden field to indicate the action -->
        <input type="hidden" name="action" value="add">

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>

        <label>&nbsp;</label>
        <input type="submit" value="Join Now" id="submit">
    </form>
</body>

</html>