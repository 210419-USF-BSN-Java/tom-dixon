package com.shop.data.daos;

import com.shop.data.models.Payment;

public interface PaymentsDao extends GenericDao<Payment> {
	Payment add(Payment c);

	Payment get(int i);

	Payment update(int id, Payment c);

	Integer remove(Payment c);
}
