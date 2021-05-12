package repository.daos;

import java.util.List;

import repository.models.Reimbursement;

public interface ReimbursementDao {

    Reimbursement add(Reimbursement u);

    List<Reimbursement> getAll();

    Reimbursement get(Reimbursement i);

    int update(Reimbursement i);

    int remove(Reimbursement i);
}
