package repository.daos;

import java.util.List;

import repository.models.Reimbursement;
import repository.models.User;

public interface ReimbursementDao {

    Reimbursement add(Reimbursement u);

    List<Reimbursement> getAll();

    List<Reimbursement> getAllByEmp(User u);

    Reimbursement get(Reimbursement i);

    int update(Reimbursement i);

    int remove(Reimbursement i);
}
