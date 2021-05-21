package services;

import repository.daos.ReimbursementDao;
import repository.daos.ReimbursementDaoImpl;
import repository.models.Reimbursement;

public class ReimbursementService {
    private ReimbursementDao rDao = new ReimbursementDaoImpl();

    // public static void main(String[] args) {

    // // test add Reimbursement
    // // create reimbursement
    // Reimbursement re = new Reimbursement(30.00, "Bought some stuff", 10, 3);

    // Reimbursement result = rDao.add(re);
    // System.out.println(result.toString());

    // }

    public Reimbursement addReimbursement(Reimbursement re) {
        return rDao.add(re);
    }

}
