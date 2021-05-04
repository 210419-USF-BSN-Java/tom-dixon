package com.shop.data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.data.models.Item;
import com.shop.data.models.Offer;
import com.shop.data.models.User;
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

	public int update(Item item) {
		int result = 0;
		String sql = "update items set remaining_payments = ?, balance = ? where id = ? ";

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, item.getRemainingPayments());
			ps.setDouble(2, item.getBalance());
			ps.setInt(3, item.getId());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("ItemDaoImpl: Exception updating Item");
			e.printStackTrace();
		}
		return result;
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

	@Override
	public int assignOwnership(Item item, Offer offer) {
		int result = 0;
		String sql = "update items set owned_by = ?, remaining_payments = ?, balance = ?, accepted_offer = ? where id = ? ";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, offer.getCustId());
			ps.setInt(2, offer.getWeeks());
			ps.setDouble(3, offer.getGross());
			ps.setInt(4, offer.getId());
			ps.setInt(5, item.getId());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("ItemsDaoImpl: Exception assigning ownership");
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public List<Item> getOwnersItems(User u) {
		List<Item> items = new ArrayList<Item>();
		String sql = "select * from items where owned_by = ?";

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				items.add(new Item(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("owned_by"),
						rs.getInt("remaining_payments"), rs.getDouble("balance"), rs.getInt("accepted_offer")));
			}
		} catch (SQLException e) {
			System.out.println("ItemsDaoImpl: exception thrown retrieving a user's items");
			e.printStackTrace();
		}
		return items;
	}

	@Override
	public List<Item> getAllUnowned() {
		List<Item> items = new ArrayList<Item>();
		String sql = "select * from items where owned_by is null";
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

}
