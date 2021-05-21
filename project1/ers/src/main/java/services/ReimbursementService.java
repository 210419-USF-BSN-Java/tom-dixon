package services;

import repository.daos.ReimbursementDao;
import repository.daos.ReimbursementDaoImpl;
import repository.models.Reimbursement;

public class ReimbursementService {

    private ReimbursementDao rDao = new ReimbursementDaoImpl();

    public Reimbursement addReimbursement(Reimbursement re) {
        return rDao.add(re);
    }

}
