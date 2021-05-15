package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.models.User;

public class EmpReimbursementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // This is bad practice

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // call login service here from UserService

        // set session data
        // HttpSession instance = request.getSession();
        // session.setAttribute("userId", id);
        // session.setAttribute("username", username);
        // session.setAttribute("user-type", userType);
        // return json with username, userType and id back and status code 200

        // else
        // return status code 400

    };
}
