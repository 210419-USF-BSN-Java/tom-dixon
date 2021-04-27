package com.shop.data;

public interface GenericDao<I> {
	// CRUD operations
	I add(I i);
	I get(int i);
	I update(int id, I i);
	Integer remove(I i);
}
