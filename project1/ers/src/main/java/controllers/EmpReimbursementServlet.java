package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
// import javax.servlet.http.Cookie;
// import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.models.Reimbursement;
import repository.models.User;
import services.ReimbursementService;
import utils.JsonConverter;

@WebServlet(name = "emp-reimbursement", urlPatterns = { "/main/emp-reimbursement" })
public class EmpReimbursementServlet extends HttpServlet {

    private ReimbursementService rService = new ReimbursementService();

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        // try get parameter
        String amount = req.getParameter("amount");
        String descr = req.getParameter("description");
        String empId = req.getParameter("empId");
        String typeId = req.getParameter("type");

        System.out.println("###########################");
        System.out.println(amount);
        System.out.println(descr);
        System.out.println(empId);
        System.out.println(typeId);

        // add to db
        Reimbursement re = rService.addReimbursement(new Reimbursement(Double.parseDouble(amount), descr,
                Integer.parseInt(empId), Integer.parseInt(typeId)));
        // set output type for message
        res.setContentType("application/json;charset=UTF-8");
        ServletOutputStream jsonOut = res.getOutputStream();

        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(re);
        jsonOut.print(output);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // returns all of a single employees reimbursement reqs

        // retrieve emp id from cookie and create user
        int id = 10;
        User u = new User();
        u.setId(id);
        List<Reimbursement> result = rService.getReimbursementsByEmployee(u);
        // set output type for message
        res.setContentType("application/json;charset=UTF-8");
        ServletOutputStream jsonOut = res.getOutputStream();

        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(result);
        jsonOut.print(output);

    }

};
