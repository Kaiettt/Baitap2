package com.email;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.User;
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
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        User user = new User(firstName, lastName, email);
        request.setAttribute("user", user);

        url = "/thanks.jsp"; // forward to thanks page
    } else {
        url = "/index.jsp"; // default to form page
    }

    getServletContext()
        .getRequestDispatcher(url)
        .forward(request, response);
}

}

