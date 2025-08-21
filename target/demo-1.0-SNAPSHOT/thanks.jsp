<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.business.User" %>
        <% User user=(User) request.getAttribute("user"); %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <title>Thank You!</title>
                <link rel="stylesheet" href="styles/main.css" type="text/css" />
            </head>

            <body>
                <h1>Thank You for Joining!</h1>
                <p>Here is the information you submitted:</p>

                <p><strong>First Name:</strong>
                    <%= user.getFirstName() %>
                </p>
                <p><strong>Last Name:</strong>
                    <%= user.getLastName() %>
                </p>
                <p><strong>Email:</strong>
                    <%= user.getEmail() %>
                </p>

                <p><a href="/emailList">Back to Join Form</a></p>
            </body>

            </html>