package com.shop.data;

import com.shop.models.Payment;

public interface PaymentsDao extends GenericDao<Object> {
	Payment add(Payment c);

	Payment get(int i);

	Payment update(int id, Payment c);

	Integer remove(Payment c);
}
