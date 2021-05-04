package com.shop.data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.shop.data.models.Payment;
import com.shop.util.ConnectionFactory;

public class PaymentsDaoImpl implements PaymentsDao {

	public List<Payment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int add(Payment payment) {
		int result = 0;
		String sql = "insert into payments (item_id, offer_id, user_id) values(? , ? , ?)";

		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, payment.getItemId());
			ps.setInt(2, payment.getOfferId());
			ps.setInt(3, payment.getUserId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Payment get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(int id, Payment c) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int remove(Payment c) {
		int result = 0;
		// TODO Auto-generated method stub
		return result;
	}

}
