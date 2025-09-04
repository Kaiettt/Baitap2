<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <c:import url="/includes/header.jsp" />
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

                    <p><a href="/email_list">Back to Join Form</a></p>
                    <c:import url="/includes/footer.jsp" />
                </body>

                </html>