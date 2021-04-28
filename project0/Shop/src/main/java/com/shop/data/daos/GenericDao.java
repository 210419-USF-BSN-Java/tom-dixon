package com.shop.data.daos;

import java.util.List;

public interface GenericDao<I> {
	// CRUD operations
	int add(I i);
	I get(int i);
	List<I> getAll();
	I update(int id, I i);
	int remove(I i);
}
