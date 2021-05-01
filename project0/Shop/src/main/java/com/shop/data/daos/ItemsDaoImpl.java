package com.shop.data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.shop.data.models.Item;
import com.shop.util.ConnectionFactory;

public class ItemsDaoImpl implements ItemsDao {

	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int add(Item i) {
		int result = 0;

		String sql = "insert into items (name, price)" + "values" + "(?, ?)";

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, i.getName());
			ps.setDouble(2, i.getPrice());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

		return result;
	}

	public Item get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Item update(int id, Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	public int remove(Item i) {
		int result = 0;
		// TODO Auto-generated method stub
		return result;
	}

}
