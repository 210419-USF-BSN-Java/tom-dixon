package com.shop.data.daos;

import java.util.List;

public interface GenericDao<I> {
	// CRUD operations
	I add(I i);
	I get(int i);
	List<I> getAll();
	I update(int id, I i);
	Integer remove(I i);
}
