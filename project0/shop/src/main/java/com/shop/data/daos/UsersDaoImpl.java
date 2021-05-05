package com.shop.data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.data.models.User;
import com.shop.util.ConnectionFactory;

public class UsersDaoImpl implements UsersDao {

	Connection conn;

	@Override
	public int add(User u) {
		int result = 0;
		String sql = "insert into users (user_type, first_name, last_name, username, pw)" + "values"
				+ "(?::user_type, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserType());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getUsername());
			ps.setString(5, u.getPassword());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();

		String sql = "select * from users";

		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);

			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("user_type"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("username"), rs.getString("pw")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	@Override
	public User get(String username) {

		User u = new User();
		String sql = "select * from users where username = ?";

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt("id"));
				u.setFirstName(rs.getString("first_name"));
				u.setUserType(rs.getString("user_type"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("pw"));
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}
		return u;
	}

	@Override
	public User get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int id, User u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(User u) {
		int result = 0;
		// TODO Auto-generated method stub
		return result;
	}

}
