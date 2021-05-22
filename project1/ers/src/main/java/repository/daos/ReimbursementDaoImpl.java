package repository.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repository.models.Reimbursement;
import repository.models.User;
import utils.ConnectionFactory;

public class ReimbursementDaoImpl implements ReimbursementDao {

    @Override
    public Reimbursement add(Reimbursement u) {
        Reimbursement result = null;
        String sql = "insert into reimbursement (amount, description, author_id, reimbursement_type_id) values (?, ?, ?, ? ) returning *";
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, u.getAmount());
            ps.setString(2, u.getDescription());
            ps.setInt(3, u.getAuthorId());
            ps.setInt(4, u.getReimbursementTypeId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reimbursement r = new Reimbursement(rs.getInt("id"), rs.getDouble("amount"), rs.getString("submitted"),
                        rs.getString("description"), rs.getInt("author_id"), rs.getInt("status_id"),
                        rs.getInt("reimbursement_type_id"));
                result = r;
            }
        } catch (SQLException e) {
            System.out.println("ReimbursementDoaImpl: add");
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public List<Reimbursement> getAllByEmp(User u) {
        List<Reimbursement> result = new ArrayList<Reimbursement>();
        // sql
        String sql = "select * from reimbursement where author_id = ?";
        // preparedstatment
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, u.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reimbursement r = new Reimbursement(rs.getInt("id"), rs.getDouble("amount"), rs.getString("submitted"),
                        rs.getString("resolved"), rs.getString("description"), rs.getString("receipt"),
                        rs.getInt("author_id"), rs.getInt("resolver_id"), rs.getInt("status_id"),
                        rs.getInt("reimbursement_type_id"));
                result.add(r);
            }
        } catch (SQLException e) {
            System.out.println("ReimbursementDoaImpl: getAllByEmp");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Reimbursement> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reimbursement get(Reimbursement i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(Reimbursement i) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int remove(Reimbursement i) {
        // TODO Auto-generated method stub
        return 0;
    }

}
