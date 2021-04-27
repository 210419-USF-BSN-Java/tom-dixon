package com.shop.data;

import com.shop.models.Customer;

public interface CustomersDao extends GenericDao<Object> {
	Customer add(Customer c);

	Customer get(int i);

	Customer update(int id, Customer c);

	Integer remove(Customer c);
}
