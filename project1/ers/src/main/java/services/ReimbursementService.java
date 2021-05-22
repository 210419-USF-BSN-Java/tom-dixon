package services;

import java.util.List;

import repository.daos.ReimbursementDao;
import repository.daos.ReimbursementDaoImpl;
import repository.models.Reimbursement;
import repository.models.User;

public class ReimbursementService {
    private ReimbursementDao rDao = new ReimbursementDaoImpl();

    // public static void main(String[] args) {

    // // test add Reimbursement ****************** PASS
    // // create reimbursement
    // // Reimbursement re = new Reimbursement(30.00, "Bought some stuff", 10, 3);
    // // Reimbursement result = rDao.add(re);
    // // System.out.println(result.toString());
    // System.out.println("CALLED");
    // ;
    // // test get all Reimbursement by user ************ PASS
    // User u = new User();
    // u.setId(10);

    // List<Reimbursement> result = getReimbursementsByEmployee(u);
    // System.out.println("RESULT");
    // System.out.println(result.toString());
    // for (Reimbursement r : result) {
    // System.out.println("ONE PER ");
    // r.toString();
    // }

    // }

    public List<Reimbursement> getReimbursementsByEmployee(User u) {
        return rDao.getAllByEmp(u);
    }

    public Reimbursement addReimbursement(Reimbursement re) {
        return rDao.add(re);
    }

}
