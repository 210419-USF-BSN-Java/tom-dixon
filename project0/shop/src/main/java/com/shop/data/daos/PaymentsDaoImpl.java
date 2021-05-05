package com.shop.data.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.data.models.Payment;
import com.shop.util.ConnectionFactory;

public class PaymentsDaoImpl implements PaymentsDao {

//	public List<Payment> getAll() {
//		// get payments and group by user_id
//		List<Payment> results = new ArrayList<Payment>();
//
//		String sql = "select * from payments";
//		
//		return results;
//	}

	public int add(Payment payment) {
		int result = 0;
		String sql = "insert into payments (item_id, offer_id, user_id) values (?, ?, ?)";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, payment.getItemId());
			ps.setInt(2, payment.getOfferId());
			ps.setInt(3, payment.getUserId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("PaymentsDaoImpl: exception adding payment");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Payment> getAll() {
		List<Payment> result = new ArrayList<>();
		String sql = "select * from payments";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.add(new Payment(rs.getInt("id"), rs.getInt("item_id"), rs.getInt("offer_id"), rs.getInt("user_id")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PaymentsDaoImpl: exception getting payments");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Payment get(int i) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int update(int id, Payment i) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int remove(Payment i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
