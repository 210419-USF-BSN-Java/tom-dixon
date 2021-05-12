package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // This is bad practice
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter pw = response.getWriter();

        // call login service here from UserService

        // if valid,
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
