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

        // try get parameter
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = uService.login(username, password);
        // if valid,
        if (user != null) {
            if (user.getRoleId() == 1) {
                System.out.println("REROUTING TO MANAGER HOME");
                request.getRequestDispatcher("manager.html").forward(request, response);
            } else {
                System.out.println("REROUTING TO EMPLOYEE HOME");
                request.getRequestDispatcher("employee.html").forward(request, response);
            }
        } else {
            System.out.println("SOMETHING WENT WRONG");
        }

    };

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("HELLLLOOOOOOO");
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
