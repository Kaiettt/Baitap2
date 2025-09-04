package com.email;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.User;
import com.data.UserDB;
public class EmailListServlet extends HttpServlet {

    @Override
protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
        throws ServletException, IOException {

    String url = "/index.jsp"; // show form by default
    String action = request.getParameter("action");
    if (action == null) {
        action = "join"; // default action
    }

    if (action.equals("add")) {
        // Usually GET shouldn't add a user; just show form
        url = "/index.jsp";
    }
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    request.setAttribute("currentYear", currentYear);

    getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {

    String action = request.getParameter("action");
    if (action == null) {
        action = "join";
    }

    String url;
    if (action.equals("add")) {
         // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // store data in User object
            User user = new User(firstName, lastName, email);

            // validate the parameters
            String message;
            if (firstName == null || lastName == null || email == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill out all three text boxes.";
                url = "/index.jsp";
            } 
            else {
                message = null;
                url = "/thanks.jsp";
                UserDB.insert(user);
            }
            request.setAttribute("user", user);
            request.setAttribute("message", message);
    } else {
        url = "/index.jsp"; // default to form page
    }
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    request.setAttribute("currentYear", currentYear);

    getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
}

}

