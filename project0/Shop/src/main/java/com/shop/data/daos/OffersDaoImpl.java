package com.shop.data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.shop.data.models.Offer;
import com.shop.util.ConnectionFactory;

public class OffersDaoImpl implements OffersDao {

	public List<Offer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int add(Offer o) {
		int result = 0;
		String sql = "insert into offers (item_id, down_payment, weeks, per_week_amount, customer_id, gross)" + "values"
				+ "(?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, o.getItemId());
			ps.setDouble(2, o.getDownPayment());
			ps.setInt(3, o.getWeeks());
			ps.setDouble(4, o.getPaymentPerWeek());
			ps.setInt(5, o.getCustId());
			ps.setDouble(6, o.getGross());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Exception thrown adding offer");
			e.printStackTrace();
		}
		return result;
	}

	public Offer get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Offer update(int id, Offer c) {
		// TODO Auto-generated method stub
		return null;
	}

	public int remove(Offer c) {
		int result = 0;
		// TODO Auto-generated method stub
		return result;
	}

}
