package repository.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import repository.models.User;
import utils.ConnectionFactory;

public class UserDaoImpl implements UserDao {

    @Override
    public int add(User u) {
        return 0;
    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User get(User i) {
        User result = null;
        String sql = "select * from users where id = ?";
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, i.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("role"), rs.getString("email"), rs.getString("username"));
                result = u;
            }
        } catch (SQLException e) {
            System.out.println("UserDaoImpl exception: get");
        }
        return result;
    }

    @Override
    public User getByUsername(String username) {
        User result = null;
        String sql = "select * from users where username = ?";
        try (Connection con = ConnectionFactory.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("role"), rs.getString("email"), rs.getString("username"),
                        rs.getString("password"));
                result = u;
            }
        } catch (SQLException e) {
            System.out.println("UserDaoImpl exception: get");
        }
        return result;
    }

    @Override
    public User update(User i) {
        User result = null;
        // TODO Auto-generated method stub
        return result;
    }

    @Override
    public int remove(User i) {
        // TODO Auto-generated method stub
        return 0;
    }

}
