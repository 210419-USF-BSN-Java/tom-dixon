package com.shop.data.daos;

import com.shop.data.models.Payment;

public interface PaymentsDao extends GenericDao<Payment> {
	int add(Payment c);
}
