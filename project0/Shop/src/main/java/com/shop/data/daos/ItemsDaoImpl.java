package com.shop.data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.data.models.Item;
import com.shop.util.ConnectionFactory;

public class ItemsDaoImpl implements ItemsDao {

	public List<Item> getAll() {
		List<Item> items = new ArrayList<Item>();
		String sql = "select * from items";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Item item = new Item(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
				items.add(item);
			}
		} catch (SQLException e) {

		}
		return items;
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
			System.out.println("Exception thrown adding item");
			e.printStackTrace();
		}
		System.out.println("result in itemsImpl add: " + result);
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

		String sql = "delete from items where id = ?";

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i.getId());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception thrown removing item");
			e.printStackTrace();
		}
		return result;
	}

}