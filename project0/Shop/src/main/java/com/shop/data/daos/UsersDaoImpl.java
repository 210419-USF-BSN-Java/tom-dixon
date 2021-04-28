package com.shop.data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.shop.data.models.User;
import com.shop.util.ConnectionFactory;

public class UsersDaoImpl implements UsersDao {

	Connection conn;

	@Override
	public int add(User u) {
		int result = 0;
		String sql = "insert into users (user_type, first_name, last_name, username, pw)" + "values" + "(?::user_type, ?, ?, ?, ?)";

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
		// TODO Auto-generated method stub
		return null;
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
	public User update(int id, User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(User u) {
		int result = 0;
		// TODO Auto-generated method stub
		return result;
	}

}
