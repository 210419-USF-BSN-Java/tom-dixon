package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.models.User;
import services.UserService;

public class LoginServlet extends HttpServlet {

    private UserService uService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // This is bad practice

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // call login service here from UserService
        User user = uService.login(username, password);
        // if valid,
        if (user != null) {
            if (user.getRoleId() == 1) {
                System.out.println("REROUTING TO MANAGER HOME");
                request.getRequestDispatcher("managerHome").forward(request, response);
            } else {
                System.out.println("REROUTING TO EMPLOYEE HOME");
            }
        } else {
            System.out.println("SOMETHING WENT WRONG");
        }
        // set session data
        // HttpSession instance = request.getSession();
        // session.setAttribute("userId", id);
        // session.setAttribute("username", username);
        // session.setAttribute("user-type", userType);
        // return json with username, userType and id back and status code 200

        // else
        // return status code 400

    };

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
