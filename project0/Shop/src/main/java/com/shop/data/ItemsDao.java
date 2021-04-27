package com.shop.data;

import com.shop.models.Item;

public interface ItemsDao extends GenericDao<Object> {
	// CRUD operations
	Integer add(Item i);

	Item get(int i);

	Item update(Item i);

	Integer remove(Item i);
}
